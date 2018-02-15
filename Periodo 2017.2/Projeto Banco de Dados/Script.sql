-- EVENTO CRIADO
CREATE TABLE Evento (
  id_evento          SERIAL PRIMARY KEY NOT NULL,
  nome_evento        VARCHAR(255)       NOT NULL,
  valor_total_evento FLOAT,
  data_criacao       TIMESTAMP          NOT NULL,
  status_evento      VARCHAR(255)       NOT NULL CHECK (status_evento = 'EM_ANDAMENTO' OR
                                                        status_evento = 'INSCRICOES_ABERTAS' OR
                                                        status_evento = 'FECHADO' OR
                                                        status_evento = 'CANCELADO'),
  dono_evento        INT                NOT NULL REFERENCES Usuario (id_usuario),
  id_tipo_evento     INT                NOT NULL REFERENCES TipoEvento (id_tipo_evento),
  periodo_evento     INT                NOT NULL REFERENCES Periodo (id_periodo)
);

-- ATIVIDADE CRIADA
CREATE TABLE Atividade (
  id_atividade        SERIAL PRIMARY KEY NOT NULL,
  titulo_atividade    VARCHAR(25)        NOT NULL,
  descricao_atividade VARCHAR(255)       NOT NULL,
  quantidade_vagas    INT                NOT NULL,
  valor_atividade     FLOAT              NOT NULL,
  id_periodo          INT                NOT NULL REFERENCES Periodo (id_periodo),
  id_evento           INT                NOT NULL REFERENCES Evento (id_evento)
);

INSERT INTO Atividade VALUES (DEFAULT, 'Atividade de Exbição', 'Atividade de introdução ao Evento', 10, 20.00, 1, 1);
SELECT * from Atividade;
DELETE from Atividade;

-- PERIODO CRIADO
CREATE TABLE Periodo (
  id_periodo     SERIAL PRIMARY KEY NOT NULL,
  periodo_inicio TIMESTAMP          NOT NULL,
  periodo_fim    TIMESTAMP          NOT NULL
);

-- TIPO EVENTO CRIADO
CREATE TABLE TipoEvento (
  id_tipo_evento        SERIAL PRIMARY KEY NOT NULL,
  descricao_tipo_evento VARCHAR(255)       NOT NULL
);

-- EVENTO INSTITUICAO CRIADO
CREATE TABLE EventoInstituicao (
  id_evento_instituicao SERIAL PRIMARY KEY NOT NULL,
  id_evento             INT                NOT NULL REFERENCES Evento (id_evento),
  id_instituicao        INT                NOT NULL REFERENCES Instituicao (id_instituicao)
);

-- INSTITUICAO CRIADA
CREATE TABLE Instituicao (
  id_instituicao   SERIAL PRIMARY KEY NOT NULL,
  nome_instituicao VARCHAR(255)       NOT NULL
);

-- USUARIO CRIADO
CREATE TABLE Usuario (
  id_usuario   SERIAL PRIMARY KEY NOT NULL,
  nome         VARCHAR(255)       NOT NULL,
  email        VARCHAR(255)       NOT NULL,
  data_entrada TIMESTAMP          NOT NULL
);

-- GRUPO USUARIO CRIADO
CREATE TABLE GrupoUsuario (
  id_grupo_usuario SERIAL PRIMARY KEY NOT NULL,
  id_grupo         INT                NOT NULL REFERENCES Grupo (id_grupo),
  id_usuario       INT                NOT NULL REFERENCES Usuario (id_usuario)
);

-- GRUPO CRIADO
CREATE TABLE Grupo (
  id_grupo SERIAL PRIMARY KEY NOT NULL,
  nome     VARCHAR(25)        NOT NULL
);

-- INSCRICAO EM UM EVENTO, A INSCRICAO É FEITA EM TODAS AS ATIVIDADES DO EVENTO
-- CRIADO
-- CREATE TABLE InscricaoEvento (
--   id_inscricao_evento              SERIAL PRIMARY KEY NOT NULL,
--   data_inscricao                   TIMESTAMP          NOT NULL,
--   valor_inscricao                  FLOAT              NOT NULL,
--   status_pagamento                 VARCHAR(255)       NOT NULL CHECK (status_pagamento = 'PAGO' OR
--                                                                       status_pagamento = 'ABERTO'),
--   id_evento                        INT                NOT NULL REFERENCES Evento (id_evento),
--   id_grupo                         INT                NOT NULL REFERENCES Grupo (id_grupo),
--   data_vencimento_pagamento_evento TIMESTAMP          NOT NULL
-- );

