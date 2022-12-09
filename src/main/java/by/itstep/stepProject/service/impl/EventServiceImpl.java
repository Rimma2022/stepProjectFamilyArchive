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
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Iterator;
import java.util.List;


@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private ChildRepository childRepository;


    @Override
    @Transactional
    public void saveEvent(EventDto eventDto, Integer id) {
        Child child = childRepository.findById(id).orElse(null);
        Event event = eventRepository.save(EventMapper.eventDtoToEvent(eventDto));
        child.getEventsList().add(event);
        childRepository.save(child);
    }

    @Override
    @Transactional
    public void delete(Integer id, Integer childId) {
        Child child = childRepository.findById(childId).orElse(null);
        List<Event> eventList = child.getEventsList();
        Iterator<Event> eventIterator = eventList.iterator();
        while(eventIterator.hasNext()) {

            Event nextEvent = eventIterator.next();
            if (nextEvent.getId().equals(id)) {
                eventIterator.remove();
            }
        }
        childRepository.save(child);
        eventRepository.deleteById(id);
    }


}
