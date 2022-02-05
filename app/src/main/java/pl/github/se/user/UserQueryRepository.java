package pl.github.se.user;

import pl.github.se.project.dto.ProjectDto;
import pl.github.se.user.dto.UserDto;

import java.util.Optional;
import java.util.Set;

public interface UserQueryRepository {
    Optional<UserDto> findDtoById(int id);

    <T> Set<T> findBy(Class<T> clazz);

    long count();
}
