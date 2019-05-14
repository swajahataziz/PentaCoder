package com.averros.data.codemapper.model.Umls;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class SemanticType {

    private String conceptUniqueIdentifier;
    private String semanticTypeUniqueIdentifier;
    private String semanticTypeTreeNumber;
    private List<SemanticType> parents;
    private List<Relation> relations;
    private List<Relation> inheritedRelations;
}
