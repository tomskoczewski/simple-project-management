package pl.github.se.project;

import pl.github.se.project.dto.ProjectDto;

import java.util.Optional;
import java.util.Set;

public interface ProjectQueryRepository {
    Optional<ProjectDto> findDtoById(Integer id);

    <T> Set<T> findBy(Class<T> clazz);

    long count();
}
