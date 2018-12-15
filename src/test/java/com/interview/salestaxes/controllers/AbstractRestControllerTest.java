package com.interview.salestaxes.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;


public abstract class AbstractRestControllerTest {

    public static String asJsonString(final Object obj) {
        //Object to JSON in String
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
