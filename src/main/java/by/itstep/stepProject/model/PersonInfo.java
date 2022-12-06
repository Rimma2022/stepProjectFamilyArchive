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
    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
//    @JoinColumn(name = "childId", foreignKey = @ForeignKey(name = "childId"))
    private List<Child> childrenList;
    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
//    @JoinColumn(name = "professionsListId", foreignKey = @ForeignKey(name = "professionsListId")) //todo
    private List<Profession> professionsList;
    @ElementCollection //???????
    private List<Integer> relativeIds; //todo - userIds if u need get from db u need used -> findAllByIdIn(List<Integer> ids)
}
