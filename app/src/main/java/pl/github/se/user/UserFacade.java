package pl.github.se.user;

import pl.github.se.user.dto.UserDto;

public class UserFacade {
    private final UserRepository repository;
    private final UserFactory factory;

    public UserFacade(final UserRepository repository, final UserFactory factory) {
        this.repository = repository;
        this.factory = factory;
    }

    private UserDto toDto(User user) {
        return UserDto.create(user.getId(), user.getUser(), user.getUserType());
    }

    private User fromDto(UserDto userDto) {
        return factory.from(userDto);
    }

}
