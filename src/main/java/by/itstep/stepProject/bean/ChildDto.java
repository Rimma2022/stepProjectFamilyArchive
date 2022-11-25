package by.itstep.stepProject.bean;

import by.itstep.stepProject.model.Event;
import by.itstep.stepProject.model.Illness;
import by.itstep.stepProject.model.Person;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChildDto {
    private Integer id;
//    private String name;
//    private String middleName;
//    private String surname;
//    private String email;
//    private LocalDate dateBirth;
    private String gender;
    private List<Illness> illnesses;
    private List<Event> eventsList;
    private List<Person> relativeList;
    private Person details;
}
