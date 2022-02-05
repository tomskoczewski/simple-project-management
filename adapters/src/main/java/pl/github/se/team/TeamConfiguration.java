package pl.github.se.team;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.github.se.team.TeamFacadeImpl;
import pl.github.se.user.UserFacade;

@Configuration
class TeamConfiguration {
    @Bean
    TeamFacade teamFacade(
            TeamRepository teamRepository, UserFacade userFacade
    ) {
        return new TeamFacadeImpl(
                teamRepository,
                new TeamFactory(),
                userFacade);
    }
}
