package pl.github.se.user;

import pl.github.se.user.dto.UserDto;

public interface UserFacade {
    UserDto toDto(User user);

    User fromDto(UserDto userDto);
}
