package com.averros.data.codemapper.repository;

import com.averros.data.codemapper.model.Umls.ConceptMapping;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConceptMappingRepository extends MongoRepository<ConceptMapping, String> {


}
