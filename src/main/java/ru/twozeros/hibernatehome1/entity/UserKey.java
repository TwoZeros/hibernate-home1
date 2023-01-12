package ru.twozeros.hibernatehome1.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class UserKey implements Serializable {
    private String name;
    private String surname;
    private Integer age;
}
