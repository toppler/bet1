package com.bet.bet1.repository;

import com.bet.bet1.domain.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {}
