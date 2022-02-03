package pl.github.se.task.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import pl.github.se.task.Task;
import pl.github.se.task.TaskStatus;
import pl.github.se.user.User;
import pl.github.se.user.dto.UserDto;

import java.util.List;

@JsonDeserialize(as = TaskDto.DeserializationImpl.class)
public interface TaskDto {
    static TaskDto create(final int id, final UserDto assignee, final String name, final String description, final int estimation, TaskStatus status) {
        return new DeserializationImpl(id, assignee, name, description, estimation, status);
    }

    int getId();

    UserDto getAssignee();

    String getName();

    String getDescription();

    int getEstimation();

    TaskStatus getStatus();


    class DeserializationImpl implements TaskDto {
        private final int id;
        private final UserDto assignee;
        private final String name;
        private final String description;
        private final int estimation;
        private final TaskStatus status;

        public DeserializationImpl(final int id, final UserDto assignee, final String name, final String description, final int estimation, final TaskStatus status) {
            this.id = id;
            this.assignee = assignee;
            this.name = name;
            this.description = description;
            this.estimation = estimation;
            this.status = status;
        }

        @Override
        public int getId() {
            return id;
        }

        @Override
        public UserDto getAssignee() {
            return assignee;
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
        public int getEstimation() {
            return estimation;
        }

        @Override
        public TaskStatus getStatus() {
            return status;
        }
    }
}
