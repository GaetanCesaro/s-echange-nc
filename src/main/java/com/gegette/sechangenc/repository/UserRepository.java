package com.gegette.sechangenc.repository;

import com.gegette.sechangenc.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByFirstName(String firstName);
    List<User> findByLastName(String lastName);

}
