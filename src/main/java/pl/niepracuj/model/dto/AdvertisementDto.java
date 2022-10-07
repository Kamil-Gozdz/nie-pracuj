package pl.niepracuj.model.dto;


import lombok.*;
import pl.niepracuj.model.entity.Company;

import java.time.Instant;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class AdvertisementDto {

    private Long id;

    private String name;

    private Instant publishDate;

    private Instant expireDate;

    private Long salaryFrom;

    private Long salaryTo;

    private String description;

    private CompanyDto company;

    private TechnologyDto technology;

    private SeniorityDto seniority;

    private CityDto city;

    private Set<SkillDto> skills;

}
