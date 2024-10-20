package com.Saumya.spring_bbot_rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

//So now when we do addForm so after filling upo the details in form basically we need to return our success.jsp but now over there we will have
//a class called as JobPost and now in that basically JobPost is one of  the class and that contyains all the details of form so now working on that
//To directly get our getters and setters
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
public class JobPost {
    //Now adding all the required variables that are present in the form
    @Id
    private int postId;
    private String postProfile;
    private String postDesc;
    private int reqExperience;
    private List<String> postTechStack;
}
