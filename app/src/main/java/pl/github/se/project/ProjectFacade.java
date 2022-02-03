package pl.github.se.project;

import pl.github.se.project.dto.ProjectDto;
import pl.github.se.task.dto.TaskDto;
import pl.github.se.user.dto.UserDto;

import java.util.stream.Collectors;

public class ProjectFacade {
    private final ProjectRepository projectRepository;
    private final ProjectFactory factory;

    public ProjectFacade(final ProjectRepository projectRepository, final ProjectFactory factory) {
        this.projectRepository = projectRepository;
        this.factory = factory;
    }

    private ProjectDto toDto(Project project) {
        return ProjectDto.create(project.getId(), project.getName(), project.getDescription(), project.getDaysToDeadline(),
                project.getTasks().stream().map(t -> TaskDto.create(t.getId(), UserDto.create(t.getAssignee().getId(),t.getAssignee().getUser(),t.getAssignee().getUserType()),t.getName(),t.getDescription(),t.getEstimation(),t.getStatus())).collect(Collectors.toList()));
    }

    private Project fromDto(ProjectDto projectDto) {
        return factory.from(projectDto);
    }

}
