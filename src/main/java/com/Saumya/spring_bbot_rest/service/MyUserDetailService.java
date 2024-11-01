package com.Saumya.spring_bbot_rest.service;

import com.saumya.SpringSecur.dao.UserRepo;
import com.saumya.SpringSecur.model.User;
import com.saumya.SpringSecur.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements   UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("This is the username.. "+username);
        User user = repo.findByUsername(username);
        System.out.println("Found the username so.. "+user);
        if (user == null) {
            System.out.println("User 404");
            throw new UsernameNotFoundException("User 404");

        }
        //Now in this case we need to return the userDetails but from repo we will be getting the user which is basically an interfac
        return new UserPrincipal(user);
    }

    @Service
    public static class UserService {
        @Autowired
        private UserRepo userRepo;
        private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
        public User saveUser(User user){
            user.setPassword(encoder.encode(user.getPassword()));
            System.out.println(user.getPassword());
            return userRepo.save(user);
        }
    }
}