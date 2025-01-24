
INSERT INTO portalservicos.tipo_servico (nome, descricao, icone) VALUES ('Cidadão', 'Encontre serviços destinado a todos os cidadãos', 'e-font-icon-svg e-fas-user');
INSERT INTO portalservicos.tipo_servico (nome, descricao, icone) VALUES ('Empresa', 'Encontre serviços destinados a empreendedores e empresas', 'e-font-icon-svg e-fas-industry');
INSERT INTO portalservicos.tipo_servico (nome, descricao, icone) VALUES ('Servidor', 'Encontre serviços destinados a servidores e empregados públicos', 'e-font-icon-svg e-fas-id-card-alt');


INSERT INTO portalservicos.categoria (nome, descricao, icone ) VALUES ('Educação', 'Educação', 'e-font-icon-svg e-fas-id-card-alt');
INSERT INTO portalservicos.categoria (nome, descricao, icone ) VALUES ('Habitação', 'Habitação', 'e-font-icon-svg e-fas-house-user');
INSERT INTO portalservicos.categoria (nome, descricao, icone ) VALUES ('Saúde', 'Saúde', 'e-font-icon-svg e-fas-heartbeat');
INSERT INTO portalservicos.categoria (nome, descricao, icone ) VALUES ('Trânsito', 'Trânsito', 'e-font-icon-svg e-fas-car');


INSERT INTO portalservicos.orgao (sigla, nome) VALUES ('SEMAD', 'Secretaria Municipal de Administração');
INSERT INTO portalservicos.orgao (sigla, nome) VALUES ('SEFIN', 'Secretaria Municipal de Finanças');
INSERT INTO portalservicos.orgao (sigla, nome) VALUES ('SEMEC', 'Secretaria Municipal de Educação');
INSERT INTO portalservicos.orgao (sigla, nome) VALUES ('SESMA', 'Secretaria Municipal de Saúde');
INSERT INTO portalservicos.orgao (sigla, nome) VALUES ('SEURB', 'Secretaria Municipal de Urbanismo');
INSERT INTO portalservicos.orgao (sigla, nome) VALUES ('SEMMA', 'Secretaria Municipal de Meio Ambiente');
INSERT INTO portalservicos.orgao (sigla, nome) VALUES ('SECON', 'Secretaria Municipal de Economia');
INSERT INTO portalservicos.orgao (sigla, nome) VALUES ('SEJEL', 'Secretaria Municipal de Juventude, Esporte e Lazer');
INSERT INTO portalservicos.orgao (sigla, nome) VALUES ('SEMU', 'Secretaria Municipal de Mulheres');
INSERT INTO portalservicos.orgao (sigla, nome) VALUES ('SETRAM', 'Secretaria Municipal de Transportes');

-- Insert into EstadoEntity
INSERT INTO portalservicos.estado (cod_ibge, nome, uf) VALUES ('15', 'Pará', 'PA');

-- Insert into MunicipioEntity
INSERT INTO portalservicos.municipio (cod_ibge, estado_cod_ibge, nome) VALUES ('1501402', '15', 'Belém');

INSERT INTO portalservicos.carta_servico (
    apresentacao,
    orgao_id,
    instituicao,
    missao,
    valores,
    visao
) VALUES (
    'A Prefeitura de Belém trabalha para oferecer serviços de qualidade aos cidadãos.',
    (select id from portalservicos.orgao where sigla = 'SEMAD'),
    'Prefeitura Municipal de Belém',
    'Promover o bem-estar e a qualidade de vida da população de Belém.',
    'Transparência, Eficiência, Compromisso com o cidadão',
    'Ser referência em gestão pública e qualidade de serviços.'
);

--------------------------------------------

