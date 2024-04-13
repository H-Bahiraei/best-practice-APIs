package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.IPersonCacheService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 3/19/2024
 * @project demo2
 * &
 */

@RestController
@RequestMapping("/person")
public class PersonController {

    IPersonCacheService personCacheService;

    public PersonController(IPersonCacheService personCacheService) {
        this.personCacheService = personCacheService;
    }


    @PostMapping(value = "/save1", consumes = {"application/json"}, produces = {"application/json"})
    public Person save1(@Valid @RequestBody Person person) {
        return personCacheService.save(person);
    }

    @GetMapping("/get1/{personId}")
    public Person get1(@PathVariable Long personId) {
        return personCacheService.get(personId);
    }


    @PostMapping("/save2")
    public ResponseEntity<Person> save2(@RequestBody Person person) {
        return new ResponseEntity<>(
                personCacheService.save(person),
                HttpStatus.CREATED);
    }

    @GetMapping("/get2/{personId}")
    public ResponseEntity<Person> get2(@PathVariable Long personId) {
        return new ResponseEntity<>(
                personCacheService.get(personId),
                HttpStatus.OK
        );
    }
}
