package com.var.one.clients;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class RestClient {

    @Value("${root.entrypoint}")
    private String rootEntrypoint;

    private final ObjectMapper mapper = new ObjectMapper();

    public Object get(String url, Class<?> clazz) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(rootEntrypoint + url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return mapper.readValue(response.body(), clazz);
    }

    public <T> T post(String url, Object request, TypeReference<T> responseType) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest httpRequest = HttpRequest.newBuilder().POST(HttpRequest.BodyPublishers.ofString(new Gson().toJson(request)))
                .header("Content-Type", "application/json").uri(URI.create(rootEntrypoint + url)).build();
        HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return mapper.readValue(response.body(), responseType);
    }

    public void put(String url, Object request) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest httpRequest = HttpRequest.newBuilder().PUT(HttpRequest.BodyPublishers.ofString(new Gson().toJson(request)))
                .header("Content-Type", "application/json").uri(URI.create(rootEntrypoint + url)).build();
        client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
    }

    public void delete(String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder().DELETE().uri(URI.create(rootEntrypoint + url)).build();
        client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
