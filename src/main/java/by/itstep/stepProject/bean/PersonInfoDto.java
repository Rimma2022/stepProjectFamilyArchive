package by.itstep.stepProject.bean;


import by.itstep.stepProject.model.Child;
import by.itstep.stepProject.model.Profession;
import lombok.*;


import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PersonInfoDto {
    private Integer id;
    private String education;
    private List<Child> childrenList;
    private List<Profession> professionsList;
    private List<Integer> relativeIds;
}
