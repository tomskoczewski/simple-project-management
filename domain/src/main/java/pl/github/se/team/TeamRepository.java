package pl.github.se.team;

interface TeamRepository {
    Team save(Team team);

    void delete(Team team);
}
