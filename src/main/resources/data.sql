DROP TABLE IF EXISTS user;
CREATE TABLE user (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  email VARCHAR(250) NOT NULL,
  firstname VARCHAR(250) NOT NULL,
  lastname VARCHAR(250) NOT NULL,
);

DROP TABLE IF EXISTS post;
CREATE TABLE post (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  title VARCHAR(250) NOT NULL,
  description VARCHAR(250) NOT NULL,
  price INT NOT NULL,
  owner INT NOT NULL,
);

INSERT INTO user (email, firstname, lastname) VALUES
  ('dangite.aliko@gmail.com', 'Aliko', 'Dangote'),
  ('bill.gates@hotmail.com', 'Bill', 'Gates'),
  ('folrunsho.alokija@yahoo.com', 'Folrunsho', 'Alakija');

INSERT INTO post (title, description, price, owner) VALUES
  ('Lit bébé', 'Peu servi, acheté chez bébé neuf', 20000, 1),
  ('Guitare acoustique Yamaha', 'Bon état, vendue car nouvelle guitare offerte par ma compagne', 15000, 1),
  ('Ventilateur de ouf', 'Il fait chaud, un bon ventilateur c''est éssentiel !', 5900, 2);