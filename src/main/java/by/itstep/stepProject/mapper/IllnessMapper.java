package by.itstep.stepProject.mapper;

import by.itstep.stepProject.bean.IllnessDto;
import by.itstep.stepProject.model.Illness;

public class IllnessMapper {
    public static Illness illnessDtoToIllness(IllnessDto dto) {
        return Illness.builder()
                .name(dto.getName())
                .age(dto.getAge())
                .build();
    }
}
