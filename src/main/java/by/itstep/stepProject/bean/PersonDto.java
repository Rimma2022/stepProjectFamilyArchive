package by.itstep.stepProject.bean;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PersonDto {
    private Integer id;
    private String name;
    private String surname;
    private String password;
    private String email;
}
