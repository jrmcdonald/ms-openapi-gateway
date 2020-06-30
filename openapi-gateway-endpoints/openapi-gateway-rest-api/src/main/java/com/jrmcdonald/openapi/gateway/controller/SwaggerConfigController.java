package com.jrmcdonald.openapi.gateway.controller;

import com.jrmcdonald.openapi.gateway.config.OpenApiEndpointsConfigurationProperties;
import com.jrmcdonald.openapi.gateway.model.SwaggerConfig;
import com.jrmcdonald.openapi.gateway.model.SwaggerUrl;

import io.swagger.v3.oas.annotations.Hidden;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

@Hidden
@RestController
@RequiredArgsConstructor
public class SwaggerConfigController {

    private final OpenApiEndpointsConfigurationProperties properties;

    @GetMapping("/swagger-config.json")
    public Mono<SwaggerConfig> swaggerConfig() {
        return Mono.just(properties.getEndpoints()
                                   .entrySet()
                                   .stream()
                                   .map(entry -> new SwaggerUrl(entry.getValue().getGatewayPrefix() + entry.getValue().getServicePath(), entry.getKey()))
                                   .collect(collectingAndThen(toList(), SwaggerConfig::new)));
    }
}
