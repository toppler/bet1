package com.bet.bet1.mutator;

import com.bet.bet1.domain.Person;
import com.bet.bet1.repository.PersonRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {
    @Autowired
    private PersonRepository personRepository;

    public Mutation(PersonRepository personRepository) {
        this.personRepository  = personRepository;
    }

    public Person newPerson(int id,int version, String name,int age) {
        Person p = new Person(id,version,name,age);
        personRepository.save(p);
        return p;

    }

    public boolean delete(int id) {
        personRepository.deleteById(id);
        return true;
    }
}
