package com.example.demo.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {

    private int code;
    private String message;
    private String value;

    public ErrorDetails(int code, String message) {
        this.code = code;
        this.message = message;
    }
}