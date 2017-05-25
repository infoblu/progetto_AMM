/* Connessione al db:
* user: administrator
* password: 123
*/

-- Creazione Tabelle

CREATE TABLE utentiRegistrati (
	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
	amministratore BOOLEAN,
	nome VARCHAR (32) UNIQUE NOT NULL,
	cognome VARCHAR (32),
	urlFotoProfilo VARCHAR (128),
	presentazione VARCHAR (2000),
	dataNascita DATE,
	password VARCHAR (32)
	);

CREATE TABLE postType (
	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
	tipoPost VARCHAR (32)
	);

CREATE TABLE posts (
	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
	messaggio VARCHAR (1024),
	tipoPost INTEGER,
	url VARCHAR(256),
	autore INTEGER,
	destinatario INTEGER,
	FOREIGN KEY (tipoPost) REFERENCES postType(id),
	FOREIGN KEY (autore) REFERENCES utentiRegistrati(id),
	FOREIGN KEY (destinatario) REFERENCES utentiRegistrati(id)
	);

CREATE TABLE Amici (
	amico1 INTEGER,
	amico2 INTEGER,
	FOREIGN KEY (amico1) REFERENCES utentiRegistrati(id),
	FOREIGN KEY (amico2) REFERENCES utentiRegistrati(id),
	PRIMARY KEY (amico1,amico2)
	);

CREATE TABLE Gruppi (
	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
	nome VARCHAR(64) UNIQUE NOT NULL,
	proprietario INTEGER,
	FOREIGN KEY (proprietario) REFERENCES utentiRegistrati(id)
	);

CREATE TABLE AmiciGruppi (
	gruppo INTEGER,
	amico INTEGER,
	FOREIGN KEY (gruppo) REFERENCES utentiRegistrati(id),
	FOREIGN KEY (amico) REFERENCES utentiRegistrati(id),
	PRIMARY KEY (gruppo,amico)
	);

CREATE TABLE PostGruppi (
	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
	messaggio VARCHAR(1024) NOT NULL,
	tipoPost INTEGER,
	url VARCHAR(256),
	autore INTEGER,
	FOREIGN KEY (tipoPost) REFERENCES postType(id),
	FOREIGN KEY (autore) REFERENCES utentiRegistrati(id)
	);

-- Popolamento Utenti registrati

INSERT INTO utentiRegistrati (id,amministratore,nome,cognome,urlFotoProfilo,presentazione,dataNascita,password)
	VALUES
	(default, true, 'Riccardo', 'Vacca','img/riccardovacca.jpg','Nel mezzo del cammin di nostra vita mi ritrovai per una selva oscura','1972-01-28','123');

INSERT INTO utentiRegistrati (id,amministratore,nome,cognome,urlFotoProfilo,presentazione,dataNascita,password)
	VALUES
	(default, false, 'Barack', 'Obama','img/barackobama.jpg','Hey guys! Vote for me, please!','1964-01-02','123');

INSERT INTO utentiRegistrati (id,amministratore,nome,cognome,urlFotoProfilo,presentazione,dataNascita,password)
	VALUES
	(default, false, 'Ken', 'Follett','img/kenfollett.jpg','You have to read my books!','1950-06-24','123');

INSERT INTO utentiRegistrati (id,amministratore,nome,cognome,urlFotoProfilo,presentazione,dataNascita,password)
	VALUES
	(default, false, 'Jean-Luc', 'Picard','img/picard.png','Engage!','1951-11-18','123');

INSERT INTO utentiRegistrati (id,amministratore,nome,cognome,urlFotoProfilo,presentazione,dataNascita,password)
	VALUES
	(default, false, 'Incompleto', '','','',NULL,'123');

-- Popolamento Tipi di Post

INSERT INTO postType (id,tipoPost)
	VALUES
	(default,'TESTO'),(default, 'IMAGE'),(default, 'URL');

-- Popolamento posts

INSERT INTO  posts (id, messaggio, tipoPost, url, autore, destinatario)
	VALUES
	(default,'Questo � il post numero 1 di Riccardo Vacca',1,NULL,1,1),
	(default,'War, war, war!',1,NULL,2,2),
	(default,'Now I''m going to tell you my new bestseller',2,'img/copertina_bestseller.jpg',3,3),
	(default,'Visit USS Enterprise (NCC-1701-D)',3,'https://it.wikipedia.org/wiki/Star_Trek:_The_Next_Generation',4,4),
	(default,'Perch� Nerdbook non accetta un profilo incompleto?',1,NULL,5,5),
	(default,'Proviamo a postare un''immagine, vediamo come va...',2,'img/4mori.jpg',1,1),
	(default,'Ciao amici, date un''occhiata a questa notizia',3,'http://www.repubblica.it',1,1);
-- Popolamento Gruppi

INSERT INTO  Gruppi (id, nome, proprietario)
	VALUES
	(default,'Riders',1),
	(default,'Squash',2),
	(default,'Star Trek',1);

-- Popolamento Amici

INSERT INTO Amici (Amico1, Amico2)
	VALUES
	(1,2),(2,1),(1,3),(3,1),(4,5),(5,4);

-- Popolamento AmiciGruppi
INSERT INTO AmiciGruppi (gruppo, amico)
	VALUES
	(1,1),(1,2),(2,2),(2,3),(3,3),(3,4);

-- Popolamento PostGruppi
INSERT INTO PostGruppi (id, messaggio, tipoPost, url, autore)
	VALUES
	(default, 'Benvenuti nel gruppo',1,NULL,1),
	(default, 'Questo � un gruppo serio',2,'img/enterprise.jpg',2),
	(default, 'Vuoi far parte di questo gruppo?',3,'https://www.google.it',3);

/* 

-- GET

-- getUtenteRegistratoById

SELECT * FROM utentiRegistrati WHERE id=2;

-- getIdByUserAndPassword
SELECT id FROM utentiRegistrati WHERE name='' AND password='';


-- getPostById
SELECT * FROM posts WHERE id=1;

-- getPostList
SELECT * FROM posts WHERE author=1;

*/