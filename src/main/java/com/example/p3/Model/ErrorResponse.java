package com.example.p3.Model;


import java.time.LocalDateTime;

import lombok.Data;
@Data
public class ErrorResponse {
    private LocalDateTime ErrorTime = LocalDateTime.now();   
    private String ErrorDetail;
    private int Status;
}
