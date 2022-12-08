package by.itstep.stepProject.bean;



import by.itstep.stepProject.model.Event;
import by.itstep.stepProject.model.Person;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ChildDto {
    private String name;
    private String middleName;
    private String surname;
    private String email;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private String dateBirth;
    private String gender;
    private Integer mainParentId;
}
