

-- Criando a tabela órgão
CREATE TABLE portalservicos.orgao (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100),
    sigla VARCHAR(20)
);

-- Criando a tabela categoria
CREATE TABLE portalservicos.categoria (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100),
    descricao VARCHAR(200),
    icone VARCHAR(100)
);

-- Criando a tabela carta_servico
CREATE TABLE portalservicos.carta_servico (
    id BIGSERIAL PRIMARY KEY,
    apresentacao VARCHAR(200),
    orgao_id INT8 REFERENCES portalservicos.orgao(id),
    instituicao VARCHAR(200),
    missao VARCHAR(200),
    valores VARCHAR(200),
    visao VARCHAR(200)
);

CREATE TABLE portalservicos.tipo_servico (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(30),
    descricao VARCHAR(255),
    icone VARCHAR(100)
);

-- Criando a tabela servico
CREATE TABLE portalservicos.servico (
    id BIGSERIAL PRIMARY KEY,
    carta_servico_id INT8 REFERENCES portalservicos.carta_servico(id),
    categoria_id INT8 REFERENCES portalservicos.categoria(id),
    tipo_servico_id int REFERENCES portalservicos.tipo_servico(id),
    orgao_id int REFERENCES portalservicos.orgao(id),
    nome VARCHAR(100),
    o_que_eh TEXT,
    como_fazer TEXT,
    quanto_custa TEXT,
    quanto_tempo TEXT,
    outros_detalhes TEXT,
    contatos TEXT,
    icone VARCHAR(100)
);

-- Criando as tabelas de serviço digital e serviço presencial
CREATE TABLE portalservicos.servico_digital (
    id BIGSERIAL PRIMARY KEY REFERENCES portalservicos.servico(id),
    link VARCHAR(200)
);

CREATE TABLE portalservicos.servico_presencial (
    id BIGSERIAL PRIMARY KEY REFERENCES portalservicos.servico(id)
);

CREATE TABLE portalservicos.estado (
    cod_ibge varchar(10) PRIMARY KEY,
    nome varchar(100),
    uf varchar(2)
);

CREATE TABLE portalservicos.municipio (
    cod_ibge varchar(10) PRIMARY KEY,
    estado_cod_ibge varchar(10) REFERENCES portalservicos.estado(cod_ibge),
    nome varchar(100)
);

-- Criando a tabela local_atendimento
CREATE TABLE portalservicos.local_atendimento (
    id BIGSERIAL PRIMARY KEY,
    servico_id INT8 REFERENCES portalservicos.servico(id),
    orgao_id INT8 REFERENCES portalservicos.orgao(id),
    nome VARCHAR(200),
    logradouro VARCHAR(200),
    bairro VARCHAR(200),
    cep VARCHAR(200),
    municipio_cod varchar(10) REFERENCES portalservicos.municipio(cod_ibge),
    complemento VARCHAR(200),
    numero VARCHAR(200)
);

CREATE TABLE portalservicos.horario_atendimento (
    servico_id INT8 REFERENCES portalservicos.servico_presencial(id),
    local_atendimento_id INT8 REFERENCES portalservicos.local_atendimento(id),
    dia_semana varchar(3),
    hora_inicio TIME,
    hora_fim TIME,
    primary key (servico_id, local_atendimento_id)
);