-- Insert into ServicoEntity
INSERT INTO portalservicos.servico (
    carta_servico_id,
    categoria_id,
    tipo_servico_id,
    orgao_id,
    nome,
    o_que_eh,
    como_fazer,
    quanto_custa,
    quanto_tempo,
    outros_detalhes,
    contatos,
    icone
) VALUES (
    (SELECT id FROM portalservicos.carta_servico LIMIT 1),
    (SELECT id FROM portalservicos.categoria WHERE descricao = 'Educação'),
    (SELECT id FROM portalservicos.tipo_servico WHERE nome = 'Cidadão'),
    (SELECT id FROM portalservicos.orgao WHERE sigla = 'SEMEC'),
    'Ensino Fundamental EMEF',
    'Serviço destinado a oferecer ensino fundamental nas escolas municipais de Belém.',
    'Para se inscrever, dirija-se à escola mais próxima com os documentos necessários.',
    'Gratuito',
    'O tempo de conclusão depende do ano escolar em que o aluno está matriculado.',
    'Outros detalhes sobre o serviço podem ser encontrados no site da prefeitura.',
    'Telefone: (91) 99999-9999, Email: contato@prefeitura.belem.pa.gov.br',
    'e-font-icon-svg e-fas-school'
);

-- Insert into ServicoDigitalEntity
INSERT INTO portalservicos.servico_digital (
    id,
    link
) VALUES (
    (SELECT id FROM portalservicos.servico WHERE nome = 'Ensino Fundamental EMEF'),
    'https://prefeitura.belem.pa.gov.br/servicos/ensino-fundamental-emef/'
);

-- Insert into LocalAtendimentoEntity
INSERT INTO portalservicos.local_atendimento (
    servico_id,
    orgao_id,
    nome,
    logradouro,
    bairro,
    cep,
    municipio_cod,
    complemento,
    numero
) VALUES (
    (SELECT id FROM portalservicos.servico WHERE nome = 'Ensino Fundamental EMEF'),
    (SELECT id FROM portalservicos.orgao WHERE sigla = 'SEMEC'),
    'Local de Atendimento 1',
    'Av. Nazaré, 1234',
    'Nazaré',
    '66035-170',
    (SELECT cod_ibge FROM portalservicos.municipio WHERE nome = 'Belém'),
    'Próximo ao Shopping',
    '123'
);

-- Insert into ServicoPresencialEntity
INSERT INTO portalservicos.servico_presencial (
    id
) VALUES (
    (SELECT id FROM portalservicos.servico WHERE nome = 'Ensino Fundamental EMEF')
);

-- Insert into HorarioAtendimentoEntity
INSERT INTO portalservicos.horario_atendimento (
    servico_id,
    local_atendimento_id,
    dia_semana,
    hora_inicio,
    hora_fim
) VALUES (
    (SELECT id FROM portalservicos.servico_presencial WHERE id = (SELECT id FROM portalservicos.servico WHERE nome = 'Ensino Fundamental EMEF')),
    (SELECT id FROM portalservicos.local_atendimento order by id desc limit 1),
    'SEG',
    '08:00:00',
    '17:00:00'
);

--------------------------------------------

-- Insert into ServicoEntity
INSERT INTO portalservicos.servico (
    carta_servico_id,
    categoria_id,
    tipo_servico_id,
    orgao_id,
    nome,
    o_que_eh,
    como_fazer,
    quanto_custa,
    quanto_tempo,
    outros_detalhes,
    contatos,
    icone
) VALUES (
    (SELECT id FROM portalservicos.carta_servico LIMIT 1),
    (SELECT id FROM portalservicos.categoria WHERE descricao = 'Educação'),
    (SELECT id FROM portalservicos.tipo_servico WHERE nome = 'Cidadão'),
    (SELECT id FROM portalservicos.orgao WHERE sigla = 'SEMEC'),
    'Ensino Médio Técnico em Meio Ambiente - FUNBOSQUE',
    'Serviço destinado a oferecer ensino médio técnico em meio ambiente nas escolas municipais de Belém.',
    'Para se inscrever, dirija-se à escola mais próxima com os documentos necessários.',
    'Gratuito',
    'O tempo de conclusão depende do ano escolar em que o aluno está matriculado.',
    'Outros detalhes sobre o serviço podem ser encontrados no site da prefeitura.',
    'Telefone: (91) 99999-9999, Email: contato@prefeitura.belem.pa.gov.br',
    'e-font-icon-svg e-fas-leaf'
);

