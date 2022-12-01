package by.itstep.stepProject.repository;

import by.itstep.stepProject.model.PersonInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonInfoRepository extends JpaRepository<PersonInfo, Integer> {
}
