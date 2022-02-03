package pl.github.se.task;


import pl.github.se.task.dto.TaskDto;

class TaskFactory {
    Task from(TaskDto source) {
        var result = new Task();

        result.setId(source.getId());
        //TODO fix assignee
        result.setAssignee(null);
        result.setName(source.getName());
        result.setDescription(source.getDescription());
        result.setEstimation(source.getEstimation());
        result.setStatus(source.getStatus());

        return result;
    }
}
