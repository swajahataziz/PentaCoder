package com.averros.data.codemapper.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class Concept {

    @Id
    private int conceptId;
    private List<Concept> concepts;
    private String display;

}
