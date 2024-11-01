package com.Saumya.spring_bbot_rest.repo;

import com.saumya.SpringSecur.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//So as we know over here we need to enter the table and the type of the primary key in this

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    User findByUsername(String username);


}
