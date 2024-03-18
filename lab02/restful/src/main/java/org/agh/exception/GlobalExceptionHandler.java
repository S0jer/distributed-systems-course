package org.agh.exception;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(QuoteServiceException.class)
    public String handleQuoteServiceError(HttpServletRequest request, QuoteServiceException ex) {
        request.setAttribute(RequestDispatcher.ERROR_STATUS_CODE, HttpStatus.BAD_REQUEST.value());
        return "400";
    }

    @ExceptionHandler(HttpClientErrorException.Unauthorized.class)
    public String handleUnauthorized(HttpServletRequest request, HttpClientErrorException.Unauthorized ex) {
        request.setAttribute(RequestDispatcher.ERROR_STATUS_CODE, HttpStatus.UNAUTHORIZED.value());
        return "401";
    }

    @ExceptionHandler(PlayerNotFoundException.class)
    public String handlePlayerNotFound(HttpServletRequest request, PlayerNotFoundException ex) {
        request.setAttribute(RequestDispatcher.ERROR_STATUS_CODE, HttpStatus.NOT_FOUND.value());
        return "404";
    }

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public String handleNotFound(HttpServletRequest request, HttpClientErrorException.NotFound ex) {
        request.setAttribute(RequestDispatcher.ERROR_STATUS_CODE, HttpStatus.NOT_FOUND.value());
        return "404";
    }

    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    public String handleInternalServerError(HttpServletRequest request, HttpServerErrorException.InternalServerError ex) {
        request.setAttribute(RequestDispatcher.ERROR_STATUS_CODE, HttpStatus.INTERNAL_SERVER_ERROR.value());
        return "500";
    }

    @ExceptionHandler(Exception.class)
    public String handleAllUncaughtException(HttpServletRequest request, Exception ex) {
        logger.error("Unhandled exception occurred", ex);
        request.setAttribute(RequestDispatcher.ERROR_STATUS_CODE, HttpStatus.INTERNAL_SERVER_ERROR.value());
        return "500";
    }


    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String htmlContent = readFileAsString("src/main/resources/templates/404.html");

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.TEXT_HTML);

        return new ResponseEntity<>(htmlContent, responseHeaders, HttpStatus.NOT_FOUND);
    }

    private String readFileAsString(String filePath) {
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(filePath));
            return new String(encoded, StandardCharsets.UTF_8);
        } catch (IOException e) {
            return "<html><body><h1>Error</h1><p>Error reading the error page content.</p></body></html>";
        }
    }

}
