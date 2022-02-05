package pl.github.se.team;

import pl.github.se.team.dto.TeamDto;

import java.util.Optional;
import java.util.Set;

public interface TeamQueryRepository {
    Optional<TeamDto> findDtoById(Integer id);

    <T> Set<T> findBy(Class<T> clazz);

    long count();
}
