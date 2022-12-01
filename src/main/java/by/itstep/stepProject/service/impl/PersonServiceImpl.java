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
    private PersonRepository personeRepository;

    @Override
    public Optional<Person> findById(Integer mainParentId) {
        return personeRepository.findById(mainParentId);
    }

    @Override
    public Person savePersone(Person person) {
        return personeRepository.save(person);
    }

    @Override
    public Person getPerson(Integer id) {
        return personeRepository.findById(id)
                .orElse(null);
    }


}
