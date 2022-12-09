package by.itstep.stepProject.service;

import by.itstep.stepProject.bean.IllnessDto;
import by.itstep.stepProject.model.Child;

public interface IllnessService {
    void saveIllness(IllnessDto illnessDto, Integer id);
}
