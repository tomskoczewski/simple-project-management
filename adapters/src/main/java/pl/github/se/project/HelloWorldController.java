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
@RequestMapping("/")
class HelloWorldController {

    @GetMapping
    String getHelloWorld() {
        return "Hello world from Pipeline";
    }

}
