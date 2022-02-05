package pl.github.se.team;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.github.se.team.TeamQueryRepository;
import pl.github.se.team.dto.TeamDto;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/teams")
class TeamController {
    private final TeamQueryRepository repository;

    TeamController(final TeamQueryRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<TeamDto> getAllTeams() {
        return new ArrayList<>(repository.findBy(TeamDto.class));
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getTeamById(@PathVariable int id) {
        return repository.findDtoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
