package com.averros.data.codemapper.model.Umls;

import lombok.Data;

import java.util.List;

@Data
public class SemanticType {

    private String uniqueIdentifier;
    private String treeNumber;
    private List<SemanticType> parents;
    private List<Relation> relations;
    private List<Relation> inheritedRelations;
}
