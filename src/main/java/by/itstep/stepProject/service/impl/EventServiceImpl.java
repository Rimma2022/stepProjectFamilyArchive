package by.itstep.stepProject.service.impl;

import by.itstep.stepProject.bean.EventDto;
import by.itstep.stepProject.mapper.EventMapper;
import by.itstep.stepProject.repository.EventRepository;
import by.itstep.stepProject.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepository eventRepository;

    @Override
    public void saveEvent(EventDto eventDto) {
        eventRepository.save(EventMapper.eventDtoToEvent(eventDto));
    }
}
