package com.me.management.cacheservice;

import com.me.management.model.Person;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 2/24/2024
 * @project management
 * &
 */
public interface IPersonCacheService {

        Person save(Person person);
        Person get(Long id);

}
