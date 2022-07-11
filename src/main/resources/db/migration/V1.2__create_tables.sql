create table gisauserapidb.usuario (
    id_usuario uuid not null,
    created_at timestamp,
    created_by uuid,
    deteled boolean,
    update_at timestamp,
    update_by uuid,
    cnpj varchar(255),
    cpf varchar(255),
    email varchar(255),
    nome varchar(255),
    password varchar(255),
    primary key (id_usuario)
);
