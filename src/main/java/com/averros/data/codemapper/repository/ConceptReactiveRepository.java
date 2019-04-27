package com.averros.data.codemapper.repository;

import com.averros.data.codemapper.model.Concept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConceptReactiveRepository extends JpaRepository<Concept, String> {

}
