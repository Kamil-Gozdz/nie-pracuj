package pl.niepracuj.service.technology;

import pl.niepracuj.model.dto.TechnologyDto;

import java.util.List;

public interface TechnologyService {

    List<TechnologyDto> getAllTechnologies();

    TechnologyDto createTechnology(TechnologyDto technologyDto);
}