-- INSCRICAO NA ATIVIDADE
-- CRIADO
CREATE TABLE Inscricao (
  id_inscricao    SERIAL PRIMARY KEY NOT NULL,
  valor_inscricao           FLOAT              NOT NULL,
  data_vencimento_pagamento TIMESTAMP          NOT NULL,
  status_pagamento          VARCHAR(255)       NOT NULL CHECK (status_pagamento = 'PAGO' OR
                                                               status_pagamento = 'ABERTO'),
  id_grupo                  INT                NOT NULL REFERENCES Grupo (id_grupo)
);

-- CRIADO
CREATE TABLE ItemInscricao (
  id_item_inscricao      SERIAL PRIMARY KEY NOT NULL,
  valor_item_inscricao   FLOAT              NOT NULL,
  id_atividade           INT                NOT NULL REFERENCES Atividade (id_atividade),
  id_inscricao INT                NOT NULL REFERENCES Inscricao (id_inscricao)
);

-- INSERIR GENERICO
CREATE OR REPLACE FUNCTION inserir(tabela TEXT, valores TEXT) RETURNS VOID AS $inserir$
DECLARE query TEXT := 'INSERT INTO ' || tabela || ' VALUES (' || valores || ');';
BEGIN
  IF tabela = 'inscricao' THEN
    RAISE EXCEPTION 'Voce não pode Realizar uma Inscricao por Aqui';
  END IF;
  EXECUTE query;
END;
$inserir$ LANGUAGE plpgsql;

SELECT inserir('grupo', 'DEFAULT, ''Grupo Da Fulia''');
SELECT * FROM grupo;

-- REMOVE GENERICO
-- VERIFICA FUNCAO, PODE ESTAR INCORRETA

CREATE OR REPLACE FUNCTION remover(tabela TEXT, condicao TEXT) RETURNS VOID AS $remover$
DECLARE query TEXT := 'DELETE FROM ' || tabela || ' WHERE ' || condicao || ';';
BEGIN
  EXECUTE query;
END;
$remover$ LANGUAGE plpgsql;

CREATE OR REPLACE VIEW data_pagamento AS SELECT now() + INTERVAL '30 days';
SELECT * from data_pagamento;


CREATE OR REPLACE FUNCTION criar_inscricao(id_grupo INT) RETURNS VOID AS $criar_inscricao$
BEGIN
  --   data de vencimento pagamento sempre 30 dias depois da data atual
  INSERT INTO Inscricao VALUES (default, 0, now() + INTERVAL '30 days', 'ABERTO', $1);
END;
$criar_inscricao$ LANGUAGE plpgsql;

select * from GrupoUsuario;

-- PARTICIPAR GRUPO
CREATE OR REPLACE FUNCTION participar_grupo(id_grupo_participar TEXT, id_usuario_participar TEXT) RETURNS VOID AS $participar_grupo$
  DECLARE
    criar_grupo_usuairo TEXT := 'insert into GrupoUsuario values(DEFAULT, ' || id_grupo_participar || ',' || id_usuario_participar || ' )';
  BEGIN
    EXECUTE criar_grupo_usuairo;
  END;
$participar_grupo$ LANGUAGE plpgsql;

-- INSCRICAO EM EVENTO;
CREATE OR REPLACE FUNCTION inscricao_completa(id_grupo TEXT, id_evento_inscricao TEXT) RETURNS VOID AS $inscricao_completa$
DECLARE
  id_evento_inscricao_atividade INTEGER := id_evento_inscricao;
  criar_inscricao TEXT := 'select criar_inscricao('|| ($1) ||')';
  i INTEGER;
  valor_atividades FLOAT := 0;
