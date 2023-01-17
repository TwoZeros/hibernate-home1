package ru.twozeros.hibernatehome1.entity;


import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class UserKey implements Serializable {
    private String name;
    private String surname;
    private Integer age;
}
