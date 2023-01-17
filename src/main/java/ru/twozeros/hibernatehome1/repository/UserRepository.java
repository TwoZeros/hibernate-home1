package ru.twozeros.hibernatehome1.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ru.twozeros.hibernatehome1.entity.Person;
import ru.twozeros.hibernatehome1.entity.UserKey;

import java.util.List;
import java.util.Optional;

@Service
public interface UserRepository extends JpaRepository<Person, UserKey> {

    //метод, который будет принимать название города(city)
    // и возвращать Entity из базы данных, которые соответствуют этому city.
    List<Person> findByCityOfLiving(String nameOfCity);


    //метод, который будет принимать возраст(age) и возвращать Entity из базы данных,
    //которые меньше переданного age и отсортированы по возрастанию.
    List<Person> findByKeyAgeLessThanOrderByKeyAgeAsc(Integer age);

    // метод, который будет принимать имя и фамилию(name и surname) и возвращать Entity из базы данных,
    // которые соответствуют сочетанию name и surname и является Optional.
    Optional<Person> findFirstByKeyNameAndKeySurname(String name, String surname);


}
