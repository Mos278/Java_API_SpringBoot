package com.example.p3.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.p3.Entity.User;
import java.util.Optional;


@Repository
public interface UserRepository extends CrudRepository<User,String> {
    Optional<User> findByid(String id);
    Optional<User> findByName(String name);
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);//Search Email dup
    
    
}
