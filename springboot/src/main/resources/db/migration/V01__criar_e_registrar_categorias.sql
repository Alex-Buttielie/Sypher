CREATE SEQUENCE categoria_id_seq
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

 CREATE TABLE categoria (
    codigo INTEGER DEFAULT NEXTVAL('categoria_id_seq'),
    nome  VARCHAR (50) NOT NULL
);

INSERT INTO categoria (nome) values('Laser');
INSERT INTO categoria (nome) values('Alimentacao');
INSERT INTO categoria (nome) values('Supermercado');
INSERT INTO categoria (nome) values('Farmacia');
INSERT INTO categoria (nome) values('Outros');

