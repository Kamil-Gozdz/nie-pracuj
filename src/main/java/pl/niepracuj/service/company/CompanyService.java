package pl.niepracuj.service.company;

import org.springframework.web.bind.annotation.RequestBody;
import pl.niepracuj.model.dto.CompanyDto;

import java.util.List;

public interface CompanyService {

    List<CompanyDto> getAllCompanies();

    CompanyDto createCompany(CompanyDto companyDto);
}
