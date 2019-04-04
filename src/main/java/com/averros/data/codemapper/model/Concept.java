package com.averros.data.codemapper.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Concept {

    @Id
    public int conceptId;
    public String conceptName;
    public String domainId;
    public String vocabularyId;
    public String conceptClassId;
    public String standardConcept;
    public String conceptCode;
    public String validStartDate;
    public String validEndDate;
    public boolean isConceptInvalid;
    public String invalidReason;
    public int parentCount;
    public int childCount;
    public String additionalInformation;
}
