package pl.github.se.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.github.se.project.ProjectQueryRepository;
import pl.github.se.project.dto.ProjectDto;
import pl.github.se.user.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
class UserController {
    private final UserQueryRepository repository;

    UserController(final UserQueryRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<UserDto> getAllUsers() {
        return new ArrayList<>(repository.findBy(UserDto.class));
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getUserById(@PathVariable int id) {
        return repository.findDtoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
