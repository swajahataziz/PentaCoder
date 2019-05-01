package com.averros.data.codemapper.model.Umls;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@Builder
public class UmlsConcept {

    @Id
    private String uniqueIdentifier;
    private String preferredName;
    private String definition;
    private List<SourceConcept> sourceConcepts;
    private List<String> SemanticTypes;
}