-- Insert into LocalAtendimentoEntity
INSERT INTO portalservicos.local_atendimento (
    servico_id,
    orgao_id,
    nome,
    logradouro,
    bairro,
    cep,
    municipio_cod,
    complemento,
    numero
) VALUES (
    (SELECT id FROM portalservicos.servico WHERE nome = 'Ensino Médio Técnico em Meio Ambiente - FUNBOSQUE'),
    (SELECT id FROM portalservicos.orgao WHERE sigla = 'SEMEC'),
    'Local de Atendimento 2',
    'Av. Nazaré, 1234',
    'Nazaré',
    '66035-170',
    (SELECT cod_ibge FROM portalservicos.municipio WHERE nome = 'Belém'),
    'Próximo ao Shopping',
    '123'
);

-- Insert into ServicoPresencialEntity
INSERT INTO portalservicos.servico_presencial (
    id
) VALUES (
    (SELECT id FROM portalservicos.servico WHERE nome = 'Ensino Médio Técnico em Meio Ambiente - FUNBOSQUE')
);

-- Insert into HorarioAtendimentoEntity
INSERT INTO portalservicos.horario_atendimento (
    servico_id,
    local_atendimento_id,
    dia_semana,
    hora_inicio,
    hora_fim
) VALUES (
    (SELECT id FROM portalservicos.servico_presencial WHERE id = (SELECT id FROM portalservicos.servico WHERE nome = 'Ensino Médio Técnico em Meio Ambiente - FUNBOSQUE')),
    (SELECT id FROM portalservicos.local_atendimento order by id desc limit 1),
    'SEG',
    '08:00:00',
    '17:00:00'
);

--habitação

--------------------------------------------

-- Insert into ServicoEntity
INSERT INTO portalservicos.servico (
    carta_servico_id,
    categoria_id,
    tipo_servico_id,
    orgao_id,
    nome,
    o_que_eh,
    como_fazer,
    quanto_custa,
    quanto_tempo,
    outros_detalhes,
    contatos,
    icone
) VALUES (
    (SELECT id FROM portalservicos.carta_servico LIMIT 1),
    (SELECT id FROM portalservicos.categoria WHERE descricao = 'Habitação'),
    (SELECT id FROM portalservicos.tipo_servico WHERE nome = 'Cidadão'),
    (SELECT id FROM portalservicos.orgao WHERE sigla = 'SEURB'),
    'Programa Terra da Gente',
    'Programa destinado a regularização fundiária e urbanização de áreas ocupadas por população de baixa renda.',
    'Para participar, inscreva-se no site da prefeitura ou dirija-se ao órgão responsável com os documentos necessários.',
    'Gratuito',
    'O tempo de conclusão depende da análise e regularização de cada caso.',
    'Outros detalhes sobre o programa podem ser encontrados no site da prefeitura.',
    'Telefone: (91) 99999-9999, Email: contato@prefeitura.belem.pa.gov.br',
    'e-font-icon-svg e-fas-landmark'
);

-- Insert into LocalAtendimentoEntity
INSERT INTO portalservicos.local_atendimento (
    servico_id,
    orgao_id,
    nome,
    logradouro,
    bairro,
    cep,
    municipio_cod,
    complemento,
    numero
) VALUES (
    (SELECT id FROM portalservicos.servico WHERE nome = 'Programa Terra da Gente'),
    (SELECT id FROM portalservicos.orgao WHERE sigla = 'SEURB'),
    'Local atendimento 6',
    'Av. Nazaré, 1234',
    'Nazaré',
    '66035-170',
    (SELECT cod_ibge FROM portalservicos.municipio WHERE nome = 'Belém'),
    'Próximo ao Shopping',
    '123'
);

-- Insert into ServicoPresencialEntity
INSERT INTO portalservicos.servico_presencial (
    id
) VALUES (
    (SELECT id FROM portalservicos.servico WHERE nome = 'Programa Terra da Gente')
);

-- Insert into HorarioAtendimentoEntity
INSERT INTO portalservicos.horario_atendimento (
    servico_id,
    local_atendimento_id,
    dia_semana,
    hora_inicio,
    hora_fim
) VALUES (
    (SELECT id FROM portalservicos.servico_presencial WHERE id = (SELECT id FROM portalservicos.servico WHERE nome = 'Programa Terra da Gente')),
    (SELECT id FROM portalservicos.local_atendimento order by id desc limit 1),
    'SEG',
    '08:00:00',
    '17:00:00'
);
--------------------------------------------

