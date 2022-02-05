package pl.github.se.project.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import pl.github.se.task.dto.TaskDto;
import pl.github.se.team.dto.TeamDto;

import java.util.List;

@JsonDeserialize(as = ProjectDto.DeserializationImpl.class)
public interface ProjectDto {
    static ProjectDto create(final int id, final String name, final String description, final int daysToDeadline, final List<TaskDto> tasks, final TeamDto team) {
        return new DeserializationImpl(id, name, description, daysToDeadline, tasks, team);
    }

    int getId();

    String getName();

    String getDescription();

    int getDaysToDeadline();

    List<TaskDto> getTasks();

    TeamDto getTeam();


    class DeserializationImpl implements ProjectDto {
        private final int id;
        private final String name;
        private final String description;
        private final int daysToDeadline;
        private final List<TaskDto> tasks;
        private final TeamDto team;

        public DeserializationImpl(final int id, final String name, final String description, final int daysToDeadline, List<TaskDto> tasks, TeamDto team) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.daysToDeadline = daysToDeadline;
            this.tasks = tasks;
            this.team = team;
        }


        @Override
        public int getId() {
            return id;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getDescription() {
            return description;
        }

        @Override
        public int getDaysToDeadline() {
            return daysToDeadline;
        }

        @Override
        public List<TaskDto> getTasks() {
            return tasks;
        }

        @Override
        public TeamDto getTeam() {
            return team;
        }
    }
}
