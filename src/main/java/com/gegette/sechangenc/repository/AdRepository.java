package com.gegette.sechangenc.repository;

import com.gegette.sechangenc.model.Ad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdRepository extends CrudRepository<Ad, Long> { }
