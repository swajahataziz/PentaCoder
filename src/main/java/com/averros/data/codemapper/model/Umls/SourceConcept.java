package com.averros.data.codemapper.model.Umls;

import lombok.Data;

@Data
public class SourceConcept {

    private String uniqueIdentifier;
    private String codingSystem;
    private String id;
    private String preferredTerm;

}
