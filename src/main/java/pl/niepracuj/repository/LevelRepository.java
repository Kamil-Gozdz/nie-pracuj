package pl.niepracuj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.niepracuj.model.entity.Level;

public interface LevelRepository extends JpaRepository<Level,Long> {

}
