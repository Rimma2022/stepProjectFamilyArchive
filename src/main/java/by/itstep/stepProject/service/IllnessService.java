package by.itstep.stepProject.service;

import by.itstep.stepProject.bean.IllnessDto;

public interface IllnessService {
    void saveIllness(IllnessDto illnessDto, Integer id);

    void delete(int id, int childId);
}
