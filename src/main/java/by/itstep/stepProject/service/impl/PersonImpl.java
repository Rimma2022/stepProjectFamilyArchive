package by.itstep.stepProject.service.impl;

import by.itstep.stepProject.model.Person;
import by.itstep.stepProject.repository.PersonRepository;
import by.itstep.stepProject.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonImpl implements PersonService {
    @Autowired
    private PersonRepository repository;

    @Override
    @Transactional
    public void savePerson(Person person) {
            repository.save(person);
    }

}
