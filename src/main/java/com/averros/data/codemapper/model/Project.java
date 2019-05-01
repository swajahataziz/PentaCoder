package com.averros.data.codemapper.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;
import java.util.Set;

@Document
@Data
public class Project {

    @Id
    private int projectId;
    private Map<User, Set<Role>> projectUsers;

}
