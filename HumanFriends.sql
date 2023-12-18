DROP DATABASE IF EXISTS HumanFriends;
CREATE DATABASE HumanFriends;
USE HumanFriends;

-- Животные
DROP TABLE IF EXISTS animals;
CREATE TABLE animals (
	id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50),
    date_birt DATE,
    FOREIGN KEY (animals_type_id) REFERENCES animals_type(id)
);

-- Команды
DROP TABLE IF EXISTS commands;
CREATE TABLE commands (
	id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50),
    descr TEXT
);

-- Связь животных и команд, которые они выполняют
DROP TABLE IF EXISTS animals_commands;
CREATE TABLE animals_commands (
	id INT PRIMARY KEY AUTO_INCREMENT,
    FOREIGN KEY (animals_id) REFERENCES animals(id),
    FOREIGN KEY (commands_id) REFERENCES commands(id)
);

-- Группы животных (домашние и вьючные)
DROP TABLE IF EXISTS animals_group;
CREATE TABLE animals_group (
	id INT PRIMARY KEY AUTO_INCREMENT,
    _name VARCHAR(50),
);

-- Типы животных (коты, лошади и т.д.)
DROP TABLE IF EXISTS animals_type;
CREATE TABLE animals_type (
	id INT PRIMARY KEY AUTO_INCREMENT,
    _name VARCHAR(50),
    FOREIGN KEY (animals_group_id) REFERENCES animals_group(id)
);

INSERT INTO animals_group (id, _name) VALUES
(1, 'Pets'),
(2, 'Pack_animals');

INSERT INTO animals_type (id, animals_group_id, _name) VALUES
(1, 1, 'Cat'),
(2, 1, 'Dog'),
(3, 1, 'Hamster'),
(4, 2, 'Horse'),
(5, 2, 'Donkey'),
(6, 2, 'Camel');

INSERT INTO animals (id, animals_type_id, first_name, date_birt) VALUES 
(1, 1, 'Barsik', '1976-11-08'),
(2, 1, 'Loki', '1975-12-08'),
(3, 2, 'Bobik', '1976-10-08'),
(4, 3, 'Reuben', '1974-09-08'),
(5, 4, 'Lewis', '1971-08-08'),
(6, 5, 'Sam', '1972-07-08'),
(7, 6, 'Karl', '1976-06-08'),
(8, 3, 'Bob', '1978-05-08'),
(9, 6, 'Pol', '1974-04-08'),
(10, 4, 'Riki', '1975-03-08');

INSERT INTO commands (id, _name, descr) VALUES
(1, 'Voice', 'voice'),
(2, 'Give_paw', 'give me your paw'),
(3, 'Sit', 'sit'),
(4, 'Walk', 'walk straight');

INSERT INTO animals_commands (id, animals_id, commands_id) VALUES
(1, 1, 2),
(2, 3, 1),
(3, 3, 2),
(4, 3, 3),
(5, 5, 4),
(6, 6, 4),
(7, 7, 4),
(8, 10, 4);


 
