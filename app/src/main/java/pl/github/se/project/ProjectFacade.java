package pl.github.se.project;

import pl.github.se.project.dto.ProjectDto;

public class ProjectFacade {
    private final ProjectRepository projectRepository;
    private final ProjectFactory factory;

    public ProjectFacade(final ProjectRepository projectRepository, final ProjectFactory factory) {
        this.projectRepository = projectRepository;
        this.factory = factory;
    }

    private ProjectDto toDto(Project project) {
        return ProjectDto.create(project.getId(), project.getName(), project.getDescription(), project.getDaysToDeadline());
    }

    private Project fromDto(ProjectDto projectDto) {
        return factory.from(projectDto);
    }

}
