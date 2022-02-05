package pl.github.se.team;

import pl.github.se.user.SqlUser;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "SE_TEAMS")
public class SqlTeam {

    public static SqlTeam fromTeam(Team source) {
        var result = new SqlTeam();

        result.id = source.getId();
        result.name = source.getName();
        result.description = source.getDescription();
        result.members = source.getMembers().stream().map(SqlUser::fromUser).collect(Collectors.toList());
        result.master = SqlUser.fromUser(source.getMaster());

        return result;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    private String name;
    private String description;
    @ManyToMany
    @JoinTable(
            name = "SE_TEAM_MEMBER",
            joinColumns = { @JoinColumn(name = "team_id") },
            inverseJoinColumns = { @JoinColumn(name = "member_id") }
    )
    private List<SqlUser> members;
    @ManyToOne
    @JoinColumn(name = "master_id")
    private SqlUser master;

    public SqlTeam() {
    }

    public Team toTeam() {
        var result = new Team();

        result.setId(id);
        result.setName(name);
        result.setDescription(description);
        result.setMembers(members.stream().map(SqlUser::toUser).collect(Collectors.toList()));
        result.setMaster(master.toUser());

        return result;
    }

}
