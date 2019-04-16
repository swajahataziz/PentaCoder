package com.averros.data.codemapper.model;

import lombok.Data;
import org.joda.time.DateTime;

import java.util.List;

@Data
public class Condition {

    private DateTime assertDate;
    private String asserter;
    private List<BodySite> bodySite;
    private String category;
    private String clinicalStatus;
    private Concept code;
    private String context;
    private String criticality;
    private DateTime onset;
    private Concept severity;
    private Stage stage;
}
