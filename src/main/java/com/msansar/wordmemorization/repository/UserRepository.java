package com.msansar.wordmemorization.repository;

import com.msansar.wordmemorization.model.User;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

@Primary
public interface UserRepository extends MongoRepository<User, String> {
    boolean existsByUsernameOrEmail(String username, String email);

    Optional<User> findUserByUsername(String username);
    Optional<User> findUserByEmail(String email);

}
