package ru.twozeros.hibernatehome1.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import ru.twozeros.hibernatehome1.entity.Person;
import ru.twozeros.hibernatehome1.entity.UserKey;
import ru.twozeros.hibernatehome1.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Person> findByCity(String nameCity) {
        return userRepository.findByCityOfLiving(nameCity);
    }

    public Person save(Person person) {
        return userRepository.save(person);
    }

    public List<Person> findByAgeLessThen(Integer age) {
        return userRepository.findByKeyAgeLessThanOrderByKeyAgeAsc(age);
    }

    public Person findFirstByKeyNameAndKeySurname(String name, String surname) {
        return userRepository.findFirstByKeyNameAndKeySurname(name, surname)
                .orElseThrow(EntityNotFoundException::new);
    }
    public Person createPerson(Person person) {
        return userRepository.save(person);
    }
    public Optional<Person> findById(UserKey key) {
        return userRepository.findById(key);
    }
    public void deleteById(UserKey key) {
        userRepository.deleteById(key);
    }

}
