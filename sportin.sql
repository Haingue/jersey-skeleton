DROP TABLE IF EXISTS available_sport;
DROP TABLE IF EXISTS participant;
DROP TABLE IF EXISTS evaluation;
DROP TABLE IF EXISTS event;
DROP TABLE IF EXISTS room;
DROP TABLE IF EXISTS sport;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS corporate;

CREATE TABLE corporate
(
    cno SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(50) NOT NULL,
    domain VARCHAR(50) NOT NULL,

    CONSTRAINT uniq_corporate_name UNIQUE (name),
    CONSTRAINT uniq_domain UNIQUE (domain)
);

CREATE TABLE users
(
	uno SERIAL PRIMARY KEY NOT NULL,
	login VARCHAR(100) NOT NULL,
	password VARCHAR(50) NOT NULL,
	nom VARCHAR(50) NOT NULL,
	prenom VARCHAR(50) NOT NULL,
	fonction VARCHAR(100),
	cno INT NOT NULL,

	CONSTRAINT fk_cno FOREIGN KEY (cno)
		REFERENCES corporate(cno),

	CONSTRAINT uniq_login UNIQUE (login)
);

CREATE TABLE sport
(
	sno SERIAL PRIMARY KEY NOT NULL,
	name VARCHAR(50) NOT NULL,

	CONSTRAINT uniq_sport_name UNIQUE (name)

);

CREATE TABLE room
(
	rno SERIAL PRIMARY KEY NOT NULL,
	name VARCHAR(50) NOT NULL,
	adress VARCHAR(50) NOT NULL,
	tel VARCHAR(10) NOT NULL
);

CREATE TABLE event
(
	eno SERIAL PRIMARY KEY NOT NULL,
	event_date DATE NOT NULL, 
	heure TIME NOT NULL, 
	participants_needed INT,
	price INT NOT NULL,
	rno INT NOT NULL,
	sno INT NOT NULL,

	CONSTRAINT fk_rno FOREIGN KEY (rno)
		REFERENCES room(rno),

	CONSTRAINT fk_sno FOREIGN KEY (sno)
		REFERENCES sport(sno)
);

CREATE TABLE participant(
	eno INT NOT NULL,
	uno int NOT NULL, 

	CONSTRAINT pk_participant PRIMARY KEY (eno,uno),
	CONSTRAINT fk_eno FOREIGN KEY (eno)
		REFERENCES event(eno),
	CONSTRAINT fk_uno FOREIGN KEY (uno)
		REFERENCES users(uno)

);

CREATE TABLE evaluation(
	sno INT NOT NULL,
	uno INT NOT NULL,
	score INT NOT NULL,

	CONSTRAINT pk_evaluation PRIMARY KEY (uno,sno),
	CONSTRAINT fk_sno FOREIGN KEY (sno)
		REFERENCES sport(sno),
	CONSTRAINT fk_uno FOREIGN KEY (uno)
		REFERENCES users(uno),
	CONSTRAINT evaluation_ok CHECK (score>=1 AND score<=10)

);

CREATE TABLE available_sport(
	sno INT NOT NULL,
	rno INT NOT NULL,

	CONSTRAINT pk_available_sport PRIMARY KEY (sno,rno),
	CONSTRAINT fk_sno FOREIGN KEY (sno)
		REFERENCES sport(sno),
	CONSTRAINT fk_rno FOREIGN KEY (rno)
		REFERENCES room(rno)

);
