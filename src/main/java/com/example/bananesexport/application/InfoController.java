package com.example.bananesexport.application;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.BuildProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/info")
@RequiredArgsConstructor
public class InfoController {

    @Value("${app.env}")
    private String env;

    private final BuildProperties buildProperties;

    @GetMapping
    public ResponseEntity<String> getInfo() {
        return ResponseEntity.ok().body(String.format("Env: %s - Version: %s", env, buildProperties.getVersion()));
    }
}
