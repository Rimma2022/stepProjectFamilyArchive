package by.itstep.stepProject.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @NotEmpty (message = "Не указано имя")
    @Column(name = "name")
    private String name;
    @Column(name = "middleName")
    private String middleName;
    @NotEmpty (message = "Не указана фамилия")
    @Column(name = "surname")
    private String surname;
    @Column(name = "password")
    private String password;
    @Email (message = "Неверно указан email")
    @Column(name = "email")
    @NotEmpty(message = "email не должен быть пустым")
    private String email;
    @Column(name = "dateBirth")
    @DateTimeFormat(pattern = "dd.mm.yyyy")
    private LocalDate dateBirth;
    @Column(name = "dateDied")
    private LocalDate dateDied;
    @Column(name = "role")
    private String role;
    @Column(name = "relativeRole")
    private String relativeRole;
    @OneToOne
    private PersonInfo details;


}
