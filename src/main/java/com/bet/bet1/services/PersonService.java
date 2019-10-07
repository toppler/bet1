package com.bet.bet1.services;

import com.bet.bet1.domain.Person;
import com.bet.bet1.exception.PersonNotFoundException;
import com.bet.bet1.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private static final Logger LOG = LoggerFactory.getLogger(PersonService.class);
    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPersons() {
        List<Person> persons = new ArrayList<>();
        personRepository.findAll().forEach(persons::add);
        return persons;
    }

    public Person getPersonById(int id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if(optionalPerson.isPresent())
            return optionalPerson.get();
//        else
//            throw new PersonNotFoundException("Person Not Found");
        return null;

    }

    public void saveOrUpdate(Person person) {
        personRepository.save(person);
    }

    public void delete(int id) {
        personRepository.deleteById(id);
    }
}
