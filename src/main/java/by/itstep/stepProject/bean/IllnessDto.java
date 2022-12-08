package by.itstep.stepProject.bean;

import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class IllnessDto {
    private String name;
    private String age;
}
