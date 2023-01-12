package ru.twozeros.hibernatehome1.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import ru.twozeros.hibernatehome1.entity.Person;

import java.util.List;

@Service
public class UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> findByCity(String nameCity) {
        List<Person> person = entityManager.<Person>createQuery("SELECT person from Person person where lower(person.cityOfLiving) = lower(?1)")
                .setParameter(1, nameCity)
                .getResultList();
        return person;
    }
}
