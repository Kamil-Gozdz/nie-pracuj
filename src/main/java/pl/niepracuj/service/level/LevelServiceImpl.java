package pl.niepracuj.service.level;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.niepracuj.model.dto.LevelDto;
import pl.niepracuj.model.mapper.LevelMapper;
import pl.niepracuj.repository.LevelRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class LevelServiceImpl implements LevelService{
    final private LevelRepository levelRepository;
    final private LevelMapper levelMapper;

    @Override
    public List<LevelDto> getAllLevels() {
        return levelRepository.findAll().stream().map(levelMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public LevelDto createLevel(LevelDto levelDto) {
        return levelMapper.toDto(levelRepository.save(levelMapper.toNewEntity(levelDto)));
    }
}
