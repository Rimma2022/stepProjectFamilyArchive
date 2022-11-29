package by.itstep.stepProject.service;

import by.itstep.stepProject.model.Person;

import java.util.Optional;

public interface PersonService {
    Optional<Person> findById(Integer mainParentId);
}
