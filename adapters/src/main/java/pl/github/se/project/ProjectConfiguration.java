package pl.github.se.project;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ProjectConfiguration {
    @Bean
    ProjectFacade projectFacade(
            ProjectRepository projectRepository
    ) {
        return new ProjectFacade(
                projectRepository,
                new ProjectFactory()
        );
    }
}
