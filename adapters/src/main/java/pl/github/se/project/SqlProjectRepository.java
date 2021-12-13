package pl.github.se.project;


import org.springframework.data.repository.Repository;

import java.util.Optional;

interface SqlProjectRepository extends Repository<SqlProject, Integer> {
    SqlProject save(SqlProject project);

    void deleteById(int id);
}

@org.springframework.stereotype.Repository
class ProjectRepositoryImpl implements ProjectRepository {
    private final SqlProjectRepository repository;

    ProjectRepositoryImpl(final SqlProjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public Project save(final Project project) {
        return repository.save(SqlProject.fromProject(project)).toProject();
    }

    @Override
    public void delete(final Project project) {
        repository.deleteById(project.getId());
    }
}

interface SqlProjectQueryRepository extends ProjectQueryRepository, Repository<SqlProject, Integer> {
}
