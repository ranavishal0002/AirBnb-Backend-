package com.VishalProject.AirBnbProject.AirBnbApp.advice;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {
    private LocalDateTime timeStamp;
    private T data;
    private ApiError error;

    // Constructor for success response
    public ApiResponse(T data) {
        this.timeStamp = LocalDateTime.now();
        this.data = data;
    }

    // Constructor for error response
    public ApiResponse(ApiError error) {
        this.timeStamp = LocalDateTime.now();
        this.error = error;
    }
}