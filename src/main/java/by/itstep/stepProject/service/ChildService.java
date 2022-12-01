package by.itstep.stepProject.service;

import by.itstep.stepProject.bean.ChildDto;
import by.itstep.stepProject.model.Child;
import by.itstep.stepProject.model.Person;

import java.util.List;

public interface ChildService {
    void saveChild(ChildDto child);

    List<Child> getChildList(Integer personId);
}
