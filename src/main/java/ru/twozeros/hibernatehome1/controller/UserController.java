package ru.twozeros.hibernatehome1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.twozeros.hibernatehome1.entity.Person;
import ru.twozeros.hibernatehome1.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping(path = "/")
    public ResponseEntity<String> indexPage() {
        return new ResponseEntity<String>("hello world",HttpStatus.OK);
    }
    @GetMapping(path = "/by-city")
    public List<Person> getUsersByCity(@RequestParam(value = "city") String city) {
        return userService.findByCity(city);
    }

    @PostMapping("/create")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        try {
            Person createdPerson = userService.createPerson(person);
            return new ResponseEntity<>(createdPerson, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person) {
        Optional<Person> personOptional = userService.findById(person.getKey());
        if (personOptional.isPresent()) {
            return new ResponseEntity<>(userService.save(person), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Person> deletePerson(@RequestBody Person person) {
        try {
            userService.deleteById(person.getKey());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findBy")
    public ResponseEntity<Person> findBy(@RequestParam(value = "name") String name,
                                         @RequestParam(value = "surname") String surname) {
        try {
            return new ResponseEntity<>(userService.findFirstByKeyNameAndKeySurname(name, surname), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/ageLess/{age}")
    public ResponseEntity<List<Person>> findByAgeLessThen(@PathVariable("age") int age) {
        List<Person> persons = userService.findByAgeLessThen(age);
        if(!persons.isEmpty()) {
            return new ResponseEntity<>( persons, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
