package by.itstep.stepProject.service;

import by.itstep.stepProject.bean.ChildDto;
import by.itstep.stepProject.model.Child;
import by.itstep.stepProject.model.Event;
import by.itstep.stepProject.model.Illness;


import java.util.List;

public interface ChildService {
    void saveChild(ChildDto child);

    List<Child> getChildList(Integer personId);

    Child getChild(Integer id);


    List<Illness> getIllnessList(Integer id);

    List<Event> getEventList(Integer id);
}
