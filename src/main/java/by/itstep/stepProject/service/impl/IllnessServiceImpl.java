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

import java.util.Iterator;
import java.util.List;

@Service
public class IllnessServiceImpl implements IllnessService {
    @Autowired
    private IllnessRepository illnessRepository;
    @Autowired
    private ChildRepository childRepository;

    @Override
    @Transactional
    public void saveIllness(IllnessDto illnessDto, Integer id) {
        Child child = childRepository.findById(id).orElse(null);
        Illness illness = illnessRepository.save(IllnessMapper.illnessDtoToIllness(illnessDto));
        child.getIllnessesList().add(illness);
        childRepository.save(child);
    }

    @Override
    @Transactional
    public void delete(int id, int childId) {
        Child child = childRepository.findById(childId).orElse(null);
        List<Illness> illnessList = child.getIllnessesList();
        Iterator<Illness> illnessIterator = illnessList.iterator();
        while(illnessIterator.hasNext()) {
            Illness nextIllness = illnessIterator.next();
            if (nextIllness.getId().equals(id)) {
                illnessIterator.remove();
            }
        }
        childRepository.save(child);
        illnessRepository.deleteById(id);
    }

}
