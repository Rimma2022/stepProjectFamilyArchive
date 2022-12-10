package by.itstep.stepProject.model;


import lombok.*;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToMany
    private List<Illness> illnessesList;
    @OneToMany
    private List<Event> eventsList;
    @OneToMany
    private List<Person> relativeList;
    @Column(name = "name")
    private String name;
    @Column(name = "middleName")
    private String middleName;
    @Column(name = "surname")
    private String surname;
    @Column(name = "email")
    private String email;
    @Column(name = "dateBirth")
    private LocalDate dateBirth;
    @Column(name = "gender")
    private String gender;
    @OneToOne
    private Person mainParent;
}
