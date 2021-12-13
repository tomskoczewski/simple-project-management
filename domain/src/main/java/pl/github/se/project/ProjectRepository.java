package pl.github.se.project;

import java.util.Optional;

interface ProjectRepository {
    Project save(Project project);

    void delete(Project project);
}
