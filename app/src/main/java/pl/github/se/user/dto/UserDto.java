package pl.github.se.user.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import pl.github.se.user.UserType;

@JsonDeserialize(as = UserDto.DeserializationImpl.class)
public interface UserDto {
    static UserDto create(final int id,
                          final String user,
                          final UserType userType,
                          final String password,
                          final String description,
                          final String mail) {
        return new DeserializationImpl(id, user,  userType, password, description, mail);
    }

    int getId();

    String getUsername();

    UserType getUserType();
    String getPassword();
    String getMail();
    String getDescription();

    class DeserializationImpl implements UserDto {
        private final int id;
        private final String username;
        private final UserType userType;
        private final String password;
        private final String description;
        private final String mail;

        public DeserializationImpl(final int id, final String username, final UserType userType, final String password, final String description, String mail) {
            this.id = id;
            this.username = username;
            this.userType = userType;
            this.password = password;
            this.description = description;
            this.mail = mail;
        }

        @Override
        public int getId() {
            return id;
        }

        @Override
        public String getUsername() {
            return username;
        }

        @Override
        public UserType getUserType() {
            return userType;
        }

        @Override
        public String getPassword() {
            return password;
        }

        @Override
        public String getDescription() {
            return description;
        }

        @Override
        public String getMail() {
            return mail;
        }
    }
}
