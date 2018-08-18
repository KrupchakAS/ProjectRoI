SET FOREIGN_KEY_CHECKS=0;
-- Table Books;
CREATE TABLE books (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  bookName VARCHAR(255) NOT NULL,
  bookDescription VARCHAR(255) NOT NULL,
  pageCount INT NOT NULL,
  UNIQUE (bookName,bookDescription)
) ENGINE = InnoDB ;
-- Table Genres;
CREATE TABLE genres(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  genreName VARCHAR(255) NOT NULL
) ENGINE = InnoDB;
-- Table mapping
CREATE TABLE books_genres (
  book_id INT NOT NULL,
  genre_id INT NOT NULL,
  FOREIGN KEY (book_id) REFERENCES books (id),
  FOREIGN KEY (genre_id) REFERENCES genres (id),
  UNIQUE (book_id,genre_id)
)ENGINE =InnoDB;

INSERT INTO books VALUES (1,'Звездный десант','Звездный десант - описание',400);
INSERT INTO genres VALUES (1,'Фантастика');
INSERT INTO books VALUES (2,'Приключения Тома Сойера','Приключения Тома Сойера - описание',330);
INSERT INTO genres VALUES (2,'Приключения');
INSERT INTO books VALUES (3,'Цирк проклятых','Цирк проклятых - описание',470);
INSERT INTO genres VALUES (3,'Ужасы');
INSERT INTO books VALUES (4,'Одиссея','Одиссея - описание',450);
INSERT INTO genres VALUES (4,'Приключения');
INSERT INTO books VALUES (5,'Война миров','Война миров - описание',610);
INSERT INTO genres VALUES (5,'Фантастика');
INSERT INTO books VALUES (6,'20000 лье под водой','20000 лье под водой - описание',560);
INSERT INTO genres VALUES (6,'Фантастика');
INSERT INTO genres VALUES (7,'Приключения');
INSERT INTO books VALUES (7,'Франкенштейн','Франкенштейн - описание',580);
INSERT INTO genres VALUES (8,'Фантастика');
INSERT INTO genres VALUES (9,'Ужасы');
INSERT INTO books VALUES (8,'Путешествия Гулливера','Путешествия Гулливера - описание',420);
INSERT INTO genres VALUES (10,'Фантастика');
INSERT INTO genres VALUES (11,'Приключения');
INSERT INTO books VALUES (9,'Алиса в стране чудес','Алиса в стране чудес - описание',480);
INSERT INTO genres VALUES (12,'Приключения');
INSERT INTO books VALUES (10,'Зов крови','Зов крови - описание',710);
INSERT INTO genres VALUES (13,'Фантастика');
INSERT INTO genres VALUES (14,'Ужасы');
INSERT INTO books VALUES (11,'Дракула','Дракула - описание',640);
INSERT INTO genres VALUES (15,'Фантастика');
INSERT INTO genres VALUES (16,'Ужасы');
INSERT INTO books VALUES (12,'458 градусов по Фарингейту','458 градусов по Фарингейту - описание',460);
INSERT INTO genres VALUES (17,'Фантастика');
INSERT INTO genres VALUES (18,'Приключения');

INSERT INTO books_genres VALUES (1, 1);
INSERT INTO books_genres VALUES (2, 2);
INSERT INTO books_genres VALUES (3, 3);
INSERT INTO books_genres VALUES (4, 4);
INSERT INTO books_genres VALUES (5, 5);
INSERT INTO books_genres VALUES (6, 6);
INSERT INTO books_genres VALUES (6, 7);
INSERT INTO books_genres VALUES (7, 8);
INSERT INTO books_genres VALUES (7, 9);
INSERT INTO books_genres VALUES (8, 10);
INSERT INTO books_genres VALUES (8, 11);
INSERT INTO books_genres VALUES (9, 12);
INSERT INTO books_genres VALUES (10, 13);
INSERT INTO books_genres VALUES (10, 14);
INSERT INTO books_genres VALUES (11, 15);
INSERT INTO books_genres VALUES (11, 16);
INSERT INTO books_genres VALUES (12, 17);
INSERT INTO books_genres VALUES (12, 18);