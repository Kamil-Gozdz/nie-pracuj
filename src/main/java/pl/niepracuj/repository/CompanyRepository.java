package pl.niepracuj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.niepracuj.model.entity.Company;

public interface CompanyRepository extends JpaRepository<Company,Long> {

}
