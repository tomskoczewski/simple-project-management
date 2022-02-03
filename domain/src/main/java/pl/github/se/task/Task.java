package pl.github.se.task;

import pl.github.se.user.User;

public class Task {
    private int id;
    private User assignee;
    private String name;
    private String description;
    private int estimation;
    private TaskStatus status;

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public User getAssignee() {return assignee;}

    public void setAssignee(User assignee) {this.assignee = assignee;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public int getEstimation() {return estimation;}

    public void setEstimation(int estimation) {this.estimation = estimation;}

    public TaskStatus getStatus() {return status;}

    public void setStatus(TaskStatus status) {this.status = status;}
}
