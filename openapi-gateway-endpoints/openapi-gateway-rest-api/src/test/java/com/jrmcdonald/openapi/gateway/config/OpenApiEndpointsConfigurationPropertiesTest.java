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

    private static final String EXPECTED_VALUE = "value";
    private static final String TEST_ENDPOINT = "test_endpoint";

    @Test
    @DisplayName("Should bind gateway-prefix when set")
    void shouldBindGatewayPrefixWhenSet() {
        Map<String, String> properties = new HashMap<>();
        properties.put("endpoints.test_endpoint.gateway-prefix", EXPECTED_VALUE);

        Binder binder = new Binder(new MapConfigurationPropertySource(properties));
        BindResult<OpenApiEndpointsConfigurationProperties> bindResult = binder.bind("", Bindable.of(OpenApiEndpointsConfigurationProperties.class));

        assertThat(bindResult.get().getEndpoints().get(TEST_ENDPOINT).getGatewayPrefix()).isEqualTo(EXPECTED_VALUE);
    }

    @Test
    @DisplayName("Should bind service-url when set")
    void shouldBindServiceUrlWhenSet() {
        Map<String, String> properties = new HashMap<>();
        properties.put("endpoints.test_endpoint.service-url", EXPECTED_VALUE);

        Binder binder = new Binder(new MapConfigurationPropertySource(properties));
        BindResult<OpenApiEndpointsConfigurationProperties> bindResult = binder.bind("", Bindable.of(OpenApiEndpointsConfigurationProperties.class));

        assertThat(bindResult.get().getEndpoints().get(TEST_ENDPOINT).getServiceUrl()).isEqualTo(EXPECTED_VALUE);
    }

    @Test
    @DisplayName("Should bind service-prefix when set")
    void shouldBindServicePrefixWhenSet() {
        Map<String, String> properties = new HashMap<>();
        properties.put("endpoints.test_endpoint.service-prefix", EXPECTED_VALUE);

        Binder binder = new Binder(new MapConfigurationPropertySource(properties));
        BindResult<OpenApiEndpointsConfigurationProperties> bindResult = binder.bind("", Bindable.of(OpenApiEndpointsConfigurationProperties.class));

        assertThat(bindResult.get().getEndpoints().get(TEST_ENDPOINT).getServicePrefix()).isEqualTo(EXPECTED_VALUE);
    }

    @Test
    @DisplayName("Should bind service-path when set")
    void shouldBindServicePathWhenSet() {
        Map<String, String> properties = new HashMap<>();
        properties.put("endpoints.test_endpoint.service-path", EXPECTED_VALUE);

        Binder binder = new Binder(new MapConfigurationPropertySource(properties));
        BindResult<OpenApiEndpointsConfigurationProperties> bindResult = binder.bind("", Bindable.of(OpenApiEndpointsConfigurationProperties.class));

        assertThat(bindResult.get().getEndpoints().get(TEST_ENDPOINT).getServicePath()).isEqualTo(EXPECTED_VALUE);
    }
}