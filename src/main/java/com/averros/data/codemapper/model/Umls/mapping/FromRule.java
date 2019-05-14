package com.averros.data.codemapper.model.Umls.mapping;

import lombok.Data;

@Data
public class FromRule extends MappingRule {

    private String sourceAssertedIdentifier;
    private String expression;
}
