package pl.github.se.project;

import pl.github.se.task.SqlTask;
import pl.github.se.task.Task;
import pl.github.se.team.SqlTeam;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "SE_PROJECTS")
public class SqlProject {

    static SqlProject fromProject(Project source) {
        var result = new SqlProject();

        result.id = source.getId();
        result.name = source.getName();
        result.description = source.getDescription();
        result.daysToDeadline = source.getDaysToDeadline();
        result.tasks = source.getTasks().stream().map(SqlTask::fromTask).collect(Collectors.toList());
        result.team = SqlTeam.fromTeam(source.getTeam());

        return result;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    private String name;

    private String description;

    private int daysToDeadline;

    @OneToMany(mappedBy = "project")
    private List<SqlTask> tasks = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "team_id")
    private SqlTeam team;

    public SqlProject() {
    }

    Project toProject() {
        var result = new Project();

        result.setId(id);
        result.setName(name);
        result.setDescription(description);
        result.setDaysToDeadline(daysToDeadline);
        result.setTasks(tasks.stream().map(SqlTask::toTask).collect(Collectors.toList()));
        result.setTeam(team.toTeam());

        return result;
    }

}
