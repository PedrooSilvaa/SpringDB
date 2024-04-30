CREATE DATABASE bandadb;

use bandadb;

CREATE TABLE banda(
id int auto_increment,
nome varchar(120),
anolancamento int,
constraint pk_banda primary key (id)
);

-- INSERIR
INSERT INTO banda (NOME, ANOLANCAMENTO) VALUES (?, ?);

-- BUSCAR POR ID
SELECT ID, NOME, ANOLANCAMENTO FROM banda WHERE ID = ?;

-- listar
SELECT ID, NOME, ANOLANCAMENTO FROM banda;

-- alterar
UPDATE banda SET nome = 'pedro', anolancamento = 2222 WHERE id = 1;

-- exclui
DELETE FROM banda WHERE ID = 2; 