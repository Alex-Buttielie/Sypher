CREATE SEQUENCE pessoa_id_seq
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

 CREATE TABLE pessoa (
    codigo INTEGER DEFAULT NEXTVAL('pessoa_id_seq'),
    nome  VARCHAR (50) NOT NULL,
    ativo BOOLEAN NOT NULL,
    logradouro VARCHAR (50),
    numero VARCHAR (4),
    complemento VARCHAR (50),
    bairro VARCHAR (50),
    cep VARCHAR (9),
    cidade VARCHAR (20),
    estado VARCHAR (2)


);

INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values('Alex', true, 'Em frente a rua', '0', 'Praça','Centro',  '76180000', 'Trindade', 'GO');
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values('Laura', true, 'Em frente a rua', '0', 'Praça','Centro',  '76180000', 'Trindade', 'GO');
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values('Maria Clara', true, 'Em frente a rua', '0', 'Praça','Centro',  '76180000', 'Trindade', 'GO');
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values('Teste', true, 'Em frente a rua', '0', 'Praça','Centro',  '76180000', 'Trindade', 'GO');
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values('Tafarel', true, 'Em frente a rua', '0', 'Praça','Centro',  '76180000', 'Trindade', 'GO');
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values('Mãe', true, 'Em frente a rua', '0', 'Praça','Centro',  '76180000', 'Trindade', 'GO');

