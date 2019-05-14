package com.averros.data.codemapper.repository;

import com.averros.data.codemapper.model.Umls.CodingSystem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CodingSystemRepository extends MongoRepository<CodingSystem, String> {

    public List<CodingSystem> getCodingSystems();
}
