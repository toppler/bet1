package com.bet.bet1.domain;

import com.bet.bet1.controller.PersonController;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;

/*
DB updates in JPA for concurrent applications ->

Optimistic Concurrency -> adding version number to the version field.
When version column is present, JPA will increment the version field for us upon every update to the row.
when two detached identities try to update. Doesn't serialize thread access
Pessimistic Concurrency ->
* Pessimistic Concurrency approach works best for applications where contention ratio is high among the concurrent
transactions, otherwise it is a badly scalable option for handling concurrency.
locks every row on update; after update releases the lock-> SLOW
 */
@Data
@Entity
public class Person {
    private static final Logger LOG = LoggerFactory.getLogger(Person.class);
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Version
    private int version;
    private String name;
    private int age;
    /**
     * Transient fields are not persisted to the DB
     */
    @Transient
    private String emailId;



}