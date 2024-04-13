package com.me.management.cacheservice.impl;

import com.me.management.cacheservice.IPersonCacheService;
import com.me.management.model.Person;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 2/25/2024
 * @project management
 * &
 */
@Service
@Profile("TWO")
public class StudentCacheService extends AbstractCacheService<Long,Person> implements IPersonCacheService {


 @Override
 public Person save(Person person) {
  person.setName("Student:"+ person.getName());
  return super.save(person);
 }

 @Override
 public Person get(Long id) {
  return super.get(id);
 }
}
