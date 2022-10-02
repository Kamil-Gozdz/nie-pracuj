package pl.niepracuj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.niepracuj.model.entity.City;

public interface CityRepository extends JpaRepository<City,Long> {

}
