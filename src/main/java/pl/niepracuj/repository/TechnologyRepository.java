package pl.niepracuj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.niepracuj.model.entity.Technology;

public interface TechnologyRepository extends JpaRepository<Technology,Long> {

}
