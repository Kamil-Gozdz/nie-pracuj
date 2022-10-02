package pl.niepracuj.service.seniority;

import pl.niepracuj.model.dto.CompanyDto;
import pl.niepracuj.model.dto.SeniorityDto;

import java.util.List;

public interface SeniorityService {
    List<SeniorityDto> getAllSeniorities();

    SeniorityDto createSeniority(SeniorityDto seniorityDto);
}
