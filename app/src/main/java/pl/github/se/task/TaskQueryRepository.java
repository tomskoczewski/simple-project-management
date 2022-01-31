package pl.github.se.task;

import pl.github.se.task.dto.TaskDto;

import java.util.Optional;
import java.util.Set;

public interface TaskQueryRepository {
    Optional<TaskDto> findDtoById(Integer id);

    <T> Set<T> findBy(Class<T> clazz);

    long count();
}
