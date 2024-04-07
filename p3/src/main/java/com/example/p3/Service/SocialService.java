package com.example.p3.Service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.p3.Entity.Social;
import com.example.p3.Entity.User;
import com.example.p3.Exception.BaseException;
import com.example.p3.Exception.S_SocialExecption;
import com.example.p3.Repository.SocialRepository;
import com.example.p3.Repository.UserRepository;

@Service
public class SocialService {
    private final SocialRepository S_repository;
    private final UserRepository U_repository;
    private final PasswordEncoder PasswordEncoder;

    public SocialService(SocialRepository S_repository,UserRepository U_repository, PasswordEncoder passwordEncoder){
        this.PasswordEncoder = passwordEncoder;
        this.S_repository = S_repository;
        this.U_repository = U_repository;
    }

    public Social findByuser(User user)throws BaseException{
        Optional<Social> response = S_repository.findByuser(user);
        if(!response.isPresent()){// not found
            throw S_SocialExecption.SocialNotFund();
        }
        return response.get();
    }

    public Social CreateSocial(User user , String facebook , String ig) throws BaseException{
    if(!U_repository.existsById(user.getId())){
        throw S_SocialExecption.UserNotFound();
    }
    
        Social social = new Social();
        social.setFacebook(facebook);
        social.setIg(ig);
        social.setUser(user);
        S_repository.save(social);
        return social;
    }

    public String DeleteSocial(User user) throws BaseException{
        if(Objects.isNull(user)){
            throw S_SocialExecption.SocialNull();
        }
        Optional<Social> Social_find = S_repository.findByuser(user);
        if(!Social_find.isPresent()){
           return "don't have social";
        }
        Social social = Social_find.get();
        S_repository.deleteById(social.getId());
        return "Delete Socail Success";

        
    }

}
