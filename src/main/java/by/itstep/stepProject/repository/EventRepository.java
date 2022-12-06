package by.itstep.stepProject.repository;

import by.itstep.stepProject.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {
}
