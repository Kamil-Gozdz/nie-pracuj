package pl.niepracuj.model.advertisement;


import lombok.*;
import pl.niepracuj.model.dto.*;

import java.time.LocalDateTime;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class AdvertisementDto {

    private Long id;

    private String name;

    private LocalDateTime publishDate;

    private LocalDateTime expireDate;

    private Long salaryFrom;

    private Long salaryTo;

    private String description;

    private CompanyDto company;

    private TechnologyDto technology;

    private SeniorityDto seniority;

    private CityDto city;

    private Set<SkillDto> skills;

}
