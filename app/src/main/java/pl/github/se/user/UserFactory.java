package pl.github.se.user;

import pl.github.se.user.dto.UserDto;

public class UserFactory {
    public User from(UserDto source) {
        var result = new User();

        result.setId(source.getId());
        result.setUsername(source.getUsername());
        result.setUserType(source.getUserType());
        result.setDescription(source.getDescription());
        result.setMail(source.getMail());
        result.setPassword(source.getPassword());

        return result;
    }

}
