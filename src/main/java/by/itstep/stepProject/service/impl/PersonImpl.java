package by.itstep.stepProject.service.impl;

import by.itstep.stepProject.model.Person;
import by.itstep.stepProject.repository.PersonRepository;
import by.itstep.stepProject.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonImpl implements PersonService {
    @Autowired
    private PersonRepository repository;

    @Override
    public void savePerson(Person person) {
        repository.save(person);
    }
}
