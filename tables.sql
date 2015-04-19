CREATE TABLE TB_USER ( 
CO_SEQ_USER INT NOT NULL, 
DS_NAME VARCHAR2(255), 
DS_EMAIL VARCHAR2(255), 
DS_PASSWORD VARCHAR(255), 

PRIMARY KEY (CO_SEQ_USER) 
);


CREATE TABLE RL_USER_FRIENDS (
CO_USER INT NOT NULL,
CO_FRIEND INT NOT NULL,
PRIMARY KEY (CO_USER, CO_FRIEND),
FOREIGN KEY (CO_USER) REFERENCES TB_USER (CO_SEQ_USER),
FOREIGN KEY (CO_FRIEND) REFERENCES TB_USER (CO_SEQ_USER)
);

CREATE TABLE TB_MOVIE_GENRE (
CO_MOVIE_GENRE INT NOT NULL, 
DS_NAME VARCHAR2(255) NOT NULL,
);

CREATE TABLE TB_MOVIE (
CO_SEQ_MOVIE INT NOT NULL,
DS_NAME VARCHAR2(255),
NU_RATE NUMBER,
PRIMARY KEY (CO_SEQ_MOVIE)
);

CREATE TABLE RL_MOVIE_GENRE (
CO_MOVIE INT NOT NULL,
CO_GENRE INT NOT NULL,
PRIMARY KEY (CO_MOVIE, CO_GENRE),
FOREIGN KEY (CO_MOVIE) REFERENCES TB_MOVIE (CO_SEQ_MOVIE),
FOREIGN KEY (CO_GENRE) REFERENCES TB_MOVIE_GENRE (CO_MOVIE_GENRE)
);

CREATE TABLE TB_REVIEW (
CO_SEQ_REVIEW INT NOT NULL,
NU_RATE NUMBER,
DS_REVIEW VARCHAR2(5000),
CO_USER INT NOT NULL,
CO_MOVIE INT NOT NULL,
PRIMARY KEY (CO_SEQ_REVIEW),
FOREIGN KEY (CO_USER) REFERENCES TB_USER (CO_SEQ_USER),
FOREIGN KEY (CO_MOVIE) REFERENCES TB_MOVIE (CO_SEQ_MOVIE)

);

CREATE SEQUENCE SQ_TB_USER_CO_SEQ_USER
START WITH     0
 INCREMENT BY   1
;

CREATE SEQUENCE SQ_TB_MOVIE_CO_SEQ_MOVIE
START WITH     0
 INCREMENT BY   1
;

CREATE SEQUENCE SQ_TB_REVIEW_CO_SEQ_REVIEW
START WITH     0
 INCREMENT BY   1
;