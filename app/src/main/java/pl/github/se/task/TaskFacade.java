package pl.github.se.task;

import pl.github.se.task.dto.TaskDto;

public interface TaskFacade {
    TaskDto toDto(Task task);

    Task fromDto(TaskDto taskDto);
}
