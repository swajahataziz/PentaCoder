package com.averros.data.codemapper.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Document
@Data
public class SourceData {

    public String sourceCode;
    public String sourceName;
    public String recordFrequency;
    public Set<String> sourceAutoAssignedConceptIds = new HashSet<>();
    public List<Pair<String, String>> additionalSourceInfo = new ArrayList<>();
}
