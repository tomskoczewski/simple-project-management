package pl.github.se.project;

import pl.github.se.project.dto.ProjectDto;
import pl.github.se.task.TaskFacade;
import pl.github.se.task.dto.TaskDto;
import pl.github.se.team.TeamFacade;

import java.util.List;
import java.util.stream.Collectors;

public class ProjectFacade {
    private final ProjectRepository projectRepository;
    private final ProjectFactory factory;
    private final TaskFacade taskFacade;
    private final TeamFacade teamFacade;

    public ProjectFacade(final ProjectRepository projectRepository, final ProjectFactory factory, final TaskFacade taskFacade, TeamFacade teamFacade) {
        this.projectRepository = projectRepository;
        this.factory = factory;
        this.taskFacade = taskFacade;
        this.teamFacade = teamFacade;
    }

    private ProjectDto toDto(Project project) {
        List<TaskDto> projectTasks = project.getTasks().stream().map(taskFacade::toDto).collect(Collectors.toList());
        return ProjectDto.create(project.getId(), project.getName(), project.getDescription(), project.getDaysToDeadline(), projectTasks, teamFacade.toDto(project.getTeam()));
    }

    private Project fromDto(ProjectDto projectDto) {
        return factory.from(projectDto, taskFacade, teamFacade);
    }

}
