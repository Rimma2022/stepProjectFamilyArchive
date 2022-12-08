package by.itstep.stepProject.service;

import by.itstep.stepProject.bean.PersonDto;
import by.itstep.stepProject.mapper.PersonMapper;
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
    public void register(PersonDto personDto){
        String encodedPassword = passwordEncoder.encode(personDto.getPassword());
        personDto.setPassword(encodedPassword);
        personDto.setRole("ROLE_USER");
        System.out.println(personDto);
        //----
        PersonInfo personInfo = personInfoService.savePersonInfo(new PersonInfo());
        personDto.setDetails(personInfo);
        //----
        peopleRepository.save(PersonMapper.personDtoToPerson(personDto));
        System.out.println(personDto);
    }
}
