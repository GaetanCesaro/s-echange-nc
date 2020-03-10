DROP TABLE IF EXISTS user;
CREATE TABLE user (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  email VARCHAR(250) NOT NULL,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
);

DROP TABLE IF EXISTS ad;
CREATE TABLE ad (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  title VARCHAR(250) NOT NULL,
  description VARCHAR(250) NOT NULL,
  price INT NOT NULL,
  image_url VARCHAR,
  category VARCHAR NOT NULL,
  owner_id INT NOT NULL,
);

INSERT INTO user (email, first_name, last_name) VALUES
  ('mario.bros@hotmail.com', 'Mario', 'Bros'),
  ('jean-louis.aubert@gmail.com', 'Jean-Louis', 'Aubert'),
  ('john.rambo@yahoo.com', 'John', 'Rambo')
;

INSERT INTO ad (title, description, price, image_url, category, owner_id) VALUES
  ('Bricolage mobilier intérieur', 'Tous bricolages intérieurs, montage de rideaux, fixations murales, petites réparation de meubles, etc...', 1000, 'bricolage.jpg', 'bricolage', 1),
  ('Plomberie', 'Plomberie intérieure (réparations, installations, etc...)', 2000, 'plombier.jpg', 'plomberie', 1),
  ('Electricité générale', 'Opérations d''élécticité d''usage général intérieur et extèrieur', 1500, 'electricien.jpg', 'electricite', 3),
  ('Guitare acoustique Yamaha', 'Bon état, vendue car nouvelle guitare offerte par ma compagne', 15000, '', 'musique', 2),
  ('Ventilateur de ouf', 'Il fait chaud, un bon ventilateur c''est éssentiel !', 5900, '', 'electromenager', 2),
  ('Nettoyage', 'Nettoyage tout type, au karcher ou au lance flames', 10000, 'scie_circulaire.jpg', 'nettoyage', 3),
  ('Outillage', 'Tous types d''outils portatifs (tournevis, clés, visseuses, etc...)', 500, 'outils.jpg', 'outils', 3),
  ('Installation d''éviers', 'Eviers, mitigeurs, douches, etc...', 2500, 'evier.jpg', 'plomberie', 1)
;