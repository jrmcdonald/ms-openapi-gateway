package com.jrmcdonald.openapi.gateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.Map;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@ConstructorBinding
@ConfigurationProperties(prefix = "openapi")
@RequiredArgsConstructor
public class OpenApiEndpointsConfigurationProperties {

    private final Map<String, Endpoint> endpoints;

    @Getter
    @RequiredArgsConstructor
    public static class Endpoint {

        private final String gatewayPrefix;
        private final String serviceUrl;
        private final String servicePath;
    }
}
