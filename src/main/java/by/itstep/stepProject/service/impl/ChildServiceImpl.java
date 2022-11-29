package by.itstep.stepProject.service.impl;

import by.itstep.stepProject.bean.ChildDto;
import by.itstep.stepProject.bean.PersonDto;
import by.itstep.stepProject.mapper.ChildMapper;
import by.itstep.stepProject.model.Child;
import by.itstep.stepProject.model.Person;
import by.itstep.stepProject.repository.ChildRepository;
import by.itstep.stepProject.repository.PersoneRepository;
import by.itstep.stepProject.service.ChildService;
import by.itstep.stepProject.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ChildServiceImpl implements ChildService {
    @Autowired
    private ChildRepository childRepository;
    @Autowired
    private PersonService personService;

    @Transactional
    @Override
    public void saveChild(ChildDto child) {
        System.out.println(child);
        Person person = personService.findById(child.getMainParentId()).orElse(null);
        childRepository.save(ChildMapper.childDtoToChild(child, person));
    }
}
