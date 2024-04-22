-- Versão da Migração: 1
CREATE TABLE usuarios (
                          id VARCHAR(255) PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          cpf VARCHAR(20) NOT NULL,
                          email VARCHAR(255) NOT NULL UNIQUE,
                          senha VARCHAR(255) NOT NULL,
                          perfil VARCHAR(50)
);
create table Margem (
                        id VARCHAR(255) PRIMARY KEY,
                        cliente VARCHAR(255) NOT NULL,
                        cnpj VARCHAR(255) NOT NULL,
                        linha VARCHAR(255)NOT NULL unique,
                        origem VARCHAR(255)NOT NULL,
                        destino VARCHAR(255)NOT NULL,
                        margem VARCHAR(255) NOT NULL,
                        observacao VARCHAR(255),
                        cadastrado_por VARCHAR(255) NOT NULL,


);