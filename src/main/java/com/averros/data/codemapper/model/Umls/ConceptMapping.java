package com.averros.data.codemapper.model.Umls;

import com.averros.data.codemapper.model.Umls.mapping.FromRule;
import com.averros.data.codemapper.model.Umls.mapping.MappingRule;
import com.averros.data.codemapper.model.Umls.mapping.ToRule;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class ConceptMapping {

    @Id
    private String mapId;
    private String mapSetUniqueIdentifier;
    private String sourceAbbreviation;
    private String mapSubSetUniqueIdentifier;
    private int mapRank;
    private String mappingsourceAssertedIdentifier;
    private FromRule fromRule;
    private String relationship;
    private ToRule toRule;
    private MappingRule mapRule;
    private String contentViewFlag;
}
