package pl.github.se.project.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = ProjectDto.DeserializationImpl.class)
public interface ProjectDto {
    static ProjectDto create(final int id, final String name, final String description, final int daysToDeadline) {
        return new DeserializationImpl(id, name, description, daysToDeadline);
    }

    int getId();

    String getName();

    String getDescription();

    int getDaysToDeadline();


    class DeserializationImpl implements ProjectDto {
        private final int id;
        private final String name;
        private final String description;
        private final int daysToDeadline;

        public DeserializationImpl(final int id, final String name, final String description, final int daysToDeadline) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.daysToDeadline = daysToDeadline;
        }


        @Override
        public int getId() {
            return id;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getDescription() {
            return description;
        }

        @Override
        public int getDaysToDeadline() {
            return daysToDeadline;
        }
    }
}
