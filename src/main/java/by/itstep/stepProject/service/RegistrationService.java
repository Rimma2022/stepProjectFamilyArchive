package by.itstep.stepProject.service;

import by.itstep.stepProject.model.Person;
import by.itstep.stepProject.model.PersonInfo;
import by.itstep.stepProject.repository.PeopleRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class RegistrationService {
    private final PeopleRepository peopleRepository;
    private final PasswordEncoder passwordEncoder;
    private final PersonInfoService personInfoService;

    public RegistrationService(PeopleRepository peopleRepository, PasswordEncoder passwordEncoder, PersonInfoService personInfoService) {
        this.peopleRepository = peopleRepository;
        this.passwordEncoder = passwordEncoder;
        this.personInfoService = personInfoService;
    }


    @Transactional
    public void register(Person person){
        String encodedPassword = passwordEncoder.encode(person.getPassword());
        person.setPassword(encodedPassword);
        person.setRole("ROLE_USER");
        System.out.println(person);
        //----
        PersonInfo personInfo = personInfoService.savePersonInfo(new PersonInfo());
        person.setDetails(personInfo);
        //----
        peopleRepository.save(person);
        System.out.println(person);
    }
}
