package by.itstep.stepProject.service.impl;

import by.itstep.stepProject.model.PersonInfo;
import by.itstep.stepProject.repository.PersonInfoRepository;
import by.itstep.stepProject.service.PersonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonInfoServiceImpl implements PersonInfoService {

    @Autowired
    private PersonInfoRepository repository;

    @Override
    public PersonInfo savePersonInfo(PersonInfo info) {
        return repository.save(info);
    }
}
