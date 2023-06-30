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
    sexo char(1),
    cep varchar(9),
    endereco varchar(255),
    numero varchar(10),
    bairro varchar(100),
    cidade varchar(100),
    uf varchar(2),
    estado_civil varchar(255),
	data_cadastro timestamp,
	data_nascimento timestamp,
    codigo_plano varchar(255),
    valor_plano_mensal varchar(255),
	id_profissao uuid,
    nivel_formacao int4,
    password varchar(255),
    PRIMARY KEY (id_usuario)
);

CREATE TABLE gisauserapidb.profissao (
    id_profissao uuid NOT NULL,
    nome varchar(255),
    PRIMARY KEY (id_profissao)
);
   
alter table if exists gisauserapidb.usuario 
   add constraint FK_usuario_profissao 
   foreign key (id_profissao)
   references gisauserapidb.profissao;
