package pl.github.se.team.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import pl.github.se.user.dto.UserDto;

import java.util.List;

@JsonDeserialize(as = TeamDto.DeserializationImpl.class)
public interface TeamDto {
    static TeamDto create(final int id, final String name, final String description, final List<UserDto> members, final UserDto master) {
        return new DeserializationImpl(id, name, description, members, master);
    }

    int getId();

    String getName();

    String getDescription();

    List<UserDto> getMembers();

    UserDto getMaster();


    class DeserializationImpl implements TeamDto {
        private final int id;
        private final String name;
        private final String description;
        private final List<UserDto> members;
        private final UserDto master;

        public DeserializationImpl(final int id, final String name, final String description, final List<UserDto> members, final UserDto master) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.members = members;
            this.master = master;
        }

        @Override
        public int getId() {
            return id;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getDescription() {
            return description;
        }

        @Override
        public List<UserDto> getMembers() {
            return members;
        }

        @Override
        public UserDto getMaster() {
            return master;
        }
    }
}
