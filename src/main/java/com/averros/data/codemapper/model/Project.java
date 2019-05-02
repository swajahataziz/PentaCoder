package com.averros.data.codemapper.model;

import com.averros.data.codemapper.model.Umls.CaseDefinition;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class Project {

    @Id
    private String projectId;
    private User projectUsers;
    private List<CaseDefinition> caseDefinitions;
}
