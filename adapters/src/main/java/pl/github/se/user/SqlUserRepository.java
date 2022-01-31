package pl.github.se.user;


import org.springframework.data.repository.Repository;

interface SqlUserRepository extends Repository<SqlUser, Integer> {
    SqlUser save(SqlUser project);

    void deleteById(int id);
}

@org.springframework.stereotype.Repository
class UserRepositoryImpl implements UserRepository {
    private final SqlUserRepository repository;

    UserRepositoryImpl(final SqlUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User save(final User user) {
        return repository.save(SqlUser.fromUser(user)).toUser();
    }

    @Override
    public void delete(final User User) {
        repository.deleteById(User.getId());
    }
}

interface SqlUserQueryRepository extends UserQueryRepository, Repository<SqlUser, Integer> {
}
