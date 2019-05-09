package com.averros.data.codemapper.model.Umls;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
public class ConceptNamesSources {

    @Id
    private String conceptUniqueIdentifier;
    private String languageOfTerm;
    private String termStatus;
    private String termUniqueIdentifier;
    private String stringType;
    private String stringUniqueIdentifier;
    private boolean isPreferred;
    private String sourceAssertedAtomIdentifier;
    private String sourceAssertedConceptIdentifier;
    private String sourceAssertedDescriptorIdentifier;
    private String abbreviatedSourceName;
    private String termType;
    private String code;
    private String str;
    private String sourceRestrictionLevel;
    private String supressibleFlag;
    private String contentViewFlag;
}
