package com.jrmcdonald.openapi.gateway.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SwaggerUrl {

    private final String url;
    private final String name;
}
