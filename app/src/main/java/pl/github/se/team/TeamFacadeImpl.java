package pl.github.se.team;


import pl.github.se.team.dto.TeamDto;
import pl.github.se.user.UserFacade;
import pl.github.se.user.dto.UserDto;

import java.util.List;
import java.util.stream.Collectors;

public class TeamFacadeImpl implements TeamFacade {
    private final TeamRepository teamRepository;
    private final TeamFactory factory;
    private final UserFacade userFacade;

    public TeamFacadeImpl(final TeamRepository teamRepository, final TeamFactory factory, UserFacade userFacade) {
        this.teamRepository = teamRepository;
        this.factory = factory;
        this.userFacade = userFacade;
    }

    public TeamDto toDto(Team team) {
        List<UserDto> members = team.getMembers().stream().map(userFacade::toDto).collect(Collectors.toList());
        return TeamDto.create(team.getId(), team.getName(), team.getDescription(), members, userFacade.toDto(team.getMaster()));
    }

    public Team fromDto(TeamDto teamDto) {
        return factory.from(teamDto, userFacade);
    }

}
