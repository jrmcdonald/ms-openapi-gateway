package com.jrmcdonald.openapi.gateway.model;

import java.util.List;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SwaggerConfig {

    private final List<SwaggerUrl> urls;
}
