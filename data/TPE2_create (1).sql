-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-05-04 19:32:17.224

-- tables
-- Table: CARRERA
CREATE TABLE CARRERA (
    id int NOT NULL,
    nombre int NOT NULL,
    duracion int NOT NULL,
    CONSTRAINT CARRERA_pk PRIMARY KEY (id)
);

-- Table: CIUDAD
CREATE TABLE CIUDAD (
    id int NOT NULL,
    nombre int NOT NULL,
    CONSTRAINT CIUDAD_pk PRIMARY KEY (id)
);

-- Table: ESTADO
CREATE TABLE ESTADO (
    CARRERA_id int NOT NULL,
    ESTUDIANTE_num_Libreta int NOT NULL,
    recibido bool NOT NULL,
    anios int NOT NULL,
    CONSTRAINT ESTADO_pk PRIMARY KEY (CARRERA_id,ESTUDIANTE_num_Libreta)
);

-- Table: ESTUDIANTE
CREATE TABLE ESTUDIANTE (
    num_Libreta int NOT NULL,
    num_doc int NOT NULL,
    nombres varchar(150) NOT NULL,
    edad int NOT NULL,
    apellido varchar(100) NOT NULL,
    genero varchar(50) NOT NULL,
    Ciudad_id int NOT NULL,
    CONSTRAINT ESTUDIANTE_pk PRIMARY KEY (num_Libreta)
);

-- foreign keys
-- Reference: FK_ESTADO_CARRERA (table: ESTADO)
ALTER TABLE ESTADO ADD CONSTRAINT FK_ESTADO_CARRERA FOREIGN KEY FK_ESTADO_CARRERA (CARRERA_id)
    REFERENCES CARRERA (id);

-- Reference: FK_ESTADO_ESTUDIANTE (table: ESTADO)
ALTER TABLE ESTADO ADD CONSTRAINT FK_ESTADO_ESTUDIANTE FOREIGN KEY FK_ESTADO_ESTUDIANTE (ESTUDIANTE_num_Libreta)
    REFERENCES ESTUDIANTE (num_Libreta);

-- Reference: FK_ESTUDIANTES_CIUDAD (table: ESTUDIANTE)
ALTER TABLE ESTUDIANTE ADD CONSTRAINT FK_ESTUDIANTES_CIUDAD FOREIGN KEY FK_ESTUDIANTES_CIUDAD (Ciudad_id)
    REFERENCES CIUDAD (id);

-- End of file.

