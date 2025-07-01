package com.lucas.ms2.Service;


import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Optional;

@Service
public class PedidosService {

    private HttpClient client = HttpClient.newHttpClient();

    public Optional<String> getAvaliableProducts() {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .timeout(Duration.ofSeconds(5))
                .uri(URI.create("http://localhost:8180"))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            System.out.println("Deu ruim na rquisição");
        }
        assert response != null;
        return response.body() != null ? Optional.of(response.body()) : Optional.empty();
    }
}
