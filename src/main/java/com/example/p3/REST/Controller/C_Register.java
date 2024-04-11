package com.example.p3.REST.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.p3.Entity.User;
import com.example.p3.Exception.BaseException;
import com.example.p3.Exception.RegisterException;
import com.example.p3.Mapping.UserMapper;
import com.example.p3.Model.Register_Request;
import com.example.p3.Model.Register_Response;
import com.example.p3.Service.UserService;
@Service
public class C_Register {

  private final UserService userService;
  private final UserMapper usermapper;

  
  public C_Register(UserService userService,UserMapper usermapper){
    this.userService = userService;
    this.usermapper = usermapper;
  }

    public Register_Response Register(Register_Request entity) throws BaseException {
      if(entity == null){
            throw RegisterException.RegisNull();
        }
        if(entity.getEmail() == null){
            throw RegisterException.EmailisNull();
        }
      User user = userService.Create(entity.getEmail(), entity.getPassword(), entity.getName());
      
      Register_Response usermapping =  usermapper.toRegister_Response(user);//User to UserResponse
      return usermapping;
    }

}
