package com.averros.data.codemapper.model.Umls.mapping;

import lombok.Data;

@Data
public class MappingRule {

    private String id;
    private String entityType;
    private String rule;
    private String restriction;
}
