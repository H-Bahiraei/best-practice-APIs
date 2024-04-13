package com.me.management.cacheservice.impl;

import com.me.management.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 2/25/2024
 * @project management
 * &
 */
class PersonCacheServiceTest {

    PersonCacheService personCacheService;
    @BeforeEach
    void setup(){
        personCacheService = new PersonCacheService();
    }
    @Test
    void workStream() {
        HashMap<Long, Person> myMap= personCacheService.workStream();
        assertEquals(myMap.size(),10);
    }

}