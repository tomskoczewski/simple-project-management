package pl.github.se.task;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.github.se.task.TaskQueryRepository;
import pl.github.se.task.dto.TaskDto;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
class TaskController {
    private final TaskQueryRepository repository;

    TaskController(final TaskQueryRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<TaskDto> getAllTasks() {
        return new ArrayList<>(repository.findBy(TaskDto.class));
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getTaskById(@PathVariable int id) {
        return repository.findDtoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