-- Insert into ServicoEntity
INSERT INTO portalservicos.servico (
    carta_servico_id,
    categoria_id,
    tipo_servico_id,
    orgao_id,
    nome,
    o_que_eh,
    como_fazer,
    quanto_custa,
    quanto_tempo,
    outros_detalhes,
    contatos,
    icone
) VALUES (
    (SELECT id FROM portalservicos.carta_servico LIMIT 1),
    (SELECT id FROM portalservicos.categoria WHERE descricao = 'Habitação'),
    (SELECT id FROM portalservicos.tipo_servico WHERE nome = 'Cidadão'),
    (SELECT id FROM portalservicos.orgao WHERE sigla = 'SEURB'),
    'Programa Viver Belém - Minha Casa Minha Vida',
    'Programa destinado a oferecer moradia digna para a população de baixa renda.',
    'Para participar, inscreva-se no site da prefeitura ou dirija-se ao órgão responsável com os documentos necessários.',
    'Gratuito',
    'O tempo de conclusão depende da análise e aprovação de cada caso.',
    'Outros detalhes sobre o programa podem ser encontrados no site da prefeitura.',
    'Telefone: (91) 99999-9999, Email: contato@prefeitura.belem.pa.gov.br',
    'e-font-icon-svg e-fas-home'
);

-- Insert into ServicoDigitalEntity
INSERT INTO portalservicos.servico_digital (
    id,
    link
) VALUES (
    (SELECT id FROM portalservicos.servico WHERE nome = 'Programa Viver Belém - Minha Casa Minha Vida'),
    'https://prefeitura.belem.pa.gov.br/servicos/programa-viver-belem-minha-casa-minha-vida/'
);

-- Insert into LocalAtendimentoEntity
INSERT INTO portalservicos.local_atendimento (
    servico_id,
    orgao_id,
    nome,
    logradouro,
    bairro,
    cep,
    municipio_cod,
    complemento,
    numero
) VALUES (
    (SELECT id FROM portalservicos.servico WHERE nome = 'Programa Viver Belém - Minha Casa Minha Vida'),
    (SELECT id FROM portalservicos.orgao WHERE sigla = 'SEURB'),
    'Local atendimento 3',
    'Av. Nazaré, 1234',
    'Nazaré',
    '66035-170',
    (SELECT cod_ibge FROM portalservicos.municipio WHERE nome = 'Belém'),
    'Próximo ao Shopping',
    '123'
);

-- Insert into ServicoPresencialEntity
INSERT INTO portalservicos.servico_presencial (
    id
) VALUES (
    (SELECT id FROM portalservicos.servico WHERE nome = 'Programa Viver Belém - Minha Casa Minha Vida')
);

-- Insert into HorarioAtendimentoEntity
INSERT INTO portalservicos.horario_atendimento (
    servico_id,
    local_atendimento_id,
    dia_semana,
    hora_inicio,
    hora_fim
) VALUES (
    (SELECT id FROM portalservicos.servico_presencial WHERE id = (SELECT id FROM portalservicos.servico WHERE nome = 'Programa Viver Belém - Minha Casa Minha Vida')),
    (SELECT id FROM portalservicos.local_atendimento order by id desc limit 1),
    'SEG',
    '08:00:00',
    '17:00:00'
);

--------------------------------------------

-- Insert into ServicoEntity
INSERT INTO portalservicos.servico (
    carta_servico_id,
    categoria_id,
    tipo_servico_id,
    orgao_id,
    nome,
    o_que_eh,
    como_fazer,
    quanto_custa,
    quanto_tempo,
    outros_detalhes,
    contatos,
    icone
) VALUES (
    (SELECT id FROM portalservicos.carta_servico LIMIT 1),
    (SELECT id FROM portalservicos.categoria WHERE descricao = 'Saúde'),
    (SELECT id FROM portalservicos.tipo_servico WHERE nome = 'Cidadão'),
    (SELECT id FROM portalservicos.orgao WHERE sigla = 'SESMA'),
    'Saúde Belém Digital',
    'Serviço destinado a oferecer atendimento de saúde digital para a população de Belém.',
    'Para utilizar o serviço, acesse o site da prefeitura e siga as instruções para agendamento.',
    'Gratuito',
    'O tempo de atendimento pode variar conforme a demanda.',
    'Outros detalhes sobre o serviço podem ser encontrados no site da prefeitura.',
    'Telefone: (91) 99999-9999, Email: contato@prefeitura.belem.pa.gov.br',
    'e-font-icon-svg e-fas-stethoscope'
);

