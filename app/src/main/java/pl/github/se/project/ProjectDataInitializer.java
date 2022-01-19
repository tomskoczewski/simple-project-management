package pl.github.se.project;

class ProjectDataInitializer {
    private final ProjectRepository projectRepository;
    private final ProjectQueryRepository projectQueryRepository;

    ProjectDataInitializer(final ProjectRepository projectRepository, final ProjectQueryRepository projectQueryRepository) {
        this.projectRepository = projectRepository;
        this.projectQueryRepository = projectQueryRepository;
    }

    void init() {
        if (projectQueryRepository.count() == 0) {
            Project project = new Project();
            project.setName("First project");
            project.setDescription("Test description");
            project.setDaysToDeadline(3);
            projectRepository.save(project);
        }
    }
}
