package pl.niepracuj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.niepracuj.model.entity.Advertisement;

import java.util.List;

public interface AdvertisementRepository extends JpaRepository<Advertisement,Long>, JpaSpecificationExecutor<Advertisement> {

    List<Advertisement> findByCompanyId(Long companyId);
}