-- Insert into ServicoDigitalEntity
INSERT INTO portalservicos.servico_digital (
    id,
    link
) VALUES (
    (SELECT id FROM portalservicos.servico WHERE nome = 'Saúde Belém Digital'),
    'https://prefeitura.belem.pa.gov.br/servicos/saude-belem-digital/'
);

--------------------------------------------

-- Insert into ServicoEntity
INSERT INTO portalservicos.servico (
    carta_servico_id,
    categoria_id,
    tipo_servico_id,
    orgao_id,
    nome,
    o_que_eh,
    como_fazer,
    quanto_custa,
    quanto_tempo,
    outros_detalhes,
    contatos,
    icone
) VALUES (
    (SELECT id FROM portalservicos.carta_servico LIMIT 1),
    (SELECT id FROM portalservicos.categoria WHERE descricao = 'Saúde'),
    (SELECT id FROM portalservicos.tipo_servico WHERE nome = 'Cidadão'),
    (SELECT id FROM portalservicos.orgao WHERE sigla = 'SESMA'),
    'Guia Médico do PABSS',
    'Serviço destinado a fornecer um guia médico para o Programa de Assistência à Saúde dos Servidores.',
    'Para acessar o guia, visite o site da prefeitura e siga as instruções fornecidas.',
    'Gratuito',
    'O tempo de acesso é imediato após a consulta online.',
    'Outros detalhes sobre o serviço podem ser encontrados no site da prefeitura.',
    'Telefone: (91) 99999-9999, Email: contato@prefeitura.belem.pa.gov.br',
    'e-font-icon-svg e-fas-book-medical'
);

-- Insert into ServicoDigitalEntity
INSERT INTO portalservicos.servico_digital (
    id,
    link
) VALUES (
    (SELECT id FROM portalservicos.servico WHERE nome = 'Guia Médico do PABSS'),
    'https://prefeitura.belem.pa.gov.br/servicos/guia-medico-do-pabss/'
);


--------------------------------------------

-- Insert into ServicoEntity
INSERT INTO portalservicos.servico (
    carta_servico_id,
    categoria_id,
    tipo_servico_id,
    orgao_id,
    nome,
    o_que_eh,
    como_fazer,
    quanto_custa,
    quanto_tempo,
    outros_detalhes,
    contatos,
    icone
) VALUES (
    (SELECT id FROM portalservicos.carta_servico LIMIT 1),
    (SELECT id FROM portalservicos.categoria WHERE descricao = 'Trânsito'),
    (SELECT id FROM portalservicos.tipo_servico WHERE nome = 'Cidadão'),
    (SELECT id FROM portalservicos.orgao WHERE sigla = 'SETRAM'),
    'Implantação de Sinalização Vertical e Horizontal',
    'Serviço destinado à implantação de sinalização vertical e horizontal nas vias públicas de Belém.',
    'Para solicitar o serviço, acesse o site da prefeitura ou dirija-se ao órgão responsável com os documentos necessários.',
    'Gratuito',
    'O tempo de conclusão depende da análise e aprovação de cada caso.',
    'Outros detalhes sobre o serviço podem ser encontrados no site da prefeitura.',
    'Telefone: (91) 99999-9999, Email: contato@prefeitura.belem.pa.gov.br',
    'e-font-icon-svg e-fas-road'
);

-- Insert into LocalAtendimentoEntity
INSERT INTO portalservicos.local_atendimento (
    servico_id,
    orgao_id,
    nome,
    logradouro,
    bairro,
    cep,
    municipio_cod,
    complemento,
    numero
) VALUES (
    (SELECT id FROM portalservicos.servico WHERE nome = 'Implantação de Sinalização Vertical e Horizontal'),
    (SELECT id FROM portalservicos.orgao WHERE sigla = 'SETRAM'),
    'Local atendimento 4',
    'Av. Nazaré, 1234',
    'Nazaré',
    '66035-170',
    (SELECT cod_ibge FROM portalservicos.municipio WHERE nome = 'Belém'),
    'Próximo ao Shopping',
    '123'
);

