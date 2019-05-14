package com.averros.data.codemapper.repository;

import com.averros.data.codemapper.model.Umls.ConceptNamesSources;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ConceptNamesSourcesRepository extends MongoRepository<ConceptNamesSources, String> {

    @Query("SELECT DISTINCT ConceptUniqueIdentifier, str" +
            "FROM ConceptNameSources " +
            "WHERE ConceptUniqueIdentifier = ?1 " +
            "AND LanguageOfTerm = ?2 " +
            "AND IsPreferred = ?3 " +
            "AND TermStatus = ?4 AND StringType = ?5")
    List<Object[]> getConceptNames(List<String> cuis, String language, Boolean isPreferred,
                                   String termStatus, String stringType);
}
