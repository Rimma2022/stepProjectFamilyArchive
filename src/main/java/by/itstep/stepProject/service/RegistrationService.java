package by.itstep.stepProject.service;

import by.itstep.stepProject.model.Person;
import by.itstep.stepProject.repository.PeopleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationService {
    private final PeopleRepository peopleRepository;

    public RegistrationService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }
    @Transactional
    public void register(Person person){
        peopleRepository.save(person);
        System.out.println(person);
    }
}
