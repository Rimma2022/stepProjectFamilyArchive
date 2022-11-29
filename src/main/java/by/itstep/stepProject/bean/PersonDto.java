package by.itstep.stepProject.bean;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
    private PersonInfoDto details;
}
