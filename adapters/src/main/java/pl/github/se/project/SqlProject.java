package pl.github.se.project;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "SE_PROJECTS")
class SqlProject {

    static SqlProject fromProject(Project source) {
        var result = new SqlProject();

        result.id = source.getId();
        result.name = source.getName();
        result.description = source.getDescription();
        result.daysToDeadline = source.getDaysToDeadline();

        return result;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    private String name;

    private String description;

    private int daysToDeadline;

    public SqlProject() {
    }

    Project toProject() {
        var result = new Project();

        result.setId(id);
        result.setName(name);
        result.setDescription(description);
        result.setDaysToDeadline(daysToDeadline);


        return result;
    }

}
