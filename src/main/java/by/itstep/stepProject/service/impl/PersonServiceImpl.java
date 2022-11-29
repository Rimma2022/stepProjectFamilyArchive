package by.itstep.stepProject.service.impl;

import by.itstep.stepProject.bean.ChildDto;
import by.itstep.stepProject.model.Person;
import by.itstep.stepProject.repository.PersoneRepository;
import by.itstep.stepProject.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersoneRepository personeRepository;

    @Override
    public Optional<Person> findById(Integer mainParentId) {
        return personeRepository.findById(mainParentId);
    }



}
