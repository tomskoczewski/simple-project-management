package pl.github.se.user;

import pl.github.se.user.dto.UserDto;

class UserFactory {
    User from(UserDto source) {
        var result = new User();

        result.setId(source.getId());
        result.setUser(source.getUser());
        result.setUserType(source.getUserType());

        return result;
    }
}
