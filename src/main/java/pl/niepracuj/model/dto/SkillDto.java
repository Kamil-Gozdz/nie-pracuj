package pl.niepracuj.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkillDto {

    private  Long id;

    private String name;

    private LevelDto level;

}
