package com.bet.bet1.controller;


import com.bet.bet1.component.AsyncDemo;
import com.bet.bet1.domain.Person;
import com.bet.bet1.exception.PersonNotFoundException;
import com.bet.bet1.services.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

// @RestController = @RestController + @ResponseBody
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonController {
    private static final Logger LOG = LoggerFactory.getLogger(PersonController.class);
    @Autowired
    PersonService personService;
    @Autowired
    private AsyncDemo asyncDemo;

    @GetMapping("/personz")
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> persons = personService.getAllPersons();
        return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
    }

    @GetMapping("/persons")
    private List<Person> getAllPersons2() {
        LOG.trace("This is a TRACE log");
        LOG.debug("This is a DEBUG log");
        LOG.info("This is an INFO log");
        LOG.error("This is an ERROR log");
        asyncDemo.demo();
        return personService.getAllPersons();
    }

    @GetMapping("/persons/{id}")
    private ResponseEntity<Person> getPerson(@PathVariable("id") int id) {
       try {
           return new ResponseEntity<Person>(personService.getPersonById(id), HttpStatus.OK);
       } catch (PersonNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"APP NOT FOUND");
       }

    }

    @DeleteMapping("/persons/{id}")
    private void deletePerson(@PathVariable("id") int id) {

        personService.delete(id);
    }

    @PostMapping("/save")
    private int savePerson(@RequestBody Person person) {
        personService.saveOrUpdate(person);
        return person.getId();
    }

}