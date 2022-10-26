CREATE TYPE usertype AS ENUM ('admin', 'author');

CREATE TABLE users (
    id character varying(255) NOT NULL PRIMARY KEY,
    username character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    role usertype
);

CREATE TABLE books (
    id character varying(255) NOT NULL PRIMARY KEY,
    title character varying(255) NOT NULL,
    description character varying(255) NOT NULL,
    author_id character varying(255) NOT NULL,
    CONSTRAINT fk_authors
        FOREIGN KEY(author_id)
            REFERENCES users(id)
);

INSERT INTO users (id, username, password, role) VALUES
('0e245b44-efc6-478e-9495-452e64406cbf', 'admin', '{bcrypt}$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW', 'admin'),
('d4119f51-969f-4e61-a12f-04eed8bf6bc5', 'author', '{bcrypt}$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW', 'author');

INSERT INTO books (id, author_id, title, description) VALUES
('39acbbf9-6ed3-477d-aefc-e6266d6e963f', 'd4119f51-969f-4e61-a12f-04eed8bf6bc5', 'Title 1', 'Description 1'),
('9d41cf62-c5a8-4888-9982-229d8abfdb71', 'd4119f51-969f-4e61-a12f-04eed8bf6bc5', 'Title 2', 'Description 2');