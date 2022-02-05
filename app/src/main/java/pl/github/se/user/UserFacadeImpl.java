package pl.github.se.user;

import pl.github.se.user.dto.UserDto;

public class UserFacadeImpl implements UserFacade {
    private final UserRepository repository;
    private final UserQueryRepository queryRepository;
    private final UserFactory factory;


    public UserFacadeImpl(final UserRepository repository, final UserQueryRepository queryRepository, final UserFactory factory) {
        this.repository = repository;
        this.queryRepository = queryRepository;
        this.factory = factory;
    }

    @Override
    public UserDto toDto(User user) {
        return UserDto.create(user.getId(), user.getUsername(), user.getUserType(), user.getPassword(), user.getDescription(), user.getMail());
    }

    @Override
    public User fromDto(UserDto userDto) {
        return factory.from(userDto);
    }

}
