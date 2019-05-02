package com.averros.data.codemapper.model.Umls;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class ExtendedCodeMapping {

    @Id
    private String uniqueIdentifier;
    private List<CodeMapping> codeMappings;
}
