package pl.niepracuj.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkillCreateDto {

    private String name;

    private Long levelId;

}
