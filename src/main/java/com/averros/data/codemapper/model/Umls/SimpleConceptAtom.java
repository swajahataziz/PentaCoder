package com.averros.data.codemapper.model.Umls;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
public class SimpleConceptAtom {

    @Id
    private String conceptUniqueIdentifier;
    private String termUniqueIdentifier;
    private String stringUniqueIdentifier;
    private String metathesaurusUniqueIdentifier;
    private String sType;
    private String code;
    private String attributeUniqueIdentifier;
    private String sourceAssertedAttributeIdentifer;
    private String attributeName;
    private String abbreviatedSourceName;
    private String attributeValue;
    private String supressibleFlag;
    private String contentViewFlag;
}
