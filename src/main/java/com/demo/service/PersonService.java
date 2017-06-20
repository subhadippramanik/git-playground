//------------------------------------------------------------------------------
// Copyright Siemens Switzerland Ltd., 2017
//------------------------------------------------------------------------------

package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Person;
import com.demo.repository.PersonRepository;

@Service
public class PersonService {

  @Autowired
  private PersonRepository personRepository;

  public List<Person> getAllPersons() {
    List<Person> persons = new ArrayList<>();
    personRepository.findAll().forEach(persons::add);
    return persons;
  }

  public void add(Person person) {
    personRepository.save(person);
  }

  public void update(String id, Person person) {
    person.setId(Integer.valueOf(id));
    personRepository.save(person);
  }

}
