package com.averros.data.codemapper.model;

import lombok.Builder;
import lombok.Data;
import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;

@Data
@Builder
public class OmopConcept {

    public static OmopConcept EMPTY_OMOP_CONCEPT = createEmptyOmopConcept();

    @Id
    private int conceptId;
    private String conceptName;
    private String domainId;
    private String vocabularyId;
    private String conceptClassId;
    private String standardConcept;
    private String conceptCode;
    private DateTime startDate;
    private DateTime endDate;
    private String rejectionReason;
    private int parentCount;
    private int childCount;
    private String additionalInfo;

    private static OmopConcept createEmptyOmopConcept() {
        return OmopConcept.builder().conceptId(0).conceptName("Unmapped").parentCount(0).childCount(0).build();
    }
}