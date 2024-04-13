package com.me.management.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 2/23/2024
 * @project users
 * &
 */

@Getter
@Setter
@ToString
@EqualsAndHashCode

public class Person extends BaseEntity implements Comparable{

    private String name;

    @Min(1)
    @Max(150)
    private Integer age;

    public Person(Long id, String name, Integer age) {
        super(id);
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        Person person = (Person) o;
        return  person.getAge() -this.getAge();
    }
}
