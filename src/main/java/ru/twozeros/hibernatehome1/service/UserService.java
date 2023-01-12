package ru.twozeros.hibernatehome1.service;

import org.springframework.stereotype.Service;
import ru.twozeros.hibernatehome1.entity.Person;
import ru.twozeros.hibernatehome1.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<Person> findByCity(String nameCity) {
        return userRepository.findByCity(nameCity);
    }
}
