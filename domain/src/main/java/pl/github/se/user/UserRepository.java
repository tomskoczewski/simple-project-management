package pl.github.se.user;


interface UserRepository {
    User save(User project);

    void delete(User project);
}
