package com.averros.data.codemapper.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class User {

    @Id
    private String userId;
    private String username;
    private String FirstName;
    private String LastName;
    private String email;
    private String team;
    private List<Role> roles;
}
