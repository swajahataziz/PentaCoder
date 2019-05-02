package com.averros.data.codemapper.processor;

import com.averros.data.codemapper.model.Umls.CodeMapping;
import com.averros.data.codemapper.model.Umls.CodingSystem;
import com.averros.data.codemapper.model.Umls.ExtendedCodeMapping;
import com.averros.data.codemapper.model.Umls.SourceConcept;

import java.util.List;

public interface CodeMappingAgent {

    /***
     * Retrieve the coding system to be extended
     * @return Coding System to be extended
     *
     */
    CodingSystem getCodingSystem();

    /***
     * Map CUIs to codes in the reference coding systems
     * @param uniqueIdentifiers : CUI
     * @param sourceConcepts: Source Concepts to be mapped
     * @return CodeMapping object containing mapping from CUI to Source Concepts
     */
    CodeMapping mapCodes(String uniqueIdentifiers, List<SourceConcept> sourceConcepts);

    ExtendedCodeMapping mapExtendedCodes(String uniqueIdentifiers, List<CodeMapping> codeMappings);
}
