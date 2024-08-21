INSERT INTO users (id, username, password, email, role) VALUES
('a5f9c2f0-8c4d-11ec-b909-0242ac120004', 'user1', 'password1', 'user1@example.com', 'ROLE_USER'),
('a5f9c2f0-8c4d-11ec-b909-0242ac120001', 'Nikita', 'collBoyToy', 'Matvei@example.com', 'ROLE_USER'),
('a5f9c2f0-8c4d-11ec-b909-0242ac120005', 'admin1', 'password2', 'admin1@example.com', 'ROLE_ADMIN');

INSERT INTO tasks (id, title, description, status, due_date, priority, owner_id) VALUES
('a5f9c2f0-8c4d-11ec-b909-0242ac120006', 'Task 1', 'Description for Task 1', 'TODO', '2024-08-10T10:00:00', 'HIGH', 'a5f9c2f0-8c4d-11ec-b909-0242ac120004'),
('a5f9c2f0-8c4d-11ec-b909-0242ac120007', 'Task 2', 'Description for Task 2', 'IN_PROGRESS', '2024-08-11T14:00:00', 'MEDIUM', 'a5f9c2f0-8c4d-11ec-b909-0242ac120004');