BEGIN
  EXECUTE criar_inscricao;
  CREATE OR REPLACE VIEW ids_atividades AS SELECT id_atividade FROM Atividade WHERE id_evento = 1; -- CORRIGIR
  FOR i IN (SELECT * FROM ids_atividades) LOOP
    INSERT INTO ItemInscricao VALUES (DEFAULT,
                                      (SELECT valor_atividade FROM atividade WHERE Atividade.id_atividade = i),
                                      (SELECT id_atividade FROM atividade WHERE Atividade.id_atividade = i),
                                      (SELECT max(id_inscricao) FROM Inscricao));
    valor_atividades := valor_atividades + (SELECT valor_atividade FROM atividade WHERE Atividade.id_atividade = i);
    update Atividade set quantidade_vagas = ((SELECT quantidade_vagas from atividade where id_atividade = i) - 1) where id_atividade = i;
  END LOOP;
  CREATE OR REPLACE view id_insc as SELECT max(id_inscricao) from Inscricao;
  UPDATE Inscricao SET valor_inscricao = valor_atividades WHERE id_inscricao IN (SELECT * FROM id_insc);
--   SELECT aplicar_desconto($1,
--                           (SELECT cast(id_inscricao as text) FROM Inscricao WHERE id_inscricao IN (SELECT * FROM id_insc)),
--                           (SELECT cast(valor_inscricao as text) FROM inscricao WHERE id_inscricao IN (SELECT * FROM id_insc)));
END;
$inscricao_completa$ LANGUAGE plpgsql;

select inscricao_completa('9', '1');

SELECT * FROM Inscricao;
SELECT * from ItemInscricao;
select * from Atividade;
-- delete from Inscricao;
-- DELETE from ItemInscricao;
-- drop TABLE ItemInscricao;


CREATE OR REPLACE FUNCTION inscricao_por_atividade(id_grupo_inscricao TEXT, id_atividade_inscricao TEXT) RETURNS VOID AS $inscricao_por_atividade$
DECLARE
  criar_inscricao      TEXT := 'select criar_inscricao(' || ($1) || ')';
  criar_item_inscricao TEXT :=
  'insert into ItemInscricao values (default, (select valor_atividade from atividade where id_atividade = ' ||
  id_atividade_inscricao || '), ' || id_atividade_inscricao || ', (select max(id_inscricao) from inscricao));';
  quantidade_vagas     TEXT :=
  'update atividade set quantidade_vagas = ((select quantidade_vagas from atividade where id_atividade = ' ||
  id_atividade_inscricao || ') - 1) where id_atividade = ' || id_atividade_inscricao;
  atualizar_valor_inscricao TEXT := 'update Inscricao set valor_inscricao = (select valor_atividade from atividade where id_atividade = ' || id_atividade_inscricao || ');';
BEGIN
  EXECUTE criar_inscricao;
  EXECUTE criar_item_inscricao;
  EXECUTE quantidade_vagas;
  EXECUTE atualizar_valor_inscricao;
END;
$inscricao_por_atividade$ LANGUAGE plpgsql;

SELECT inscricao_por_atividade('9','3');

-- select * from atividade;
--
-- SELECT * from ItemInscricao;
--
-- delete from ItemInscricao;
-- select * from Inscricao;
--
-- SELECT criar_inscricao(9);


CREATE OR REPLACE FUNCTION aplicar_desconto(id_grupo_desconto TEXT, id_inscricao_desconto TEXT) RETURNS void AS $aplicar_desconto$
DECLARE
  grupo_desconto INT := id_grupo_desconto;
  inscricao_desconto_10 TEXT :=
  'update Inscricao set valor_inscricao = (select valor_inscricao from Inscricao where id_inscricao = ' ||
  id_inscricao_desconto || ') - ((select valor_inscricao from Inscricao where id_inscricao = ' || id_inscricao_desconto
  || ') * 0.10) where id_inscricao = ' || id_inscricao_desconto || ';';
  inscricao_desconto_20 TEXT :=
  'update Inscricao set valor_inscricao = (select valor_inscricao from Inscricao where id_inscricao = ' ||
  id_inscricao_desconto || ') - ((select valor_inscricao from Inscricao where id_inscricao = ' || id_inscricao_desconto
  || ') * 0.20) where id_inscricao = ' || id_inscricao_desconto || ';';
--   id_grupo_desc INTEGER := id_grupo_desconto;
BEGIN
--   ALTERAR METODO
  IF (SELECT count(*) FROM GrupoUsuario WHERE id_grupo = grupo_desconto) <= 1 THEN
    EXECUTE inscricao_desconto_10;
  END IF;
  IF (SELECT count(*) FROM GrupoUsuario WHERE id_grupo = grupo_desconto) >= 20  THEN
    EXECUTE inscricao_desconto_20;
  END IF;
END;
$aplicar_desconto$ LANGUAGE plpgsql;

SELECT aplicar_desconto('8', '50');

