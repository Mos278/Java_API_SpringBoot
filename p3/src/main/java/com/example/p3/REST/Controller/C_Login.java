package com.example.p3.REST.Controller;

import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Controller;

import com.example.p3.Entity.User;
import com.example.p3.Exception.BaseException;
import com.example.p3.Exception.LoginException;
import com.example.p3.Mapping.UserMapper;
import com.example.p3.Model.Login_Request;
import com.example.p3.Model.Login_Response;
import com.example.p3.Repository.UserRepository;
import com.example.p3.Service.UserService;

@Controller
public class C_Login {
    private final UserMapper usermapper;
    private final UserService userService;

    public C_Login(UserMapper usermapper,UserService userService){
        this.usermapper = usermapper;
        this.userService = userService;
    }

    public Login_Response login(Login_Request request) throws BaseException{
      //varidate
      if(request.getEmail() == null){
        throw LoginException.EmailisNull();
      }

      if(request.getPassword() == null){
        throw LoginException.PasswordisNull();
      }
 
      //verify
      User user = userService.Login_User(request.getEmail(),request.getPassword());
      Login_Response response = usermapper.toLogin_Response(user);
      return response;

    }
}
