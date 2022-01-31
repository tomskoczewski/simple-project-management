package pl.github.se.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class UserConfiguration {
    @Bean
    UserFacade userFacade(
            UserRepository repository
    ) {
        return new UserFacade(
                repository,
                new UserFactory()
        );
    }
}
