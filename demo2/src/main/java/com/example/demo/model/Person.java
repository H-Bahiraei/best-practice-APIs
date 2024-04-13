package com.example.demo.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 3/19/2024
 * @project demo2
 * &
 */
@Getter
@Setter
@EqualsAndHashCode
public class Person extends BaseEntity implements Comparable {

    private String name;
    @Min(1)
    @Max(150)
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Object object) {
        Person person2 = (Person) object;
        return this.age - person2.age;
    }
}
