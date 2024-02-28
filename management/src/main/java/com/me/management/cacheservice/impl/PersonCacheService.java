package com.me.management.cacheservice.impl;


import com.me.management.cacheservice.IPersonCacheService;
import com.me.management.model.Person;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 2/23/2024
 * @project users
 * &
 */
@Service
@Profile("ONE")
public class PersonCacheService extends AbstractCacheService<Long, Person> implements IPersonCacheService {


    @Override
    public Person save(Person person) {
        return super.save(person);
    }

    @Override
    public Person get(Long key) {
        return super.get(key);
//            throw new RuntimeException("read from DB");// TODO read from DB and this.put to cache and return V
    }


    HashMap<Long, Person> workStream() {

        for (int i = 0; i < 10; i++) {
            super.save(new Person((long) i, "Mehrad " + i, i + 20));
        }

        HashMap<Long, Person> myMap = (HashMap<Long, Person>) super.fetchAll();
//        Map<Integer,Person> map2= myMap.values().stream().collect(Collectors.toMap(person -> person.getAge(), person -> person));
//        System.out.println(map2);

//        myMap.values().stream().sorted().forEach(p-> System.out.println(p.getAge()));

//        myMap.forEach((k, v) -> System.out.println(k + " " + v));

//        List<Integer> myList= myMap.values().stream().map(Person::getAge).collect(Collectors.toList());
//
//        System.out.println(myList);
//        Collections.sort(myList,(a,b)->b-a);
//        System.out.println(myList);

//        Integer sum= myMap.values().stream().map(Person :: getAge).reduce((a,b)->a+b).orElse(0);
//        System.out.println(sum);


        Boolean b= myMap.values().stream().anyMatch(person -> person.getAge()>30);
        System.out.println("b = " + b);

        return myMap;

    }

}
