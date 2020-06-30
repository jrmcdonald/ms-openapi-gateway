package com.jrmcdonald.openapi.gateway.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.boot.context.properties.source.MapConfigurationPropertySource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class OpenApiEndpointsConfigurationPropertiesTest {

    @Test
    @DisplayName("Should bind gateway-prefix when set")
    void shouldBindGatewayPrefixWhenSet() {
        Map<String, String> properties = new HashMap<>();
        properties.put("endpoints.test_endpoint.gateway-prefix", "value");

        Binder binder = new Binder(new MapConfigurationPropertySource(properties));
        BindResult<OpenApiEndpointsConfigurationProperties> bindResult = binder.bind("", Bindable.of(OpenApiEndpointsConfigurationProperties.class));

        assertThat(bindResult.get().getEndpoints().get("test_endpoint").getGatewayPrefix()).isEqualTo("value");
    }

    @Test
    @DisplayName("Should bind service-url when set")
    void shouldBindServiceUrlWhenSet() {
        Map<String, String> properties = new HashMap<>();
        properties.put("endpoints.test_endpoint.service-url", "value");

        Binder binder = new Binder(new MapConfigurationPropertySource(properties));
        BindResult<OpenApiEndpointsConfigurationProperties> bindResult = binder.bind("", Bindable.of(OpenApiEndpointsConfigurationProperties.class));

        assertThat(bindResult.get().getEndpoints().get("test_endpoint").getServiceUrl()).isEqualTo("value");
    }

    @Test
    @DisplayName("Should bind service-path when set")
    void shouldBindServicePathWhenSet() {
        Map<String, String> properties = new HashMap<>();
        properties.put("endpoints.test_endpoint.service-path", "value");

        Binder binder = new Binder(new MapConfigurationPropertySource(properties));
        BindResult<OpenApiEndpointsConfigurationProperties> bindResult = binder.bind("", Bindable.of(OpenApiEndpointsConfigurationProperties.class));

        assertThat(bindResult.get().getEndpoints().get("test_endpoint").getServicePath()).isEqualTo("value");
    }
}