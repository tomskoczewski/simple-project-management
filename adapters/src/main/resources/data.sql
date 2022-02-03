INSERT INTO SE_PROJECTS (name, description, days_to_deadline) VALUES
                                                      ('USE CASES', 'Use Cases for software Enginering ', 3),
                                                      ('USE CASES UML', 'Use Cases UML for software Enginering ', 3),
                                                      ('CLASS DIAGRAM UML', 'CLASS DIAGRAM UML for software Enginering', 5);

INSERT INTO SE_USERS (user, password, mail, description, user_type) VALUES
                                                                  ('admin', 'admin', 'admin@admin.pl', 'Master of disaster', 'ADMIN'),
                                                                  ('user', 'user', 'user@user.pl', 'Simple user', 'TEAM_MEMBER'),
                                                                  ('supervisor', 'supervisor', 'supervisor@supervisor.pl', 'Supervisor', 'SUPERVISOR');

INSERT INTO SE_TASKS (description, estimation, name, status, user_id, project_id) VALUES
                                                                        ('Task 1', 8, 'Task', 'OPEN', SELECT TOP(1) ID FROM SE_USERS WHERE USER = 'user', SELECT TOP(1) ID FROM SE_PROJECTS WHERE NAME= 'USE CASES')