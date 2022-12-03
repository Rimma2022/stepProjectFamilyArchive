package by.itstep.stepProject.mapper;

import by.itstep.stepProject.bean.PersonDto;
import by.itstep.stepProject.model.Person;

public class PersonMapper {
    public static Person personDtoToPerson(PersonDto dto){
        return Person.builder()
                .email(dto.getEmail())
                .name(dto.getName())
                .surname(dto.getSurname())
                .password(dto.getPassword())
                .build();
    }
}



