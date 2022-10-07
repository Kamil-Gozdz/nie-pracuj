package pl.niepracuj.model.mapper;

import org.springframework.stereotype.Component;
import pl.niepracuj.model.dto.StateDto;
import pl.niepracuj.model.entity.State;

@Component
public class StateMapper {

    public StateDto toDto(State state) {
        return StateDto.builder()
                .id(state.getId())
                .name(state.getName())
                .build();
    }
}