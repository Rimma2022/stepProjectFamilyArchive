package by.itstep.stepProject.service.impl;

import by.itstep.stepProject.model.Person;
import by.itstep.stepProject.repository.PersonRepository;
import by.itstep.stepProject.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public Optional<Person> findById(Integer mainParentId) {
        return personRepository.findById(mainParentId);
    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person getPerson(Integer id) {
        return personRepository.findById(id)
                .orElse(null);
    }

}
