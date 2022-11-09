package by.itstep.stepProject.model;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToMany
    private List<Illness> illnesses;
    @OneToMany
    private List<Event> eventsList;
    @OneToMany
    private List<User> relativeList;
    @OneToOne
    private User details;//?????

}
