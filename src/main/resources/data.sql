CREATE TABLE cliente (
    id IDENTITY PRIMARY KEY NOT NULL,
    nome VARCHAR(255)
);

CREATE TABLE veiculo (
    id IDENTITY PRIMARY KEY NOT NULL,
    placa VARCHAR(10),
    modelo VARCHAR(50)
);

CREATE TABLE estoque (
    id IDENTITY PRIMARY KEY NOT NULL,
    nome VARCHAR(255),
    valor DECIMAL(10, 2),
    quantidade INT
);

CREATE TABLE ordem_servico (
    id IDENTITY PRIMARY KEY NOT NULL,
    cliente_id BIGINT NOT NULL,
    veiculo_id BIGINT NOT NULL,
    estoque_id BIGINT,
    descricao VARCHAR(255),
    valor DECIMAL(10, 2),
    FOREIGN KEY (cliente_id) REFERENCES cliente(id),
    FOREIGN KEY (veiculo_id) REFERENCES veiculo(id),
    FOREIGN KEY (estoque_id) REFERENCES estoque(id)
);