package pl.github.se.project;

class Project {
    static Project create(final int id, final String name, final String description, final int daysToDeadline) {
        return new Project(id, name, description, daysToDeadline);
    }

    Project(final int id, final String name, final String description, final int daysToDeadline) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.daysToDeadline = daysToDeadline;
    }

    Project() {
    }

    private int id;
    private String name;
    private String description;
    private int daysToDeadline;

    public int getId() {
        return id;
    }

    void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    void setDescription(final String description) {
        this.description = description;
    }

    public int getDaysToDeadline() {
        return daysToDeadline;
    }

    void setDaysToDeadline(final int daysToDeadline) {
        this.daysToDeadline = daysToDeadline;
    }

}
