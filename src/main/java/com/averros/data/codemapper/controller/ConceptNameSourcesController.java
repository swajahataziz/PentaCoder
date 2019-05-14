package com.averros.data.codemapper.controller;

import com.averros.data.codemapper.repository.ConceptNamesSourcesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Controller
public class ConceptNameSourcesController {

    @Autowired
    private ConceptNamesSourcesRepository conceptNamesSourcesRepository;

    public Map<String, String> getPreferredNames(List<String> conceptUniqueIdentifiers) {

        TreeMap<String, String> result = new TreeMap<>();

        List<Object[]> preferredNames = conceptNamesSourcesRepository.getConceptNames(conceptUniqueIdentifiers,
                "ENG",
                Boolean.TRUE,
                "P",
                "PF");

        for (Object[] preferredName: preferredNames) {
            result.put(preferredName[0].toString(), preferredName[1].toString());
        }

        return result;
    }
}
