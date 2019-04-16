package com.averros.data.codemapper.model;

import lombok.Data;

@Data
public class BodySite {

    private boolean isActive;
    private String code;
    private String description;
    private String identifier; //TODO replace string with a type

}
