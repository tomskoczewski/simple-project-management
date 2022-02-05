package pl.github.se.team;


import org.springframework.data.repository.Repository;
import pl.github.se.team.SqlTeam;
import pl.github.se.team.Team;
import pl.github.se.team.TeamQueryRepository;
import pl.github.se.team.TeamRepository;

interface SqlTeamRepository extends Repository<SqlTeam, Integer> {
    SqlTeam save(SqlTeam team);

    void deleteById(int id);
}

@org.springframework.stereotype.Repository
class TeamRepositoryImpl implements TeamRepository {
    private final SqlTeamRepository repository;

    TeamRepositoryImpl(final SqlTeamRepository repository) {
        this.repository = repository;
    }

    @Override
    public Team save(final Team team) {
        return repository.save(SqlTeam.fromTeam(team)).toTeam();
    }

    @Override
    public void delete(final Team team) {
        repository.deleteById(team.getId());
    }
}

interface SqlTeamQueryRepository extends TeamQueryRepository, Repository<SqlTeam, Integer> {
}
