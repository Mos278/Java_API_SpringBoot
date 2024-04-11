package com.example.p3.REST.API;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.p3.Exception.BaseException;
import com.example.p3.Mapping.UserMapper;
import com.example.p3.Model.Login_Request;
import com.example.p3.Model.Login_Response;
import com.example.p3.REST.Controller.C_Login;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/login")
public class Login {
    
    private final C_Login con;


    public Login(C_Login login){
        this.con = login;
        
    }

    @PostMapping
    public ResponseEntity<Login_Response> postMethodName(@RequestBody Login_Request entity) throws BaseException{
        //TODO: process POST request
        Login_Response response = con.login(entity);
        return ResponseEntity.ok(response);
    }
    



}
