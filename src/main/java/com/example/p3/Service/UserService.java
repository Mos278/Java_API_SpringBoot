package com.example.p3.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.p3.Entity.Address;
import com.example.p3.Entity.User;
import com.example.p3.Exception.BaseException;
import com.example.p3.Exception.LoginException;
import com.example.p3.Exception.S_UserException;
import com.example.p3.Repository.SocialRepository;
import com.example.p3.Repository.UserRepository;

@Service
public class UserService {
    private final UserRepository u_repository;
    private final SocialRepository s_repository;
    private final PasswordEncoder PasswordEncoder;

    public UserService(UserRepository u_repository , SocialRepository s_repository,PasswordEncoder passwordencoder){
        this.u_repository = u_repository;
        this.s_repository = s_repository;
        this.PasswordEncoder = passwordencoder;
    }

    public User FindByEmail(String Email) throws BaseException {
        Optional<User> response = u_repository.findByEmail(Email);
        if (!response.isPresent()) {// null is false
            throw S_UserException.S_User_EmailnoMatch();
        }
        return response.get();
    }

    public boolean PasswordMatching(String rawpassword , String passwordencoder){
        return PasswordEncoder.matches(rawpassword , passwordencoder);
    }

    public User Create(String email, String password , String name) throws BaseException{
        //validate
        if(email == null){
            //throw email null
            throw S_UserException.S_User_EmailisNull();
        }
        if(password == null){
            //throw password null
            throw S_UserException.S_User_PWisNull();
        }
        if(name == null){
            throw S_UserException.S_User_NameisNull();
        }


        //verify primary
        if(u_repository.existsByEmail(email)){
            throw S_UserException.S_User_EmailDuplicated();
        }
        
        
        //save
        User entity = new User();
        entity.setEmail(email);
        entity.setName(name);
        entity.setPassword(PasswordEncoder.encode(password));
        return u_repository.save(entity);
    }


    public User Login_User(String email,String password) throws BaseException{
         //validate
         if(email == null){
            //throw email null
            throw S_UserException.S_User_EmailisNull();
        }
        if(password == null){
            //throw password null
            throw S_UserException.S_User_PWisNull();
        }

        User user = FindByEmail(email);
      if(!PasswordMatching(password, user.getPassword())){
        throw LoginException.PasswordisIncorrect();
      }
      return user;
    }

    public User UpdateName(User user,String name)throws BaseException{
        user.setName(name);
        return u_repository.save(user);
    }

    public void DeleteUser(User user)throws BaseException{
        u_repository.deleteById(user.getId());
      
    }


}
