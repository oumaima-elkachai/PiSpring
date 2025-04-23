package com.example.attendance.Backend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FaceRecognitionController {

    private final RestTemplate restTemplate;

    @PostMapping("/verify-face")
    public ResponseEntity<Boolean> verifyFace(@RequestBody Map<String, String> images) {
        String fastApiUrl = "http://localhost:8000/verify-face";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(images, headers);
        ResponseEntity<Boolean> response = restTemplate.postForEntity(fastApiUrl, request, Boolean.class);

        return ResponseEntity.ok(response.getBody());
    }
}