package org.agh.exception;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
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
}
