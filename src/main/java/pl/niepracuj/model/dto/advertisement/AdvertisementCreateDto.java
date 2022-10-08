package pl.niepracuj.model.dto.advertisement;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import pl.niepracuj.model.dto.SkillCreateDto;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.Set;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdvertisementCreateDto {

    @Size(max = 250, message = "Size can't be bigger than 250 characters")
    @NotBlank(message = "Name is mandatory")
    private String name;
    @Future(message = "Expire date can't be less than current date")
//  TODO  @Pattern() - zamienić na to
    @DateTimeFormat(pattern = "yyyy-MM-ddThh:mm:ss")
    private LocalDateTime expireDate;
    @NotNull(message = "Salary from is mandatory")
    @Min(value = 0, message = "Salary from must be 0 or more")
    private Long salaryFrom;
    @NotNull(message = "Salary to is mandatory")
    @Min(value = 0, message = "Salary to must by 0 or more")
    private Long salaryTo;
    @NotBlank(message = "Description is mandatory")
    private String description;
    @NotNull(message = "Company id is mandatory")
    private Long companyId;
    @NotNull(message = "Technology id is mandatory")
    private Long technologyId;
    @NotNull(message = "Seniority id is mandatory")
    private Long seniorityId;
    @NotNull(message = "City id is mandatory")
    private Long cityId;

    private Set<SkillCreateDto> skills;

}

