# --- !Ups

CREATE TABLE IF NOT EXISTS book (
  id BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(200) NOT NULL,
  author_id BIGINT(20) NOT NULL
);

INSERT INTO book VALUES (1, "Programming in Scala", 1);
INSERT INTO book VALUES (2, "Programming in Java", 1);
INSERT INTO book VALUES (3, "Programming in PHP", 1);

# --- !Downs

DROP TABLE book;
