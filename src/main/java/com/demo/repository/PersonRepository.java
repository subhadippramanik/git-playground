package com.demo.repository;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.demo.model.Person;

public class PersonRepository extends SimpleJpaRepository<Person, Integer> {

  public PersonRepository(Class<Person> domainClass, EntityManager em) {
    super(domainClass, em);
  }
  // no content
}
