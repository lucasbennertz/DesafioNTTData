package com.lucas.ms2.Service;


import org.springframework.stereotype.Service;

import com.lucas.ms2.Model.Products;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PedidosService {

    private HttpClient client = HttpClient.newHttpClient();
    private ObjectMapper mapper = new ObjectMapper();
    public Optional<List<Products>> getAvaliableProducts() {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .timeout(Duration.ofSeconds(5))
                .uri(URI.create("http://localhost:8180/produtos"))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            System.out.println("Deu ruim na requisição");
        }
        if (response == null || response.body() == null) {
            return Optional.empty();
        }
        return Optional.of(response.body().isEmpty() ? 
                new ArrayList<>() : 
                Arrays.stream(response.body().split(","))
                      .map(String::trim)
                      .map(name -> {
                          Products product = new Products();
                          product.setName(name);
                          return product;
                      })
                      .toList());
    }

    public List<String> createOrder(List<Products> order) {
        List<Products> products = order;
        List<Products> productsOnOrder = new ArrayList<>();
        List<Products> productsAlreadyExixsting = getAvaliableProducts().orElse(null);

        products.forEach(product -> {
            if (productsAlreadyExixsting != null && !productsAlreadyExixsting.contains(product)) {
                System.out.println("Produto " + product + " não está disponível.");
                createProduct(product);
                productsOnOrder.add(product);
            } else {
                System.out.println("Pedido criado para o produto: " + product);
                productsOnOrder.add(product);
            }
        });
        return productsOnOrder.stream()
                .map(Products::getName)
                .toList();  
    }
    private void createProduct(Products product) {
    try {
        String body = mapper.writeValueAsString(product);
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .uri(URI.create("http://localhost:8180/produtos/create"))
                .header("Content-Type", "application/json")
                .build();
        System.out.println("Enviando requisição para criar produto: " + body);
        client.send(request, HttpResponse.BodyHandlers.ofString());
    } catch (IOException | InterruptedException e) {
        System.out.println("Erro ao criar produto: " + e.getMessage());
    }
}
}
