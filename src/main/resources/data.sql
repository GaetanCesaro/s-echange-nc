DROP TABLE IF EXISTS user;
CREATE TABLE user (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  email VARCHAR(250) NOT NULL,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
);

DROP TABLE IF EXISTS post;
CREATE TABLE post (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  title VARCHAR(250) NOT NULL,
  description VARCHAR(250) NOT NULL,
  price INT NOT NULL,
  owner_id INT NOT NULL,
);

INSERT INTO user (email, first_name, last_name) VALUES
  ('bill.gates@hotmail.com', 'Bill', 'Gates'),
  ('dangite.aliko@gmail.com', 'Aliko', 'Dangote'),
  ('folrunsho.alokija@yahoo.com', 'Folrunsho', 'Alakija');

INSERT INTO post (title, description, price, owner_id) VALUES
  ('Lit bébé', 'Peu servi, acheté chez bébé neuf', 20000, 1),
  ('Guitare acoustique Yamaha', 'Bon état, vendue car nouvelle guitare offerte par ma compagne', 15000, 1),
  ('Ventilateur de ouf', 'Il fait chaud, un bon ventilateur c''est éssentiel !', 5900, 2);