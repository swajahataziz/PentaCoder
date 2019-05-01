package com.averros.data.codemapper.model.Umls;

import lombok.Data;

@Data
public class CodingSystem {

    private String code;
    private String display;
    private String system;
    private String family;
    private String version;
}
