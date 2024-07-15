package com.jardel.gutendexapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BookController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/books")
    public ResponseEntity<String> getBooks(@RequestParam String query) {
        String url = "https://gutendex.com/books?search=" + query;
        String response = restTemplate.getForObject(url, String.class);
        return ResponseEntity.ok(response);
    }
}
