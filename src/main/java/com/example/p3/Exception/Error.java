package com.example.p3.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.p3.Model.ErrorResponse;

@ControllerAdvice // ประกาศคลาสนี้ว่าเป็น Advice ที่ใช้ในการจัดการกับ Exception ที่เกิดขึ้นในแอปพลิเคชัน
public class Error {
    
    @ExceptionHandler(BaseException.class) // ระบุว่าเมธอดนี้จะใช้ในการจัดการกับ Exception จากคลาส BaseException
    public ResponseEntity<ErrorResponse> HandException(BaseException e){ // รับ BaseException เป็น parameter
        ErrorResponse ErrorResponse = new ErrorResponse(); 
        ErrorResponse.setErrorDetail(e.getMessage());
        ErrorResponse.setStatus(e.getStatus().value()); 
        return new ResponseEntity<>(ErrorResponse,e.getStatus());
    }
}
