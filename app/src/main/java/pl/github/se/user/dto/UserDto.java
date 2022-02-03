package pl.github.se.user.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import pl.github.se.user.UserType;

@JsonDeserialize(as = UserDto.DeserializationImpl.class)
public interface UserDto {
    static UserDto create(final int id,
                          final String user,
                          final UserType userType) {
        return new DeserializationImpl(id, user,  userType);
    }

    int getId();

    String getUser();

    UserType getUserType();


    class DeserializationImpl implements UserDto {
        private final int id;
        private final String user;
        private final UserType userType;

        public DeserializationImpl(final int id, final String user, final UserType userType) {
            this.id = id;
            this.user = user;
            this.userType = userType;
        }

        @Override
        public int getId() {
            return id;
        }

        @Override
        public String getUser() {
            return user;
        }


        @Override
        public UserType getUserType() {
            return userType;
        }
    }
}
