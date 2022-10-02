package pl.niepracuj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.niepracuj.model.entity.Seniority;

public interface SeniorityRepository extends JpaRepository<Seniority,Long> {

}
