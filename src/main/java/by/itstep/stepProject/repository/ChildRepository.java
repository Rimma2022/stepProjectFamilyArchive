package by.itstep.stepProject.repository;

import by.itstep.stepProject.model.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

@Repository
public interface ChildRepository extends JpaRepository<Child, Integer> {





}