SELECT * from Grupo;
select * from Inscricao;
select * from GrupoUsuario;
SELECT * from Usuario;
select * from Inscricao;

DELETE from Inscricao;
delete from ItemInscricao;

-- CRIANDO TRIGGERS
-- Verificando email usuario
CREATE OR REPLACE FUNCTION validar_cadastro_usuario() RETURNS TRIGGER AS $validar_cadastro_usuario$
 BEGIN
   IF new.email IN (SELECT email FROM usuario) THEN
     RAISE EXCEPTION 'O Email Cadastrado ja Esta Em Uso';
   END IF;
 END;
$validar_cadastro_usuario$ language plpgsql;
CREATE TRIGGER trigger_cadastro_usuario BEFORE INSERT OR UPDATE ON Usuario FOR EACH ROW EXECUTE PROCEDURE validar_cadastro_usuario();

select inserir('Usuario', 'DEFAULT, ''Kassio Lucas'', ''kassioleodido@gmail.com'', now()');

drop FUNCTION validar_cadastro_atividade();
drop TRIGGER trigger_cadastro_atividade on Atividade;

-- validando atividade
-- TO DO BUGADO ESSA PORRA
CREATE OR REPLACE FUNCTION validar_cadastro_atividade() RETURNS TRIGGER AS $validar_cadastro_atividade$
  BEGIN
    IF new.id_evento NOT IN (SELECT id_evento FROM Evento) THEN
      raise EXCEPTION 'A Evento Informado não esta Cadastrado';
    END IF;
    IF new.valor_atividade < 0 then
      RAISE EXCEPTION 'O valor da Atividade não pode ser Inferior ou igual a Zero';
    END IF;
    IF new.quantidade_vagas < 0 THEN
      RAISE EXCEPTION 'O Numero de Vagas Informado é Invalido';
    END IF;
    IF new.titulo_atividade IN (SELECT descricao_atividade FROM Atividade) THEN
      RAISE EXCEPTION 'A Atividade Ja foi Cadastrada';
    END IF;
    RETURN new;
  END;
$validar_cadastro_atividade$ LANGUAGE plpgsql;
CREATE TRIGGER trigger_cadastro_atividade BEFORE INSERT OR UPDATE ON Atividade FOR EACH ROW EXECUTE PROCEDURE validar_cadastro_atividade();

-- validando grupo
CREATE OR REPLACE FUNCTION validar_cadastro_grupo() RETURNS TRIGGER AS $validar_cadastro_grupo$
 BEGIN
   IF new.nome IN (SELECT nome FROM grupo) THEN
     RAISE EXCEPTION 'Esse Nome de Grupo ja foi Cadastrado';
   END IF;
   RETURN new;
 END;
$validar_cadastro_grupo$ language plpgsql;
CREATE TRIGGER trigger_cadastro_grupo BEFORE INSERT OR UPDATE ON Grupo FOR EACH ROW EXECUTE PROCEDURE validar_cadastro_grupo();

-- validando periodo
CREATE OR REPLACE FUNCTION validar_periodo() RETURNS TRIGGER AS $validar_periodo$
  BEGIN
    IF new.periodo_fim < new.periodo_inicio then
      RAISE EXCEPTION 'A data de Inicio é Anterior a Data de Fim';
    END IF;
    IF new.periodo_inicio < now() then
      RAISE EXCEPTION 'A data de Inicio é Anterior a Data Atual';
    END IF;
    IF new.periodo_fim < now() then
      RAISE EXCEPTION 'A data de Fim é Anterior a Data Atual';
    END IF;
    RETURN new;
  END;
$validar_periodo$ language plpgsql;
CREATE TRIGGER trigger_cadastro_periodo BEFORE INSERT OR UPDATE ON Periodo FOR EACH ROW EXECUTE PROCEDURE validar_periodo();

-- validando evento
CREATE OR REPLACE FUNCTION validar_cadastro_evento() RETURNS TRIGGER AS $validar_cadastro_evento$
  BEGIN
    IF new.nome_evento in (SELECT nome_evento FROM Evento) then
      RAISE EXCEPTION 'Esse nome de Evento ja foi Cadastrado';
    END IF;
    IF new.valor_total_evento < 0 then
      RAISE EXCEPTION 'O Valor Total do Evento não pode Ser Negativo';
    END IF;
    IF new.data_criacao < now() then
      RAISE EXCEPTION 'A Data do Evento Não pode Ser Inferior a Data Atual';
    END IF;
    return new;
  END;
