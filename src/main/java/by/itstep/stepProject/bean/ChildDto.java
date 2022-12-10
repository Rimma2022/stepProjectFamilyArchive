package by.itstep.stepProject.bean;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
