package by.itstep.stepProject.service.impl;

import by.itstep.stepProject.bean.EventDto;
import by.itstep.stepProject.mapper.EventMapper;
import by.itstep.stepProject.model.Child;
import by.itstep.stepProject.model.Event;
import by.itstep.stepProject.repository.ChildRepository;
import by.itstep.stepProject.repository.EventRepository;
import by.itstep.stepProject.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private ChildRepository childRepository;


    @Override
    public void saveEvent(EventDto eventDto, Child child) {
        Event event = eventRepository.save(EventMapper.eventDtoToEvent(eventDto));
        child.getEventsList().add(event);
        childRepository.save(child);
    }


}
