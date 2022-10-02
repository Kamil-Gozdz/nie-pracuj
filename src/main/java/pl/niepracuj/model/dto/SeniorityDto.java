package pl.niepracuj.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pl.niepracuj.model.enums.SeniorityEnum;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class SeniorityDto {
    private Long id;

    private SeniorityEnum name;

}
