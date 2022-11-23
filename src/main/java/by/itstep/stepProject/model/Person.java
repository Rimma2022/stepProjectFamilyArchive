package by.itstep.stepProject.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @NotEmpty (message = "имя не должно быть пустым")
    @Column(name = "name")
    private String name;
    @Column(name = "middleName")
    private String middleName;
    @Column(name = "surname")
    private String surname;
//    @Column(name = "fullName")
//    private String fullName;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    @NotEmpty(message = "email не должен быть пустым")
    private String email;
    @Column(name = "dateBirth")
    private LocalDate dateBirth;
    @Column(name = "dateDied")
    private LocalDate dateDied;
    @Column(name = "role")
    private String role;
    @Column(name = "relativeRole")
    private String relativeRole;//todo to enum
    //    @Column(name = "education")
//    private String education;
    @OneToOne
    private PersonInfo details;


}
