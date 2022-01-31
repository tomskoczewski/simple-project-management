package pl.github.se.task;


import org.springframework.data.repository.Repository;

interface SqlTaskRepository extends Repository<SqlTask, Integer> {
    SqlTask save(SqlTask task);

    void deleteById(int id);
}

@org.springframework.stereotype.Repository
class TaskRepositoryImpl implements TaskRepository {
    private final SqlTaskRepository repository;

    TaskRepositoryImpl(final SqlTaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public Task save(final Task task) {
        return repository.save(SqlTask.fromTask(task)).toTask();
    }

    @Override
    public void delete(final Task task) {
        repository.deleteById(task.getId());
    }
}

interface SqlTaskQueryRepository extends TaskQueryRepository, Repository<SqlTask, Integer> {
}
