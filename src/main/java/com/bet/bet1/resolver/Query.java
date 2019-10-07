package com.bet.bet1.resolver;


import com.bet.bet1.domain.Person;
import com.bet.bet1.repository.PersonRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {
    private PersonRepository personRepository;
    public Query(PersonRepository personRepository) {
       this.personRepository =personRepository;
    }
    public Iterable<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person getPersonById(int id){
        return personRepository.findById(id).get();
    }
}
