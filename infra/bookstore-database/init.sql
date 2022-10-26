CREATE TYPE usertype AS ENUM ('admin', 'author');

CREATE TABLE users (
    id character varying(255) NOT NULL PRIMARY KEY,
    email character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    birth_date date,
    password character varying(255) NOT NULL,
    role usertype
);

CREATE TABLE books (
    id character varying(255) NOT NULL PRIMARY KEY,
    title character varying(255) NOT NULL,
    description character varying(255) NOT NULL,
    price numeric NOT NULL,
    publish_date date NOT NULL,
    author_id character varying(255) NOT NULL,
    CONSTRAINT fk_authors
        FOREIGN KEY(author_id)
            REFERENCES users(id)
);

INSERT INTO users (id, name, password, role, email, birth_date) VALUES
('0e245b44-efc6-478e-9495-452e64406cbf', 'admin', '$2a$12$WCq8Mi9v1dymGl0ATdv8F.2QUbreZIa2M1ez29au2zfdB1ChpindK', 'admin', 'admin@davittests.com', '1993-06-23'),
('d4119f51-969f-4e61-a12f-04eed8bf6bc5', 'author', '$2a$12$WCq8Mi9v1dymGl0ATdv8F.2QUbreZIa2M1ez29au2zfdB1ChpindK', 'author', 'author@davittests.com', '1995-05-05');

INSERT INTO books (id, author_id, title, description, price, publish_date) VALUES
('39acbbf9-6ed3-477d-aefc-e6266d6e963f', 'd4119f51-969f-4e61-a12f-04eed8bf6bc5', 'Title 1', 'Description 1', 10.5, '2022-10-26'),
('9d41cf62-c5a8-4888-9982-229d8abfdb71', 'd4119f51-969f-4e61-a12f-04eed8bf6bc5', 'Title 2', 'Description 2', 10, '2022-10-26'),
('5e55e97e-bae0-4c09-ad0b-d3a1fc40f579', '0e245b44-efc6-478e-9495-452e64406cbf', 'Title 3', 'Description 3', 11.5, '2022-10-26'),
('2b955f46-f325-4fb6-9fb0-91a08d938338', 'd4119f51-969f-4e61-a12f-04eed8bf6bc5', 'Title 4', 'Description 4', 12, '2022-10-26');