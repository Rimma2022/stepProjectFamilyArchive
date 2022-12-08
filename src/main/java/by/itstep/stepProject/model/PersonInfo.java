package by.itstep.stepProject.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class PersonInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "education")
    private String education;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Child> childrenList;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Profession> professionsList;
    @ElementCollection
    private List<Integer> relativeIds;
}
