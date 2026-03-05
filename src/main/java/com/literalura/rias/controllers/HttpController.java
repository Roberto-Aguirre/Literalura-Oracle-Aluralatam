package com.literalura.rias.controllers;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.literalura.rias.entities.DTOS.ResponseLibros;


@Component // Usamos Component ya que parece una herramienta de servicio, no un endpoint web
public class HttpController {
    
    private final HttpClient httpClient = HttpClient.newHttpClient();
    // Spring llamará a este constructor automáticamente pasando el Bean de Gson
    
    public void getInfo(String nombreLibro) {

    LibroMapper libroMapper = new LibroMapper();
    Gson gson = new Gson();
        // Tu lógica actual...
        String url = "https://gutendex.com/books/?search=" + mapLibro(nombreLibro);
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build();
            
        try {
            var responseJson = httpClient.send(request, HttpResponse.BodyHandlers.ofString()).body();
            ResponseLibros response = gson.fromJson(responseJson, ResponseLibros.class);
            libroMapper.mapResponse(response);
            // System.out.println("Respuesta recibida: " + response);
        } catch (Exception e) {
            System.err.println("Error en la petición: " + e.getMessage());
        }
    }

    public String mapLibro(String libro){
        return libro.replace(" ", "+");
    }
}