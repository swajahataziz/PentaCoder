package com.averros.data.codemapper.model.Umls;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
public class ConceptDefinition {

    @Id
    private String conceptUniqueIdentifer;
    private String atomUniqueIdentifier;
    private String attributeUniqueIdentifier;
    private String sourceAssertedAttributeIdentifier;
    private String abbreviatedSourceName;
    private String definition;
    private String suppressibleFlag;
    private String contentViewFlag;
}
