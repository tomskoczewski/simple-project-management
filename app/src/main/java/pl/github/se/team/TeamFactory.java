package pl.github.se.team;


import pl.github.se.team.dto.TeamDto;
import pl.github.se.user.UserFacade;

import java.util.stream.Collectors;

class TeamFactory {

    Team from(TeamDto source, UserFacade userFacade) {
        var result = new Team();

        result.setId(source.getId());
        result.setName(source.getName());
        result.setDescription(source.getDescription());
        result.setMembers(source.getMembers().stream().map(userFacade::fromDto).collect(Collectors.toList()));
        result.setMaster(userFacade.fromDto(source.getMaster()));

        return result;
    }
}
