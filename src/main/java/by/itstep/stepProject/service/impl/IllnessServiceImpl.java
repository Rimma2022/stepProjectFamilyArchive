package by.itstep.stepProject.service.impl;

import by.itstep.stepProject.bean.IllnessDto;
import by.itstep.stepProject.mapper.EventMapper;
import by.itstep.stepProject.mapper.IllnessMapper;
import by.itstep.stepProject.model.Child;
import by.itstep.stepProject.model.Event;
import by.itstep.stepProject.model.Illness;
import by.itstep.stepProject.repository.ChildRepository;
import by.itstep.stepProject.repository.IllnessRepository;
import by.itstep.stepProject.service.IllnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IllnessServiceImpl implements IllnessService {
    @Autowired
    private IllnessRepository illnessRepository;
    @Autowired
    private ChildRepository childRepository;

    @Override
    @Transactional
    public void saveIllness(IllnessDto illnessDto, Child child) {
        Illness illness = illnessRepository.save(IllnessMapper.illnessDtoToIllness(illnessDto));
        child.getIllnessesList().add(illness);
        childRepository.save(child);
    }
}
