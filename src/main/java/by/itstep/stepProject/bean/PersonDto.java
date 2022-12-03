package by.itstep.stepProject.bean;

import by.itstep.stepProject.model.PersonInfo;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class PersonDto {
    private Integer id;
    private String name;
    private String middleName;
    private String surname;
    private String password;
    private String email;
    private LocalDate dateBirth;
    private LocalDate dateDied;
    private String relativeRole;
    private PersonInfo details;
    private String role;
}
