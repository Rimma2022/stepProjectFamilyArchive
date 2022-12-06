package by.itstep.stepProject.mapper;

import by.itstep.stepProject.bean.EventDto;
import by.itstep.stepProject.bean.PersonDto;
import by.itstep.stepProject.model.Event;
import by.itstep.stepProject.model.Person;

import java.time.LocalDate;

public class EventMapper {
    public static Event eventDtoToEvent(EventDto dto){
        return Event.builder()
                .name(dto.getName())
                .date(LocalDate.parse(dto.getDate()))
                .descriptionOfEvent(dto.getDescriptionOfEvent())
                .build();
    }
}
