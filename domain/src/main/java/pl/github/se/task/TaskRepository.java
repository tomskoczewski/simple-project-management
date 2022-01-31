package pl.github.se.task;

interface TaskRepository {
    Task save(Task task);

    void delete(Task task);
}
