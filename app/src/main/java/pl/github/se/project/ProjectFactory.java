package pl.github.se.project;

import pl.github.se.project.dto.ProjectDto;

class ProjectFactory {
    Project from(ProjectDto source) {
        var result = new Project();

        result.setId(source.getId());
        result.setName(source.getName());
        result.setDaysToDeadline(source.getDaysToDeadline());
        result.setDescription(source.getDescription());

        return result;
    }
}
