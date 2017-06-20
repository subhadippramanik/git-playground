
package com.demo.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Person;
import com.demo.service.PersonService;

@RestController
public class PersonController {

  @Autowired
  private PersonService personService;

  @RequestMapping(value = "/persons")
  public List<Person> getAllPersons() {
    return personService.getAllPersons();
  }

  @RequestMapping(value = "/person", method = RequestMethod.POST)
  public HttpStatus addPerson(@RequestBody Person person) {
    personService.add(person);
    return HttpStatus.CREATED;
  }

  @RequestMapping(value = "/person/id/{id}", method = RequestMethod.POST)
  public HttpStatus updatePerson(@PathVariable String id, @RequestBody Person person) {
    personService.update(id, person);
    return HttpStatus.OK;
  }
}
