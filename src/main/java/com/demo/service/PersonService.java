
package com.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.demo.model.Person;
import com.demo.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Bean
	public SessionFactory getSessionFactory() {
		if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
		return entityManagerFactory.unwrap(SessionFactory.class);
	}

	public List<Person> getAllPersons() {
		List<Person> persons = new ArrayList<>();
		personRepository.findAll().forEach(persons::add);
		return persons;
	}

	public void add(Person person) {
		personRepository.save(person);
	}

	public void update(String id, Person personDesired) {
		personDesired.setId(Integer.valueOf(id));
		Person personActual = personRepository.findOne(Integer.valueOf(id));
		personDesired.mergeInto(personActual);
		personRepository.save(personActual);
	}
}
