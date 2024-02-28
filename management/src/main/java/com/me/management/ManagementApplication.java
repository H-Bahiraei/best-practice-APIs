package com.me.management;

import com.me.management.cacheservice.impl.PersonCacheService;
import com.me.management.model.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManagementApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(ManagementApplication.class, args);


//        PersonCacheService personCacheService = new PersonCacheService();
//
//        Person person = new Person(1L, "Mehrad", 33);
//        Person person2 = new Person(2L, "Mehrad2",34);
//        Person person3 = new Person(3L, "Mehrad3",35);
//
//        personCacheService.save(person);
//        personCacheService.save(person2);
//        personCacheService.save(person3);
//
//        System.out.println("person = " + personCacheService.get(person.getId()).getId());
//        System.out.println("person2 = " + personCacheService.get(person2.getId()).getId());
//        System.out.println("person3 = " + personCacheService.get(person3.getId()).getId());
//
//        Thread.sleep(5000L);
//        Person p1 = personCacheService.get(person.getId());
//        if (p1 != null)
//            System.out.println("person = " + p1.getName());
//        System.out.println("person = " + personCacheService.get(person.getId()).getId());
//


//        person3.setName("Mehrad33");
//        personCacheService.save(person3);
//
//        System.out.println("person = " + personCacheService.get(person.getId()).getName());
//        System.out.println("person2 = " + personCacheService.get(person2.getId()).getName());
//        System.out.println("person3 = " + personCacheService.get(person3.getId()).getName());

    }

}
