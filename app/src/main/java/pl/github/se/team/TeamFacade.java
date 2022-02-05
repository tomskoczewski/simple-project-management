package pl.github.se.team;

import pl.github.se.team.dto.TeamDto;
import pl.github.se.user.dto.UserDto;

import java.util.List;
import java.util.stream.Collectors;

public interface TeamFacade {
    TeamDto toDto(Team team);

    Team fromDto(TeamDto teamDto);
}
