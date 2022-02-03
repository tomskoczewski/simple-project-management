package pl.github.se.task;


import pl.github.se.task.dto.TaskDto;
import pl.github.se.user.dto.UserDto;

public class TaskFacade {
    private final TaskRepository taskRepository;
    private final TaskFactory factory;

    public TaskFacade(final TaskRepository taskRepository, final TaskFactory factory) {
        this.taskRepository = taskRepository;
        this.factory = factory;
    }

    //TODO assignee fix
    private TaskDto toDto(Task task) {
        return TaskDto.create(task.getId(), UserDto.create(task.getAssignee().getId(),task.getAssignee().getUser(), task.getAssignee().getUserType()), task.getName(), task.getDescription(), task.getEstimation(), task.getStatus());
    }

    private Task fromDto(TaskDto taskDto) {
        return factory.from(taskDto);
    }

}
