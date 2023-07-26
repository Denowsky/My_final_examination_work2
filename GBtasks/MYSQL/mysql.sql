CREATE DATABASE FriendsOfHuman;

USE FriendsOfHuman;
CREATE TABLE animal_classes
(
	Id INT AUTO_INCREMENT PRIMARY KEY, 
	Class_name VARCHAR(20)
);

INSERT INTO animal_classes (Class_name)
VALUES ('вьючные'),
('домашние');  


CREATE TABLE viuch_animals
(
	  Id INT AUTO_INCREMENT PRIMARY KEY,
    kind_name VARCHAR (20),
    Class_id INT,
    FOREIGN KEY (Class_id) REFERENCES animal_classes (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO viuch_animals (kind_name, Class_id)
VALUES ('Лошади', 1),
('Ослы', 1),  
('Верблюды', 1); 
    
CREATE TABLE home_animals
(
	  Id INT AUTO_INCREMENT PRIMARY KEY,
    kind_name VARCHAR (20),
    Class_id INT,
    FOREIGN KEY (Class_id) REFERENCES animal_classes (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO home_animals (kind_name, Class_id)
VALUES ('Кошки', 2),
('Собаки', 2),  
('Хомяки', 2); 

CREATE TABLE cats 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Kind_id int,
    Foreign KEY (Kind_id) REFERENCES home_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO cats (Name, Birthday, Commands, Kind_id)
VALUES ('Felix', '2011-01-01', 'ps-ps-ps', 1);

CREATE TABLE dogs 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Kind_id int,
    Foreign KEY (Kind_id) REFERENCES home_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO dogs (Name, Birthday, Commands, Kind_id)
VALUES ('GoodBoy', '2020-01-01', 'Come here', 2);

CREATE TABLE homyaki 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Kind_id int,
    Foreign KEY (Kind_id) REFERENCES home_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO homyaki (Name, Birthday, Commands, Kind_id)
VALUES ('Elvin', '2020-10-12', 'sing the song', 3);

CREATE TABLE horses 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Kind_id int,
    Foreign KEY (Kind_id) REFERENCES viuch_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO horses (Name, Birthday, Commands, Kind_id)
VALUES ('Lighty', '2020-01-12', 'Brrrr', 1);

CREATE TABLE donkeys 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Kind_id int,
    Foreign KEY (Kind_id) REFERENCES viuch_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO donkeys (Name, Birthday, Commands, Kind_id)
VALUES ('Ian', '2019-04-10', "Stop", 2);

CREATE TABLE verbluds 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Kind_id int,
    Foreign KEY (Kind_id) REFERENCES viuch_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO verbluds (Name, Birthday, Commands, Kind_id)
VALUES ('Spliter', '2022-04-10', 'Salam', 3);

SET SQL_SAFE_UPDATES = 0;
DELETE FROM verbluds;

SELECT Name, Birthday, Commands FROM horses
UNION SELECT  Name, Birthday, Commands FROM donkeys;

CREATE TEMPORARY TABLE animals AS 
SELECT *, 'Лошади' as kind FROM horses
UNION SELECT *, 'Ослы' AS kind FROM donkeys
UNION SELECT *, 'Собаки' AS kind FROM dogs
UNION SELECT *, 'Кошки' AS kind FROM cats
UNION SELECT *, 'Хомяки' AS kind FROM homyaki;

CREATE TABLE young_animals AS
SELECT Name, Birthday, Commands, kind, TIMESTAMPDIFF(MONTH, Birthday, CURDATE()) AS Age_in_month
FROM animals WHERE Birthday BETWEEN ADDDATE(curdate(), INTERVAL -3 YEAR) AND ADDDATE(CURDATE(), INTERVAL -1 YEAR);
 
SELECT * FROM young_animals;

SELECT h.Name, h.Birthday, h.Commands, pa.kind_name, ya.Age_in_month 
FROM horses h
LEFT JOIN young_animals ya ON ya.Name = h.Name
LEFT JOIN viuch_animals pa ON pa.Id = h.Kind_id
UNION 
SELECT d.Name, d.Birthday, d.Commands, pa.kind_name, ya.Age_in_month 
FROM donkeys d 
LEFT JOIN young_animals ya ON ya.Name = d.Name
LEFT JOIN viuch_animals pa ON pa.Id = d.Kind_id
UNION
SELECT c.Name, c.Birthday, c.Commands, ha.kind_name, ya.Age_in_month 
FROM cats c
LEFT JOIN young_animals ya ON ya.Name = c.Name
LEFT JOIN home_animals ha ON ha.Id = c.Kind_id
UNION
SELECT d.Name, d.Birthday, d.Commands, ha.kind_name, ya.Age_in_month 
FROM dogs d
LEFT JOIN young_animals ya ON ya.Name = d.Name
LEFT JOIN home_animals ha ON ha.Id = d.Kind_id
UNION
SELECT hm.Name, hm.Birthday, hm.Commands, ha.kind_name, ya.Age_in_month 
FROM homyaki hm
LEFT JOIN young_animals ya ON ya.Name = hm.Name
LEFT JOIN home_animals ha ON ha.Id = hm.Kind_id;