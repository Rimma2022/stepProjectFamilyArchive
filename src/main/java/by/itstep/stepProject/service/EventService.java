package by.itstep.stepProject.service;

import by.itstep.stepProject.bean.EventDto;

public interface EventService {
    void saveEvent(EventDto eventDto, Integer id);


    void delete(Integer id, Integer childId );
}
