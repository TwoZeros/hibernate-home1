package ru.twozeros.hibernatehome1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.twozeros.hibernatehome1.entity.Person;
import ru.twozeros.hibernatehome1.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService =   userService;
    }

    @GetMapping(path = "/by-city")
    public List<Person> getUsersByCity(@RequestParam(value = "city") String city) {
        return userService.findByCity(city);
    }

}
