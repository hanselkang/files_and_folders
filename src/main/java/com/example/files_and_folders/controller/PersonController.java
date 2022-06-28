package com.example.files_and_folders.controller;

import com.example.files_and_folders.models.File;
import com.example.files_and_folders.models.Person;
import com.example.files_and_folders.repository.FileRepository;
import com.example.files_and_folders.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping(value="/people")
    public ResponseEntity<List<Person>> getAllPeople(){
        return new ResponseEntity<>(personRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/people/{id}")
    public Optional<Person> getPerson(@PathVariable Long id) { return personRepository.findById(id);}

    @PostMapping(value="/people")
    public ResponseEntity<Person> postPerson(@RequestBody Person person) {
        personRepository.save(person);
        return new ResponseEntity<>(person,HttpStatus.CREATED);
    }
}
