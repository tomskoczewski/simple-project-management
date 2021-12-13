package pl.github.se.project;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.github.se.project.dto.ProjectDto;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/projects")
class ProjectController {
    private final ProjectQueryRepository repository;

    ProjectController(final ProjectQueryRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<ProjectDto> getAllProjects() {
        return new ArrayList<>(repository.findBy(ProjectDto.class));
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getProjectById(@PathVariable int id) {
        return repository.findDtoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
