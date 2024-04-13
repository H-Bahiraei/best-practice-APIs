package com.me.management.service;

import com.me.management.cacheservice.impl.PersonCacheService;
import com.me.management.exception.ExceptionInsertCache;
import com.me.management.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 2/25/2024
 * @project management
 * &
 */
public class PersonCacheServiceTest {

    final Long id = 1L;
    final String name="Mehrad";
    PersonCacheService personCacheService;

    @BeforeEach
    void setUp(){
        personCacheService= new PersonCacheService();
//        Person person= new Person(id,name,35);
//        personCacheService.save(person);
    }

    @Test
    void saveTest(){
        Person person2= new Person(2L,name,35);
        Person personFetched= personCacheService.save(person2);
        assertEquals(personFetched.getName(),name);
    }



    @Test
    void saveWithoutId(){ // ***
        Person person2= new Person(null,name,35);
        Exception exception =assertThrows(ExceptionInsertCache.class, ()->{
            personCacheService.save(person2);
        });
        assertEquals(exception.getMessage(),"obj cannot be nul!!!");
    }


    @Test
    void saveRepetitiveTest(){
        Person person2= new Person(id,name,36);
        personCacheService.save(person2);
        assertEquals(personCacheService.get(id).getAge(),36);
    }


    @Test
    void getExpiredRecord() throws InterruptedException {
        assertNotNull(personCacheService.get(id));
        Thread.sleep(31000L);
//        assertNull(personCacheService.get(id));
        Exception exception = assertThrows(ExceptionInsertCache.class, () -> {
            personCacheService.get(id);
        }); // ***
        assertEquals("sss", exception.getMessage());
    }
}
