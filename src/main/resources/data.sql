DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  email VARCHAR(250) NOT NULL,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
);

INSERT INTO users (email, first_name, last_name) VALUES
  ('dangite.aliko@gmail.com', 'Aliko', 'Dangote'),
  ('bill.gates@hotmail.com', 'Bill', 'Gates'),
  ('folrunsho.alokija@yahoo.com', 'Folrunsho', 'Alakija');