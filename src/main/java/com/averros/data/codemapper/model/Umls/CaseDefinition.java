package com.averros.data.codemapper.model.Umls;

import com.averros.data.codemapper.model.Project;
import com.averros.data.codemapper.model.User;
import lombok.Data;
import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class CaseDefinition {

    @Id
    private String uniqueIdentifier;
    private String name;
    private String state;
    private User author;
    private User lastModifiedBy;
    private DateTime dateCreated;
    private DateTime dateModified;
}
