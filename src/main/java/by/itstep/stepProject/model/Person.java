package by.itstep.stepProject.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "middleName")
    private String middleName;
    @Column(name = "surname")
    private String surname;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "dateBirth")
    private LocalDate dateBirth;
    @Column(name = "dateDied")
    private LocalDate dateDied;
    @Column(name = "whoIsThis")
    private String whoIsThis;
    @Column(name = "education")
    private String education;
    @ElementCollection
    private List<String> profession;
    @ElementCollection
    private List<String> illness;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinColumn(name = "childId", foreignKey = @ForeignKey(name = "childId"))
    private List<Child> childrenList;
//    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch=FetchType.LAZY)
//    @JoinColumn(name = "relativeId", foreignKey = @ForeignKey(name = "relativeId"))
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "person_relative", joinColumns = {@JoinColumn(name="person_id", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name="relative_id", referencedColumnName = "ID")})
    private List<Relative> relativesList;
    public Person(String name, String surname, String password, String email) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
    }


}
