package org.agh.service;


import lombok.RequiredArgsConstructor;
import org.agh.exception.PlayerNotFoundException;
import org.agh.exception.QuoteServiceException;
import org.agh.model.Quote;
import org.agh.model.player.ApiResponse;
import org.agh.model.player.Player;
import org.agh.model.player.PlayerData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class NBAService {

    @Value("${app.apikey}")
    private String token;

    @Value("${app.basketballUrl}")
    private String basketballUrl;

    @Value("${app.quoteApiUrl}")
    private String quoteApiUrl;

    @Value("${app.quoteApiKey}")
    private String quoteApiKey;

    private static final RestTemplate restTemplate = new RestTemplate();


    public Player retrievePlayerInfo(PlayerData playerData) {
        List<Player> foundPLayers;
        String url = basketballUrl + "/players";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("per_page", 100);
        if (playerData.getFirstName() != null && !playerData.getFirstName().isEmpty()) {
            builder.queryParam("first_name", playerData.getFirstName());
        }
        if (playerData.getLastName() != null && !playerData.getLastName().isEmpty()) {
            builder.queryParam("last_name", playerData.getLastName());
        }


        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<ApiResponse> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<>() {
                }
        );

        if (response.getStatusCode() == HttpStatus.OK
                && response.getBody() != null
                && response.getBody().getData() != null
                && !response.getBody().getData().isEmpty()) {
            foundPLayers = new ArrayList<>(response.getBody().getData());
        } else {
            throw new PlayerNotFoundException("Player not found with name: " + playerData.getFirstName() + " " + playerData.getLastName());
        }

        if (foundPLayers.isEmpty()) {
            throw new PlayerNotFoundException("Player not found with name: " + playerData.getFirstName() + " " + playerData.getLastName());
        }
        return foundPLayers.get(0);
    }


    public List<Player> retrievePlayerTeam(Integer teamId) {
        List<Player> foundPlayers = null;
        String url = basketballUrl + "/players?team_ids[]=" + teamId;


        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<ApiResponse> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<>() {
                }
        );

        if (response.getStatusCode() == HttpStatus.OK
                && response.getBody() != null
                && response.getBody().getData() != null
                && !response.getBody().getData().isEmpty()) {
            foundPlayers = new ArrayList<>(response.getBody().getData());
        } else {
            throw new PlayerNotFoundException("Players not found for team: " + teamId);
        }

        if (foundPlayers == null || foundPlayers.isEmpty()) {
            throw new PlayerNotFoundException("Players not found for team: " + teamId);
        }
        return foundPlayers;
    }

    public String getMotivationalQuote() {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("X-RapidAPI-Key", quoteApiKey);
            headers.set("X-RapidAPI-Host", "thought-of-the-day.p.rapidapi.com");
            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<Quote> response = restTemplate.exchange(
                    URI.create(quoteApiUrl),
                    HttpMethod.GET,
                    entity,
                    Quote.class
            );

            return Objects.requireNonNull(response.getBody()).getData();
        } catch (Exception ex) {
            throw new QuoteServiceException("Failed to fetch the motivational quote", ex);
        }
    }
}
