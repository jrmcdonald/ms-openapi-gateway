package com.jrmcdonald.openapi.gateway.config;

import com.jrmcdonald.openapi.gateway.Application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;

import lombok.SneakyThrows;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = Application.class)
@AutoConfigureWebTestClient
@ActiveProfiles("unit-test")
class OpenApiEndpointsConfigurationTest {

    private static final int API_DOCS_SERVER_PORT = 8081;

    @Autowired
    WebTestClient webTestClient;

    private MockWebServer mockApiDocsServer;

    @SneakyThrows
    @BeforeEach
    void beforeEach() {
        mockApiDocsServer = new MockWebServer();
        mockApiDocsServer.start(API_DOCS_SERVER_PORT);
    }

    @Test
    @SneakyThrows
    @DisplayName("Should route requests to openapi docs")
    void shouldRouteRequestsToOpenapiDocs() {
        MockResponse apiDocsResponse = new MockResponse();
        apiDocsResponse.setBody("apiDocsResponse");

        mockApiDocsServer.enqueue(apiDocsResponse);

        EntityExchangeResult<String> result = webTestClient.get().uri("/customer-orchestration/v3/api-docs")
                                                           .exchange()
                                                           .expectStatus().isOk()
                                                           .expectBody(String.class)
                                                           .returnResult();

        assertThat(result.getResponseBody()).isEqualTo("apiDocsResponse");

        RecordedRequest apiDocsRequest = mockApiDocsServer.takeRequest();
        assertThat(apiDocsRequest.getPath()).isEqualTo("/v3/api-docs");
    }
}