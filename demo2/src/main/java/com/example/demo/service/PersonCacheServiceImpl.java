package com.example.demo.service;

import com.example.demo.model.Person;
import org.springframework.stereotype.Service;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 3/19/2024
 * @project demo2
 * &
 */

@Service
public class PersonCacheServiceImpl extends CacheService<Long, Person> implements IPersonCacheService {

    @Override
    public Person save(Person person) {
        person.setId(super.getNextId());
        return super.save(person);
    }

    @Override
    public Person get(Long id) {
        return super.get(id);
    }
}
