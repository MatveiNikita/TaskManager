CREATE TABLE users (
    id UUID PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL
);

CREATE TABLE tasks (
    id UUID PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    status VARCHAR(50) NOT NULL,
    due_date TIMESTAMP,
    priority VARCHAR(50) NOT NULL,
    owner_id UUID,
    CONSTRAINT fk_owner FOREIGN KEY(owner_id) REFERENCES users(id)
);
