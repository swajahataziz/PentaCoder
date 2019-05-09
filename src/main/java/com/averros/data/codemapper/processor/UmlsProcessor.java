package com.averros.data.codemapper.processor;

import com.averros.data.codemapper.model.Umls.ExtendedCodeMapping;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UmlsProcessor {
    private static final List<String> GENRAL_RELATIONS = Arrays.asList("RB", "PAR");
    private static final List<String> SPECIFIC_RELATIONS = Arrays.asList("RN", "CHD");
    private static final List<String> GENERAL_OR_SPECIFIC_RELATIONS = Arrays.asList("RN", "RB", "PAR", "CHD");
    private static final List<String> ALIKE_RELATIONS = Arrays.asList("RL", "SYS");

    private static final int MAX_CONCEPT_RELATION_DEPTH = 3;

    private List<String> availableCodingSystems;
    private List<String> codingSystemsWithDefinition;
    private Map<String, ExtendedCodeMapping> extendedCodeMappings = new HashMap<>();

    public UmlsProcessor(List<String> availableCodingSystems, List<String> codingSystemsWithDefinition) {

        this.availableCodingSystems = availableCodingSystems;
        this.codingSystemsWithDefinition = codingSystemsWithDefinition;
    }




}
