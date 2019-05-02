package com.averros.data.codemapper.repository;

import com.averros.data.codemapper.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findUserByUserId(String userId);
    User findUserByEmail(String email);
    User findUserByUsername(String userName);
    List<User> findUsersByTeam(String team);
}
