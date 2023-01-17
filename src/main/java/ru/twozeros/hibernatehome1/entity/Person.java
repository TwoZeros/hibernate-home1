package ru.twozeros.hibernatehome1.entity;

import lombok.Data;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Data
@Entity
public class Person {

    @EmbeddedId
    private UserKey key;
    private String phoneNumber;
    private String cityOfLiving;
}
