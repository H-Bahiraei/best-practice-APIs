package com.me.management.controller;

import com.me.management.cacheservice.impl.PersonCacheService;
import com.me.management.exception.ExceptionInsertCache;
import com.me.management.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 2/25/2024
 * @project management
 * &
 */
@ExtendWith(MockitoExtension.class) //***
public class PersonControllerTest {
    final Long id = 1L;
    final String name = "Mehrad";

    Person person;
    @Mock
    PersonCacheService personCacheService;

    @InjectMocks
    PersonController personController;


    @BeforeEach
    void setUp() {
        person = new Person(id, name, 35);
    }

    @Test
    void createAPersonResBodyTest() {

        when(personCacheService.save(ArgumentMatchers.any())).thenReturn(person);

        assertEquals(personController.createAPersonResBody(person).getId(),id);
    }






}
