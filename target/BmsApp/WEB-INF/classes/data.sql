CREATE TABLE Author (id bigint generated by default as identity, name varchar(255), contact varchar(255), primary key (id));

INSERT INTO Author(id, contact, name) VALUES(1, 'dee@duniadee.com', 'Dewi Leatari');
INSERT INTO Author(id, contact, name) VALUES(2, 'fbasuki@gmail.com', 'Fira Basuki');
INSERT INTO Author(id, contact, name) VALUES(2, '012345678', 'Mahesa Jenar');
INSERT INTO Author(id, contact, name) VALUES(2, 'pram@mizan.com', 'Pramudya D');