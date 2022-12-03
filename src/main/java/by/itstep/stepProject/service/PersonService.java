package by.itstep.stepProject.service;

import by.itstep.stepProject.model.Person;
import by.itstep.stepProject.model.PersonInfo;

import java.util.Optional;

public interface PersonService {
    Optional<Person> findById(Integer mainParentId);

    Person savePerson(Person person);
    Person getPerson(Integer id);
}
