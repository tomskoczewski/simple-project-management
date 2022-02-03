package pl.github.se.project.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import pl.github.se.task.Task;
import pl.github.se.task.dto.TaskDto;

import java.util.List;

@JsonDeserialize(as = ProjectDto.DeserializationImpl.class)
public interface ProjectDto {
    static ProjectDto create(final int id, final String name, final String description, final int daysToDeadline, List<TaskDto> tasks) {
        return new DeserializationImpl(id, name, description, daysToDeadline, tasks);
    }

    int getId();

    String getName();

    String getDescription();

    int getDaysToDeadline();

    List<TaskDto> getTasks();


    class DeserializationImpl implements ProjectDto {
        private final int id;
        private final String name;
        private final String description;
        private final int daysToDeadline;
        private final List<TaskDto> tasks;

        public DeserializationImpl(final int id, final String name, final String description, final int daysToDeadline, List<TaskDto> tasks) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.daysToDeadline = daysToDeadline;
            this.tasks = tasks;
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
    }
}
