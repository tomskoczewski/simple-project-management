package pl.github.se.project;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.github.se.task.TaskFacade;
import pl.github.se.team.Team;
import pl.github.se.team.TeamFacade;

@Configuration
class ProjectConfiguration {
    @Bean
    ProjectFacade projectFacade(
            ProjectRepository projectRepository,
            TaskFacade taskFacade,
            TeamFacade teamFacade
    ) {
        return new ProjectFacade(
                projectRepository,
                new ProjectFactory(),
                taskFacade,
                teamFacade);
    }
}
