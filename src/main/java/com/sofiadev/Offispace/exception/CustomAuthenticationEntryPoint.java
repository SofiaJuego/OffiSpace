package com.sofiadev.Offispace.exception;

public class CustomAuthenticationEntryPoint extends RuntimeException {
    public CustomAuthenticationEntryPoint(String message) {
        super(message);
    }
}
