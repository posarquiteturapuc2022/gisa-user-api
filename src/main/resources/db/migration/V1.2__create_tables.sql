CREATE TABLE gisauserapidb.usuario (
    id_usuario uuid NOT NULL,
    created_at timestamp,
    update_at timestamp,
    deteled boolean,
    nome varchar(255),
    email varchar(255),
    cnpj varchar(20),
    cpf varchar(15),
    numero_sus varchar(255),
    cidade varchar(255),
    uf varchar(255),
    data_nascimento timestamp,
    password varchar(255),
    PRIMARY KEY (id_usuario)
);
