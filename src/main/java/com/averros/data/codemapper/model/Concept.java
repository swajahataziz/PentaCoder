package com.averros.data.codemapper.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class Concept {

    @Id
    private int conceptId;
    private List<Concept> concepts;
    private String display;

}
