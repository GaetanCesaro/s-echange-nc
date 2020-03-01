package com.gegette.sechangenc.repository;

import com.gegette.sechangenc.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> { }
