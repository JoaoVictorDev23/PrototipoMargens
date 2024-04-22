-- Versão da Migração: 3
CREATE TABLE cliente (
                          id VARCHAR(255) PRIMARY KEY,
                          grupo_cliente VARCHAR(255) UNIQUE NOT NULL,
                          nome_cliente VARCHAR(255) NOT NULL,
                          observacao_cliente VARCHAR(255) NOT NULL,
);