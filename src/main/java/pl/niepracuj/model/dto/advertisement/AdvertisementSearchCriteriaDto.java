package pl.niepracuj.model.dto.advertisement;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import pl.niepracuj.model.dto.SkillCreateDto;
import pl.niepracuj.model.enums.SeniorityEnum;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.Set;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdvertisementSearchCriteriaDto {


    private String name;

    private Long salaryFrom;

    private Long salaryTo;

    private String companyName;

    private String technologyName;

    private SeniorityEnum seniorityName;

    private String cityName;

    private Set<SkillCreateDto> skills;

}

