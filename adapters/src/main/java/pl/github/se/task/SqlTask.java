package pl.github.se.task;

import pl.github.se.project.SqlProject;
import pl.github.se.user.SqlUser;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "SE_TASKS")
public class SqlTask {

    public static SqlTask fromTask(Task source) {
        var result = new SqlTask();

        result.id = source.getId();
        result.assignee = SqlUser.fromUser(source.getAssignee());
        result.name = source.getName();
        result.description = source.getDescription();
        result.estimation = source.getEstimation();
        result.status = source.getStatus();
        
        return result;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private SqlUser assignee;
    private String name;
    private String description;
    private int estimation;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private SqlProject project;

    public SqlTask() {
    }

    public Task toTask() {
        var result = new Task();

        result.setId(id);
        result.setAssignee(assignee.toUser());
        result.setName(name);
        result.setDescription(description);
        result.setEstimation(estimation);
        result.setStatus(status);

        return result;
    }

}
