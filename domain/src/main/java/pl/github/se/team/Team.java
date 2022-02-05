package pl.github.se.team;

import pl.github.se.task.TaskStatus;
import pl.github.se.user.User;

import java.util.List;

public class Team {
    private int id;
    private String name;
    private String description;
    private List<User> members;
    private User master;

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public List<User> getMembers() {return members;}

    public void setMembers(List<User> members) {this.members = members;}

    public User getMaster() {return master;}

    public void setMaster(User master) {this.master = master;}
}
