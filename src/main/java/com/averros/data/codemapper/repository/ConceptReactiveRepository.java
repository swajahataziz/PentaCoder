package com.averros.data.codemapper.repository;

import com.averros.data.codemapper.model.Concept;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConceptReactiveRepository extends ReactiveMongoRepository<Concept, String> {

}
