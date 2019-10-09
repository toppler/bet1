package com.bet.bet1.repository;

import com.bet.bet1.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = "http://localhost:4200")
public interface PersonRepository extends JpaRepository<Person, Integer> {}
