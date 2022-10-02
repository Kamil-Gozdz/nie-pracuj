package pl.niepracuj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.niepracuj.model.entity.State;

public interface StateRepository extends JpaRepository<State,Long> {

}
