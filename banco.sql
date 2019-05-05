CREATE DATABASE crudJava;
USE crudJava;

CREATE TABLE cidade (
	idCidade INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(80) NOT NULL,
    PRIMARY KEY(idCidade)
);

CREATE TABLE aluno (
	idAluno INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(80) NOT NULL,
    idCidade INT NOT NULL,
    PRIMARY KEY(idAluno),
    FOREIGN KEY(idCidade) REFERENCES cidade (idCidade)
);