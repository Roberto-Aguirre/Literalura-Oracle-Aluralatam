package com.literalura.rias.controllers;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.literalura.rias.entities.Autor;
import com.literalura.rias.entities.Libro;
import com.literalura.rias.entities.DTOS.ResponseLibros;

@Component
public class HttpController {

    private final HttpClient httpClient = HttpClient.newHttpClient();
    // Spring llamará a este constructor automáticamente pasando el Bean de Gson

    public HashMap<Libro, Autor> getInfo(String nombreLibro) {

        LibroMapper libroMapper = new LibroMapper();
        Gson gson = new Gson();
        // Tu lógica actual...
        String url = "https://gutendex.com/books/?search=" + mapLibro(nombreLibro);
        System.out.println("Realizando petición a: " + url);
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        try {
            var responseJson = httpClient.send(request, HttpResponse.BodyHandlers.ofString()).body();
            ResponseLibros response = gson.fromJson(responseJson, ResponseLibros.class);
            System.out.println("Respuesta JSON recibida: " + responseJson);
            Libro libro = libroMapper.mapResponseLibro(response);
            Autor autor = libroMapper.mapResponseAutor(response);

            HashMap<Libro, Autor> respuesta = new HashMap<>();
            respuesta.put(libro, autor);
            System.out.println(respuesta);
            return respuesta;
        } catch (Exception e) {
            System.err.println("Error en la petición: " + e.getMessage());
            throw new RuntimeException("Error al obtener información del libro", e);
        }
    }

    public String mapLibro(String libro) {
        System.out.println("Buscando libro: " + libro);
        return libro.replace(" ", "+");
    }
}