DROP TABLE IF EXISTS note;
 
CREATE TABLE note (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  info VARCHAR(250) NOT NULL,
  is_archived BIT NOT NULL
);

INSERT INTO note(name, info, is_archived) VALUES ('Welcome Text', 'Hello there stranger', FALSE);
INSERT INTO note(name, info, is_archived) VALUES ('Goodbye Text', 'Farewell young one', FALSE);
INSERT INTO note(name, info, is_archived) VALUES ('Small Rhyme', 'Tick tock goes the clock', FALSE);
INSERT INTO note(name, info, is_archived) VALUES ('Football Team', 'Westham!', FALSE);

INSERT INTO note(name, info, is_archived) VALUES ('Favourite Anime', 'Code Geass', TRUE);
INSERT INTO note(name, info, is_archived) VALUES ('Favourite Musician', 'Eden', TRUE);

COMMIT;