package com.me.management.controller;

import com.me.management.cacheservice.IPersonCacheService;
import com.me.management.exception.CacheIsGoneException;
import com.me.management.exception.NotFoundException;
import com.me.management.model.Person;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 2/24/2024
 * @project management
 * &
 */
@RequestMapping("/persons")
@Controller
public class PersonController {

    private final IPersonCacheService personCacheService;

//    public PersonController(@Qualifier("personCacheService") IPersonCacheService personCacheService1) {
    public PersonController(IPersonCacheService personCacheService1) {
        this.personCacheService = personCacheService1;
    }

    @PostMapping(value = "/newResBody",consumes = {"application/json"},produces = {"application/json"})
    @ResponseBody
    public Person createAPersonResBody(@Valid @RequestBody Person person) {
        Person person1 = personCacheService.save(person);
        if (person1 != null)
            return person1;
        else
            throw new CacheIsGoneException("cache system is gone");
    }

    @GetMapping("/getResBody/{personId}")
    @ResponseBody
    public Person getPersonResBody(@PathVariable Long personId) {
        Person person = personCacheService.get(personId);
        if (person != null)
            return person;
        else
            throw new NotFoundException("read from DB");
    }


    @PostMapping("/newResEntity")
    public ResponseEntity<String> createAPersonResEntity(@Valid @RequestBody Person person) {
        Person person1 = personCacheService.save(person);
        if (person1 != null) {
            return ResponseEntity.ok().body(person1.toString()); // Todo remember
        } else {
            return new ResponseEntity<String>("there is a problem in server", HttpStatus.SERVICE_UNAVAILABLE);
        }
    }


    @GetMapping("/getRespEntity/{personId}")
    public ResponseEntity<String> getPersonResEnti(@PathVariable Long personId) {
        Person person = personCacheService.get(personId);
        if (person != null)
            return ResponseEntity.ok().body(person.toString());
        else
            return new ResponseEntity<String>("we dont have this entity from ResBody", HttpStatus.NOT_FOUND);
    }
}
