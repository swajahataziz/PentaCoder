package com.averros.data.codemapper.repository;

import com.averros.data.codemapper.model.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends MongoRepository<Project, String> {

    Project findByProjectId(String projectId);

}
