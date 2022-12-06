package by.itstep.stepProject.service.impl;

import by.itstep.stepProject.bean.ChildDto;
import by.itstep.stepProject.mapper.ChildMapper;
import by.itstep.stepProject.model.Child;
import by.itstep.stepProject.model.Person;
import by.itstep.stepProject.model.PersonInfo;
import by.itstep.stepProject.repository.ChildRepository;
import by.itstep.stepProject.service.ChildService;
import by.itstep.stepProject.service.PersonInfoService;
import by.itstep.stepProject.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChildServiceImpl implements ChildService {
    @Autowired
    private ChildRepository childRepository;
    @Autowired
    private PersonService personService;
    @Autowired
    private PersonInfoService service;

    @Override
    public void saveChild(ChildDto child) {
        PersonInfo detail = null;


        System.out.println(child);


        Person person = personService.findById(child.getMainParentId()).orElse(null);
        person = person == null ? personService.savePerson(new Person()) : person;
        detail = person.getDetails() == null ? service.savePersonInfo(new PersonInfo()) : person.getDetails();
        person.setDetails(detail);

        Child save = childRepository.save(ChildMapper.childDtoToChild(child, person));


        List<Child> childList = detail.getChildrenList().isEmpty() ? new ArrayList<>() : detail.getChildrenList();
        childList.add(save);
        detail.setChildrenList(childList);
        PersonInfo personInfo = service.savePersonInfo(detail);
        person.setDetails(personInfo);
        personService.savePerson(person);
    }

    @Override
    public List<Child> getChildList(Integer personId) {
        Person person = personService.getPerson(personId);
        PersonInfo detail = person != null ? person.getDetails() : null;
        return detail != null ?
                detail.getChildrenList() :
                new ArrayList<>();
    }
}
