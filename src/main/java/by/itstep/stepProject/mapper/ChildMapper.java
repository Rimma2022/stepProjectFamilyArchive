package by.itstep.stepProject.mapper;

import by.itstep.stepProject.bean.ChildDto;
import by.itstep.stepProject.model.Child;
import by.itstep.stepProject.model.Person;

import java.time.LocalDate;

public class ChildMapper {
    public static Child childDtoToChild(ChildDto dto, Person person){
        return Child.builder()
                .email(dto.getEmail())
                .mainParent(person)
                .name(dto.getName())
                .surname(dto.getSurname())
                .middleName(dto.getMiddleName())
                .gender(dto.getGender())
                .dateBirth(LocalDate.parse(dto.getDateBirth()))
                .build();
    }

}


