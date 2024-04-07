package com.example.p3.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.p3.Entity.Social;
import com.example.p3.Entity.User;

import java.util.Optional;



@Repository
public interface SocialRepository extends CrudRepository<Social,String> {
    Optional<Social> findByid(String id);
    Optional<Social> findByig(String ig);
    Optional<Social> findByfacebook(String facebook);
    Optional<Social> findByuser(User user);

    //boolean existsByEmail(String email);//Search Email dup
    
    
}
