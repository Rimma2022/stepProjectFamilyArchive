package by.itstep.stepProject.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "fullName")
    private String fullName; //Алешкевич Станислав Викторочич
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "dateBirth")
    private LocalDate dateBirth;
    @Column(name = "dateDied")
    private LocalDate dateDied;
    @Column(name = "whoIsThis")
    private String whoIsThis;//todo to enum
//    @Column(name = "education")
//    private String education;
    @OneToOne
    private UserDetails details;
}
