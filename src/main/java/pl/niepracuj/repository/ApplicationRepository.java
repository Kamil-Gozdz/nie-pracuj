package pl.niepracuj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.niepracuj.model.entity.Application;

public interface ApplicationRepository extends JpaRepository<Application,Long> {

}
