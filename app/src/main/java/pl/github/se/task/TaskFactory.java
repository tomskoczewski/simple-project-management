package pl.github.se.task;


import pl.github.se.task.dto.TaskDto;
import pl.github.se.user.UserFacade;

class TaskFactory {

    Task from(TaskDto source, UserFacade userFacade) {
        var result = new Task();

        result.setId(source.getId());
        result.setAssignee(userFacade.fromDto(source.getAssignee()));
        result.setName(source.getName());
        result.setDescription(source.getDescription());
        result.setEstimation(source.getEstimation());
        result.setStatus(source.getStatus());

        return result;
    }
}
