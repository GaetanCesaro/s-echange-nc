package com.gegette.sechangenc.repository;

import com.gegette.sechangenc.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> { }
