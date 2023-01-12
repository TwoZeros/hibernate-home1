package ru.twozeros.hibernatehome1.entity;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
public class Person {

    @EmbeddedId
    private UserKey key;
    private String phoneNumber;
    private String cityOfLiving;
}
