package pl.niepracuj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.niepracuj.model.entity.Skill;

public interface SkillRepository extends JpaRepository<Skill,Long> {

}
