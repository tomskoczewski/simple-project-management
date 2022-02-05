package pl.github.se.project;

import pl.github.se.project.dto.ProjectDto;
import pl.github.se.task.TaskFacade;
import pl.github.se.team.TeamFacade;

import java.util.stream.Collectors;

class ProjectFactory {
    Project from(ProjectDto source, TaskFacade taskFacade, TeamFacade teamFacade) {
        var result = new Project();

        result.setId(source.getId());
        result.setName(source.getName());
        result.setDaysToDeadline(source.getDaysToDeadline());
        result.setDescription(source.getDescription());
        result.setTasks(source.getTasks().stream().map(taskFacade::fromDto).collect(Collectors.toList()));
        result.setTeam(teamFacade.fromDto(source.getTeam()));

        return result;
    }
}
