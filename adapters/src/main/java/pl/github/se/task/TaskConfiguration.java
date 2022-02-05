package pl.github.se.task;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.github.se.user.UserFacade;
import pl.github.se.user.UserFacadeImpl;

@Configuration
class TaskConfiguration {
    @Bean
    TaskFacade taskFacade(
            TaskRepository taskRepository, UserFacade userFacade
    ) {
        return new TaskFacadeImpl(
                taskRepository,
                new TaskFactory(),
                userFacade);
    }
}
