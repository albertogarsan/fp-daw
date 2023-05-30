DROP DATABASE IF EXISTS tenda_instruments;
CREATE DATABASE tenda_instruments;
USE tenda_instruments;

CREATE TABLE instruments (
	numSerie VARCHAR(20) UNIQUE NOT NULL PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    preu DOUBLE NOT NULL,
    tipus ENUM("FUSTA", "METALL"),
    idClient BIGINT REFERENCES clients(id)
);

CREATE TABLE clients (
	id BIGINT UNIQUE NOT NULL PRIMARY KEY,
	nom VARCHAR(255) NOT NULL
);

INSERT INTO instruments(numSerie, nom, preu, tipus, idClient) VALUES 
("1", "Clarinet", 3000.00, "FUSTA", NULL),
("2", "Saxofó Tenor", 4500.00, "FUSTA", NULL),
("3", "Trombó", 1200.00, "METALL", NULL);
