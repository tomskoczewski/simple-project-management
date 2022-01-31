package pl.github.se.task;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class TaskConfiguration {
    @Bean
    TaskFacade taskFacade(
            TaskRepository taskRepository
    ) {
        return new TaskFacade(
                taskRepository,
                new TaskFactory()
        );
    }
}
