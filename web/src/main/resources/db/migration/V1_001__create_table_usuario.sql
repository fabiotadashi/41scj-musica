create table TB_USUARIO(
   ID BIGINT auto_increment
       primary key,
   NOME VARCHAR(255),
   SENHA VARCHAR(255),
   DATA_CRIACAO TIMESTAMP not null,
   DATA_ULTIMA_ATUALIZACAO TIMESTAMP
);

