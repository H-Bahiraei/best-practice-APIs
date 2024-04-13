package com.example.demo.service;

import com.example.demo.model.Person;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 3/19/2024
 * @project demo2
 * &
 */
public interface IPersonCacheService {

    public Person save(Person person);

    public Person get(Long id);

}
