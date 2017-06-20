//------------------------------------------------------------------------------
// Copyright Siemens Switzerland Ltd., 2017
//------------------------------------------------------------------------------

package com.demo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.demo")
@EntityScan("com.demo.model")
@EnableJpaRepositories("com.demo.repository")
public class App {

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }
}