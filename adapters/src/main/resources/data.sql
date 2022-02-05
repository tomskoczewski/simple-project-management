INSERT INTO SE_USERS (username, password, mail, description, user_type) VALUES
                                                                            ('admin', 'admin', 'admin@admin.pl', 'Master of disaster', 'ADMIN'),
                                                                            ('user', 'user', 'user@user.pl', 'Simple user', 'TEAM_MEMBER'),
                                                                            ('user2', 'user2', 'user2@user.pl', 'Simple user', 'TEAM_MEMBER'),
                                                                            ('master', 'master', 'master@user.pl', 'Team Master user', 'TEAM_MEMBER'),
                                                                            ('supervisor', 'supervisor', 'supervisor@supervisor.pl', 'Supervisor', 'SUPERVISOR');

INSERT INTO SE_TEAMS (name, description, master_id) VALUES
                                                                  ('ALPHA', 'Alpha team Rlz', SELECT TOP(1) ID FROM SE_USERS WHERE USERNAME = 'master'),
                                                                  ('BETA', 'Beta team sucks', SELECT TOP(1) ID FROM SE_USERS WHERE USERNAME = 'master');

INSERT INTO SE_TEAM_MEMBER (team_id, member_id) VALUES
                                                        (SELECT TOP(1) ID FROM SE_TEAMS WHERE NAME = 'ALPHA', SELECT TOP(1) ID FROM SE_USERS WHERE USERNAME = 'user'),
                                                        (SELECT TOP(1) ID FROM SE_TEAMS WHERE NAME = 'BETA', SELECT TOP(1) ID FROM SE_USERS WHERE USERNAME = 'user2');

INSERT INTO SE_PROJECTS (name, description, days_to_deadline, team_id) VALUES
                                                      ('USE CASES', 'Use Cases for software Enginering ', 3, SELECT TOP(1) ID FROM SE_TEAMS WHERE NAME = 'ALPHA'),
                                                      ('USE CASES UML', 'Use Cases UML for software Enginering ', 3, SELECT TOP(1) ID FROM SE_TEAMS WHERE NAME = 'ALPHA'),
                                                      ('CLASS DIAGRAM UML', 'CLASS DIAGRAM UML for software Enginering', 5, SELECT TOP(1) ID FROM SE_TEAMS WHERE NAME = 'BETA');

INSERT INTO SE_TASKS (description, estimation, name, status, user_id, project_id) VALUES
                                                                        ('Task 1', 8, 'Task', 'OPEN', SELECT TOP(1) ID FROM SE_USERS WHERE USERNAME = 'user', SELECT TOP(1) ID FROM SE_PROJECTS WHERE NAME= 'USE CASES')