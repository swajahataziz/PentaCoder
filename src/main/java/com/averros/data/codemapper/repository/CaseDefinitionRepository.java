package com.averros.data.codemapper.repository;

import com.averros.data.codemapper.model.Umls.CaseDefinition;
import com.averros.data.codemapper.model.User;
import org.joda.time.DateTime;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseDefinitionRepository extends MongoRepository<CaseDefinition, String> {

    CaseDefinition findCaseDefinitionByAuthor(User author);
    CaseDefinition findCaseDefinitionByDateCreatedBetween(DateTime startDate, DateTime endDate);
}
