package com.averros.data.codemapper.model.Umls;

import lombok.Data;

@Data
public class Relation {


    private String uniqueIdentifier;
    private String treeNumber;
    private String label;
    private String abreviation;
    private String inverseLabel;
}
