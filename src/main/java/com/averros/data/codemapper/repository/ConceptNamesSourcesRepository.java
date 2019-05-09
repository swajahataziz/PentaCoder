package com.averros.data.codemapper.repository;

import com.averros.data.codemapper.model.Umls.ConceptNamesSources;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ConceptNamesSourcesRepository extends MongoRepository<ConceptNamesSources, String> {

    @Query("SELECT AbbreviatedSourceName, COUNT(AbbreviatedSourceName) " +
            "FROM ConceptNameSources GROUP BY AbbreviatedSourceName ORDER BY COUNT DESC")
    public List<String> getCodingSystems();
}