-- Insert into ServicoPresencialEntity
INSERT INTO portalservicos.servico_presencial (
    id
) VALUES (
    (SELECT id FROM portalservicos.servico WHERE nome = 'Implantação de Sinalização Vertical e Horizontal')
);

-- Insert into HorarioAtendimentoEntity
INSERT INTO portalservicos.horario_atendimento (
    servico_id,
    local_atendimento_id,
    dia_semana,
    hora_inicio,
    hora_fim
) VALUES (
    (SELECT id FROM portalservicos.servico_presencial WHERE id = (SELECT id FROM portalservicos.servico WHERE nome = 'Implantação de Sinalização Vertical e Horizontal')),
    (SELECT id FROM portalservicos.local_atendimento order by id desc limit 1),
    'SEG',
    '08:00:00',
    '17:00:00'
);

--------------------------------------------

-- Insert into ServicoEntity
INSERT INTO portalservicos.servico (
    carta_servico_id,
    categoria_id,
    tipo_servico_id,
    orgao_id,
    nome,
    o_que_eh,
    como_fazer,
    quanto_custa,
    quanto_tempo,
    outros_detalhes,
    contatos,
    icone
) VALUES (
    (SELECT id FROM portalservicos.carta_servico LIMIT 1),
    (SELECT id FROM portalservicos.categoria WHERE descricao = 'Educação'),
    (SELECT id FROM portalservicos.tipo_servico WHERE nome = 'Cidadão'),
    (SELECT id FROM portalservicos.orgao WHERE sigla = 'SEMEC'),
    'Passe Fácil Estudantil',
    'Serviço destinado a oferecer passe livre estudantil para alunos da rede pública de ensino.',
    'Para se inscrever, acesse o site da prefeitura e siga as instruções para cadastro.',
    'Gratuito',
    'O tempo de processamento pode variar conforme a demanda.',
    'Outros detalhes sobre o serviço podem ser encontrados no site da prefeitura.',
    'Telefone: (91) 99999-9999, Email: contato@prefeitura.belem.pa.gov.br',
    'e-font-icon-svg e-fas-bus'
);

-- Insert into ServicoDigitalEntity
INSERT INTO portalservicos.servico_digital (
    id,
    link
) VALUES (
    (SELECT id FROM portalservicos.servico WHERE nome = 'Passe Fácil Estudantil'),
    'https://prefeitura.belem.pa.gov.br/servicos/passe-facil-estudantil/'
);

-- Insert into LocalAtendimentoEntity
INSERT INTO portalservicos.local_atendimento (
    servico_id,
    orgao_id,
    nome,
    logradouro,
    bairro,
    cep,
    municipio_cod,
    complemento,
    numero
) VALUES (
    (SELECT id FROM portalservicos.servico WHERE nome = 'Passe Fácil Estudantil'),
    (SELECT id FROM portalservicos.orgao WHERE sigla = 'SEMEC'),
    'Local atendimento 5',
    'Av. Nazaré, 1234',
    'Nazaré',
    '66035-170',
    (SELECT cod_ibge FROM portalservicos.municipio WHERE nome = 'Belém'),
    'Próximo ao Shopping',
    '123'
);

-- Insert into ServicoPresencialEntity
INSERT INTO portalservicos.servico_presencial (
    id
) VALUES (
    (SELECT id FROM portalservicos.servico WHERE nome = 'Passe Fácil Estudantil')
);

-- Insert into HorarioAtendimentoEntity
INSERT INTO portalservicos.horario_atendimento (
    servico_id,
    local_atendimento_id,
    dia_semana,
    hora_inicio,
    hora_fim
) VALUES (
    (SELECT id FROM portalservicos.servico_presencial WHERE id = (SELECT id FROM portalservicos.servico WHERE nome = 'Passe Fácil Estudantil')),
    (SELECT id FROM portalservicos.local_atendimento order by id desc limit 1),
    'SEG',
    '08:00:00',
    '17:00:00'
);




