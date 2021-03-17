CREATE TABLE productor(
                          id BIGINT PRIMARY KEY NOT NULL,
                          name VARCHAR(50) NOT NULL,
                          address VARCHAR(50) NOT NULL,
                          film_id BIGINT NOT NULL
);
CREATE TABLE film(
       id BIGINT PRIMARY KEY NOT NULL,
       title VARCHAR(50) NOT NULL,
       duration SMALLINT NOT NULL,
       soundtrack VARCHAR(250) NOT NULL,
       film_genre VARCHAR(50) NOT NULL,
       director_id BIGINT NOT NULL,
       productor_id BIGINT NOT NULL

);


CREATE TABLE director(
       id BIGINT PRIMARY KEY NOT NULL,
       name VARCHAR(50) NOT NULL,
       luogo_nasc VARCHAR(50) NOT NULL,
       data_nasc VARCHAR(50) NOT NULL,
       film_id BIGINT NOT NULL
);

CREATE TABLE director_film
AS
    SELECT director.film_id, film.director_id
    FROM director
    INNER JOIN film
    ON director.film_id = film.director_id
;

CREATE TABLE productor_film
AS
SELECT productor.film_id, film.productor_id
FROM productor
         INNER JOIN film
                    ON productor.film_id = film.productor_id
;

CREATE TABLE film_action(
    id BIGINT PRIMARY KEY NOT NULL,
    cod_action VARCHAR(1),
    descrizione TEXT,
    CONSTRAINT fk_films_action_film foreign key (id) references film(id)
);

INSERT INTO director VALUES (1, 'Russo brothers', '1970-1-30', 'USA', 3);
INSERT INTO director VALUES (4, 'Sam Mendes','1965-5-30', 'Argentina', 5);
INSERT INTO film VALUES (3, 'Captain America: Civil War', 147, 'Henry Jackman', 'Action', 1, 2);
INSERT INTO film VALUES (5, '007: Skyfall', 143, 'Thomas Newman', 'Action', 4, 6);
INSERT INTO productor VALUES (2, 'Sony', 'USA', 3);
INSERT INTO productor VALUES (6, 'Eon', 'UK', 5);
INSERT INTO film_action VALUES (3, 'A', 'azionee');
INSERT INTO film_action VALUES (5, 'V', 'azioneee');

SELECT * from film_action;