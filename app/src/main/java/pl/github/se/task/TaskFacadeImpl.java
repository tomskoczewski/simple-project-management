package pl.github.se.task;


import pl.github.se.task.dto.TaskDto;
import pl.github.se.user.UserFacade;

public class TaskFacadeImpl implements TaskFacade {
    private final TaskRepository taskRepository;
    private final TaskFactory factory;
    private final UserFacade userFacade;

    public TaskFacadeImpl(final TaskRepository taskRepository, final TaskFactory factory, final UserFacade userFacade) {
        this.taskRepository = taskRepository;
        this.factory = factory;
        this.userFacade = userFacade;
    }

    @Override
    public TaskDto toDto(Task task) {
        return TaskDto.create(task.getId(), userFacade.toDto(task.getAssignee()), task.getName(), task.getDescription(), task.getEstimation(), task.getStatus());
    }

    @Override
    public Task fromDto(TaskDto taskDto) {
        return factory.from(taskDto, userFacade);
    }

}
