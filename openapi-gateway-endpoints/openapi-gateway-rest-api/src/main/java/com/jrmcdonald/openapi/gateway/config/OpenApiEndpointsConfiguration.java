package com.jrmcdonald.openapi.gateway.config;

import com.jrmcdonald.openapi.gateway.config.OpenApiEndpointsConfigurationProperties.Endpoint;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.route.Route.AsyncBuilder;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
@EnableConfigurationProperties(OpenApiEndpointsConfigurationProperties.class)
public class OpenApiEndpointsConfiguration {

    @Bean
    @RefreshScope
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder, OpenApiEndpointsConfigurationProperties properties) {
        Builder routes = routeLocatorBuilder.routes();

        properties.getEndpoints()
                  .forEach((key, endpoint) -> routes.route(routeForJsonRequests(endpoint)));

        return routes.build();
    }

    private Function<PredicateSpec, AsyncBuilder> routeForJsonRequests(Endpoint endpoint) {
        return r -> r.path(endpoint.getServicePrefix() + endpoint.getServicePath())
                     .filters(f -> f.setPath(endpoint.getServicePath()))
                     .uri(endpoint.getServiceUrl());
    }
}