$validar_cadastro_evento$ language plpgsql;
CREATE TRIGGER trigger_cadastro_evento BEFORE INSERT OR UPDATE ON Evento FOR EACH ROW EXECUTE PROCEDURE validar_cadastro_evento();

-- validando instituicao
CREATE OR REPLACE FUNCTION validar_cadastro_instituicao() RETURNS TRIGGER AS $validar_cadastro_instituicao$
  BEGIN
    IF new.nome_instituicao in (SELECT nome_instituicao FROM Instituicao) then
      RAISE EXCEPTION 'Esse nome de Instituicao ja foi Cadastrado';
    END IF;
    return new;
  END;
$validar_cadastro_instituicao$ language plpgsql;
CREATE TRIGGER trigger_cadastro_instituicao BEFORE INSERT OR UPDATE ON Evento FOR EACH ROW EXECUTE PROCEDURE validar_cadastro_instituicao();

-- validando Inscricao em Evento
CREATE OR REPLACE FUNCTION validar_cadastro_inscricao_evento() RETURNS TRIGGER AS $validar_cadastro_inscricao_evento$
  BEGIN
    IF new.id_grupo NOT IN (SELECT id_grupo FROM grupo) THEN
      raise EXCEPTION 'A Grupo Informado não esta Cadastrado';
    END IF;
    if new.data_vencimento_pagamento < now() then
      raise EXCEPTION 'A data De Criação não pode ser Inferior a Data Atual';
    END IF;
    RETURN new;
  END;
$validar_cadastro_inscricao_evento$ language plpgsql;
CREATE TRIGGER trigger_cadastro_inscricao BEFORE INSERT OR UPDATE ON Inscricao FOR EACH ROW EXECUTE PROCEDURE validar_cadastro_inscricao_evento();

-- VALIDADANDO CADASTRO ITEM INSCRICAO
CREATE OR REPLACE FUNCTION validar_cadastro_item_inscricao() RETURNS TRIGGER AS $validar_cadastro_item_inscricao$
BEGIN
  IF new.id_atividade IN (SELECT id_atividade FROM iteminscricao) THEN
    RAISE EXCEPTION 'Você Já se Inscreveu nessa Atividade';
  END IF;
  IF (SELECT quantidade_vagas FROM Atividade WHERE id_atividade = new.id_atividade) = 0 THEN
    DELETE from Inscricao WHERE id_inscricao IN (SELECT max(id_inscricao) FROM inscricao);
    RAISE EXCEPTION 'A Atividade não Possui Vagas Em Aberto';
  END IF;
  IF new.id_atividade NOT IN (SELECT Atividade.id_atividade FROM Atividade) THEN
    RAISE EXCEPTION 'A Atividade Informada não foi Cadastrada';
  END IF;
  RETURN new;
END;
$validar_cadastro_item_inscricao$ language plpgsql;
CREATE TRIGGER trigger_cadastro_item_inscricao BEFORE INSERT OR UPDATE ON ItemInscricao FOR EACH ROW EXECUTE PROCEDURE validar_cadastro_item_inscricao();

drop TRIGGER trigger_cadastro_inscricao on Inscricao;
drop FUNCTION validar_cadastro_inscricao_evento();

-- ============================================================

-- POPULAR BANCO DE DADOS

-- CRIANDO USUARIO
SELECT inserir('Usuario', ('default, ''Kassio Lucas de Holanda'', ''kassioholandaleodido@gmail.com'', now()'));
SELECT inserir('Usuario', ('default, ''Kaio Lucas de Holanda'', ''kaioluks@gmail.com'', now()'));
SELECT * FROM usuario;

-- CRIANDO GRUPO
SELECT inserir('Grupo', 'default, ''Grupo Da Fulia''');
SELECT inserir('Grupo', 'default, ''Grupo Da Matematica''');
SELECT * FROM Grupo;

-- CRIANDO INSTITUICAO
SELECT inserir('Instituicao', 'default, ''IFPI''');
SELECT inserir('Instituicao', 'default, ''Prefeitura de Teresina''');
SELECT * FROM Instituicao;

-- PARTICIPAR GRUPO
SELECT participar_grupo('10', '2');
SELECT participar_grupo('10', '4');
SELECT * FROM GrupoUsuario;