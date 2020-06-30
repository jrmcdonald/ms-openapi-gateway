package com.jrmcdonald.openapi.gateway.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("unit-test")
@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SwaggerConfigControllerTest {

    @Autowired
    WebTestClient webTestClient;

    @Test
    @DisplayName("Should generate swagger-config.json")
    void shouldGenerateSwaggerConfigJson() {
        EntityExchangeResult<String> result = webTestClient.get().uri("/swagger-config.json")
                                                           .accept(MediaType.APPLICATION_JSON)
                                                           .exchange()
                                                           .expectStatus().isOk()
                                                           .expectBody(String.class)
                                                           .returnResult();

        assertThat(result.getResponseBody()).isEqualTo("{\"urls\":[{\"url\":\"/customer-orchestration/v3/api-docs\",\"name\":\"customer-orchestration\"}]}");
    }
}