package com.jrmcdonald.openapi.gateway.model;

import org.force66.beantester.BeanTester;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.util.Collections.emptyList;

class SwaggerConfigTest {

    @Test
    @DisplayName("Should construct a valid bean")
    void shouldConstructAValidBean() {
        BeanTester beanTester = new BeanTester();
        beanTester.testBean(SwaggerConfig.class, new Object[]{emptyList()});
    }
}