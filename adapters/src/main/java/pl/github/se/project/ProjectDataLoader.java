package pl.github.se.project;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
class ProjectDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    private final ProjectDataInitializer projectDataInitializer;


    ProjectDataLoader(final ProjectRepository projectRepository, final ProjectQueryRepository projectQueryRepository) {
        this.projectDataInitializer = new ProjectDataInitializer(projectRepository, projectQueryRepository);
    }

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent contextRefreshedEvent) {
        projectDataInitializer.init();
    }
}
