-- CRIANDO TABELAS
-- USUARIO
CREATE TABLE Usuario (
  id_usuario   SERIAL PRIMARY KEY NOT NULL,
  nome         VARCHAR(255)       NOT NULL,
  email        VARCHAR(255)       NOT NULL,
  data_entrada DATE               NOT NULL
);

-- GRUPO
CREATE TABLE Grupo (
  id_grupo SERIAL PRIMARY KEY NOT NULL,
  nome     VARCHAR(25)        NOT NULL
);

-- GRUPO USUARIO
CREATE TABLE GrupoUsuario (
  id_grupo_usuario SERIAL PRIMARY KEY NOT NULL,
  id_grupo         INT                NOT NULL REFERENCES Grupo (id_grupo),
  id_usuario       INT                NOT NULL REFERENCES Usuario (id_usuario)
);

-- PERIODO
CREATE TABLE Periodo (
  id_periodo     SERIAL PRIMARY KEY NOT NULL,
  periodo_inicio DATE               NOT NULL,
  periodo_fim    DATE               NOT NULL
);

-- INSTITUICAO
CREATE TABLE Instituicao (
  id_instituicao   SERIAL PRIMARY KEY NOT NULL,
  nome_instituicao VARCHAR(255)       NOT NULL
);

-- TIPO EVENTO
CREATE TABLE TipoEvento (
  id_tipo_evento        SERIAL PRIMARY KEY NOT NULL,
  descricao_tipo_evento VARCHAR(255)       NOT NULL
);

-- INSCRICAO NA ATIVIDADE
CREATE TABLE Inscricao (
  id_inscricao              SERIAL PRIMARY KEY NOT NULL,
  valor_inscricao           FLOAT              NOT NULL,
  data_vencimento_pagamento DATE               NOT NULL,
  status_pagamento          VARCHAR(255)       NOT NULL CHECK (status_pagamento = 'PAGO' OR
                                                               status_pagamento = 'ABERTO'),
  id_grupo                  INT                NOT NULL REFERENCES Grupo (id_grupo),
  valor_pago                FLOAT,
  data_pagamento            DATE,
  status_inscricao          VARCHAR(255)       NOT NULL CHECK (status_inscricao = 'ATIVA' OR
                                                               status_inscricao = 'CANCELADA' OR
                                                               status_inscricao = 'CONCLUIDA' OR
                                                               status_inscricao = 'VENCIDA')
);

-- EVENTO
CREATE TABLE Evento (
  id_evento          SERIAL PRIMARY KEY NOT NULL,
  nome_evento        VARCHAR(255)       NOT NULL,
  valor_total_evento FLOAT,
  data_criacao       DATE               NOT NULL,
  status_evento      VARCHAR(255)       NOT NULL CHECK (status_evento = 'EM_ANDAMENTO' OR
                                                        status_evento = 'INSCRICOES_ABERTAS' OR
                                                        status_evento = 'CONCLUIDO' OR
                                                        status_evento = 'CANCELADO'),
  id_usuario         INT                NOT NULL REFERENCES Usuario (id_usuario),
  id_tipo_evento     INT                NOT NULL REFERENCES TipoEvento (id_tipo_evento),
  periodo_evento     INT                NOT NULL REFERENCES Periodo (id_periodo)
);

-- ATIVIDADE
CREATE TABLE Atividade (
  id_atividade        SERIAL PRIMARY KEY NOT NULL,
  titulo_atividade    VARCHAR(25)        NOT NULL,
  descricao_atividade VARCHAR(255)       NOT NULL,
  quantidade_vagas    INT                NOT NULL,
  valor_atividade     FLOAT              NOT NULL,
  id_periodo          INT                NOT NULL REFERENCES Periodo (id_periodo),
  id_evento           INT                NOT NULL REFERENCES Evento (id_evento)
);

-- ITEM INSCRICAO
CREATE TABLE ItemInscricao (
  id_item_inscricao    SERIAL PRIMARY KEY NOT NULL,
  valor_item_inscricao FLOAT              NOT NULL,
  id_atividade         INT                NOT NULL REFERENCES Atividade (id_atividade),
  id_inscricao         INT                NOT NULL REFERENCES Inscricao (id_inscricao)
);

-- EVENTO INSTITUICAO
CREATE TABLE EventoInstituicao (
  id_evento_instituicao SERIAL PRIMARY KEY NOT NULL,
  id_evento             INT                NOT NULL REFERENCES Evento (id_evento),
  id_instituicao        INT                NOT NULL REFERENCES Instituicao (id_instituicao)
);


-- ==================================================================  CRIANDO FUNÇÕES  =====================================================================

-- INSERIR GENERICO
CREATE OR REPLACE FUNCTION inserir(tabela TEXT, valores TEXT) RETURNS VOID AS $inserir$
DECLARE query TEXT := 'INSERT INTO ' || tabela || ' VALUES (' || valores || ');';
BEGIN
  IF lower(tabela) = 'evento' THEN
    RAISE EXCEPTION 'Voce não pode Criar um evento por Aqui';
  END IF;
  IF lower(tabela) = 'inscricao' THEN
    RAISE EXCEPTION 'Voce não pode Realizar uma Inscricao por Aqui';
  END IF;
  EXECUTE query;
END;
$inserir$ LANGUAGE plpgsql;


-- REMOVE GENERICO
CREATE OR REPLACE FUNCTION remover(tabela TEXT, condicao TEXT) RETURNS VOID AS $remover$
DECLARE
  query TEXT := 'DELETE FROM ' || tabela || ' WHERE ' || condicao || ';';
BEGIN
  EXECUTE query;
END;
$remover$ LANGUAGE plpgsql;

-- UPDATE GENERICO
CREATE OR REPLACE FUNCTION atualizar_dados(tabela TEXT, condicao TEXT, novos_dados TEXT) RETURNS VOID AS $atualizar_dados$
DECLARE query TEXT := 'UPDATE ' || tabela || ' SET ' || novos_dados || ' WHERE ' || condicao;
BEGIN
  EXECUTE query;
END;
$atualizar_dados$ LANGUAGE plpgsql;

-- CRIANDO TABELA INSCRICAO => CONCLUIDO
CREATE OR REPLACE FUNCTION criar_inscricao(id_grupo INT) RETURNS VOID AS $criar_inscricao$
BEGIN
  --   data de vencimento pagamento sempre 30 dias depois da data atual
  INSERT INTO Inscricao VALUES (default, 0, current_date + INTERVAL '30 days', 'ABERTO', $1, NULL, NULL, 'ATIVA');
END;
$criar_inscricao$ LANGUAGE plpgsql;

-- CRIAR EVENTO => CONCLUIDO
CREATE OR REPLACE FUNCTION criar_evento(nome_evento TEXT, id_usuario_inscricao TEXT, id_tipo_evento TEXT, id_periodo_evento TEXT) RETURNS VOID AS $criar_evento$
DECLARE cadastro_evento TEXT :=
'insert into evento values (default, ''' || nome_evento || ''', 0, now(), ''INSCRICOES_ABERTAS'',' || id_usuario_inscricao || ', ' || id_tipo_evento || ', ' || id_periodo_evento || ');';
BEGIN
  IF nome_evento = '' THEN
    RAISE EXCEPTION 'Nome Evento não Informado';
  END IF;
  IF id_usuario_inscricao = '' THEN
    RAISE EXCEPTION 'Usuario não Informado';
  END IF;
  IF id_tipo_evento = '' THEN
    RAISE EXCEPTION 'Tipo Evento não Informado';
  END IF;
  IF id_periodo_evento = '' THEN
    RAISE EXCEPTION 'Periodo não Informado';
  END IF;
  EXECUTE cadastro_evento;
END;
$criar_evento$ LANGUAGE plpgsql;

-- PARTICIPAR GRUPO => CONCLUIDO
CREATE OR REPLACE FUNCTION participar_grupo(id_grupo_participar TEXT, id_usuario_participar TEXT) RETURNS VOID AS $participar_grupo$
DECLARE
  criar_grupo_usuairo TEXT :=
  'insert into GrupoUsuario values(DEFAULT, ' || id_grupo_participar || ',' || id_usuario_participar || ' )';
BEGIN
  EXECUTE criar_grupo_usuairo;
END;
$participar_grupo$ LANGUAGE plpgsql;

-- INSCRICAO EM EVENTO, VOCE GANHA UM DESCONTO DE 5% SE INSCREVENDO EM UM EVENTO COMPLETO => CONCLUIDO
CREATE OR REPLACE FUNCTION inscricao_completa(id_grupo TEXT, id_evento_inscricao TEXT) RETURNS VOID AS $inscricao_completa$
DECLARE
  criar_inscricao  TEXT := 'select criar_inscricao(' || ($1) || ')';
  i                INTEGER;
  valor_atividades FLOAT := 0;
BEGIN
  EXECUTE criar_inscricao;
  IF(SELECT COUNT(*) FROM Atividade WHERE id_evento = CAST(id_evento_inscricao AS INTEGER)) = 0 THEN
    RAISE EXCEPTION 'O EVENTO INFORMADO NAO POSSUI ATIVIDADES';
  END IF;
  FOR i IN (SELECT id_atividade FROM Atividade WHERE id_evento = cast(id_evento_inscricao AS INT)) LOOP
    INSERT INTO ItemInscricao VALUES (DEFAULT, (SELECT valor_atividade FROM atividade WHERE id_atividade = i),
                                      (SELECT id_atividade FROM atividade WHERE id_atividade = i),
                                      (SELECT max(id_inscricao) FROM Inscricao));
    valor_atividades := valor_atividades + (SELECT valor_atividade FROM atividade WHERE Atividade.id_atividade = i);
    UPDATE Atividade SET quantidade_vagas = ((SELECT quantidade_vagas FROM atividade WHERE id_atividade = i) - 1) WHERE id_atividade = i;
  END LOOP;
  CREATE OR REPLACE VIEW id_insc AS SELECT max(id_inscricao) FROM Inscricao;
  UPDATE Inscricao SET valor_inscricao = valor_atividades - (valor_atividades * 0.05) WHERE id_inscricao IN (SELECT * FROM id_insc);
END;
$inscricao_completa$ LANGUAGE plpgsql;

-- INSCRICAO POR ATIVIDADE => CONCLUIDO
CREATE OR REPLACE FUNCTION inscricao_por_atividade(id_grupo_inscricao TEXT, id_atividade_inscricao TEXT) RETURNS VOID AS $inscricao_por_atividade$
DECLARE
  id_atividade_insc    INT := id_atividade_inscricao;
  criar_inscricao      TEXT := 'select criar_inscricao(' || id_grupo_inscricao || ')';
  criar_item_inscricao TEXT :=
  'insert into ItemInscricao values (default, (select valor_atividade from atividade where id_atividade = ' ||
  id_atividade_inscricao || '), ' || id_atividade_inscricao || ', (select max(id_inscricao) from inscricao));';
  quantidade_vagas     TEXT :=
  'update Atividade set quantidade_vagas = ( (select quantidade_vagas from atividade where id_atividade = ' ||
  id_atividade_inscricao || ') - 1) where id_atividade = ' || id_atividade_inscricao || ';';
BEGIN
  EXECUTE criar_inscricao;
  EXECUTE criar_item_inscricao;
  EXECUTE quantidade_vagas;
  UPDATE Inscricao
  SET valor_inscricao = (SELECT valor_atividade FROM Atividade WHERE id_atividade = id_atividade_insc) WHERE id_inscricao IN (SELECT max(id_inscricao) FROM Inscricao);
END;
$inscricao_por_atividade$ LANGUAGE plpgsql;

-- ASSOCIAR EVENTO A UMA INSTITUICAO => CONCLUIDO
CREATE OR REPLACE FUNCTION associar_evento_instituicao(id_evento_associar TEXT, id_instituicao_associar TEXT) RETURNS VOID AS $associar_evento_instituicao$
DECLARE
  criar_instituicao_evento TEXT := 'insert into EventoInstituicao values (default, ' || id_evento_associar || ', ' || id_instituicao_associar || ')';
BEGIN
  EXECUTE criar_instituicao_evento;
END;
$associar_evento_instituicao$ LANGUAGE plpgsql;

-- APLICANDO DESCONTOS NA INSCRICAO
CREATE OR REPLACE FUNCTION aplicar_desconto(id_inscricao_desconto TEXT) RETURNS VOID AS $aplicar_desconto$
DECLARE
  inscricao_desconto_10 TEXT :=
  'update Inscricao set valor_inscricao = (select valor_inscricao from Inscricao where id_inscricao = ' ||
  id_inscricao_desconto || ') - ((select valor_inscricao from Inscricao where id_inscricao = ' || id_inscricao_desconto
  || ') * 0.10) where id_inscricao = ' || id_inscricao_desconto || ';';
  inscricao_desconto_20 TEXT :=
  'update Inscricao set valor_inscricao = (select valor_inscricao from Inscricao where id_inscricao = ' ||
  id_inscricao_desconto || ') - ((select valor_inscricao from Inscricao where id_inscricao = ' || id_inscricao_desconto
  || ') * 0.20) where id_inscricao = ' || id_inscricao_desconto || ';';
BEGIN
  IF (SELECT status_pagamento FROM inscricao WHERE id_inscricao = cast(id_inscricao_desconto AS INTEGER)) = 'PAGO' THEN
    RAISE EXCEPTION 'Não se pode Aplicar desconto em uma Inscrição que ja Foi Paga';
  END IF;
  IF (SELECT count(*) FROM GrupoUsuario WHERE id_grupo IN (SELECT id_grupo FROM Inscricao WHERE id_inscricao = cast(id_inscricao_desconto AS INT))) BETWEEN 10 AND 19 THEN
    EXECUTE inscricao_desconto_10;
  END IF;
  IF (SELECT count(*) FROM GrupoUsuario WHERE id_grupo IN (SELECT id_grupo FROM Inscricao WHERE id_inscricao = cast(id_inscricao_desconto AS INT))) >= 20 THEN
    EXECUTE inscricao_desconto_20;
  END IF;
  RAISE NOTICE 'Desconto Aplicado';
END;
$aplicar_desconto$ LANGUAGE plpgsql;

-- FUNCAO PAGAR INSCRICAO => CONCLUIDO
CREATE OR REPLACE FUNCTION pagar_inscricao(id_inscricao_pagamento TEXT, valor_pagar TEXT) RETURNS VOID AS $pagar_inscricao$
DECLARE
  pagar_inscricao TEXT := 'UPDATE Inscricao SET status_pagamento = ''PAGO'' WHERE id_inscricao = ' ||
                          id_inscricao_pagamento;
  valor_pago      TEXT := 'UPDATE Inscricao SET valor_pago = ' || valor_pagar || ' WHERE id_inscricao = ' ||
                          id_inscricao_pagamento;
  data_pagamento  TEXT := 'UPDATE Inscricao SET data_pagamento = current_date WHERE id_inscricao = ' ||
                          id_inscricao_pagamento;
BEGIN
  IF (SELECT data_vencimento_pagamento FROM Inscricao WHERE Inscricao.id_inscricao = cast(id_inscricao_pagamento AS INTEGER)) < current_date THEN
    RAISE EXCEPTION 'A Periodo de Pagamento da sua Inscricao ja Venceu, Realize uma Nova Incrição';
  END IF;
  IF (SELECT valor_inscricao FROM Inscricao WHERE Inscricao.id_inscricao = cast(id_inscricao_pagamento AS INTEGER)) != cast(valor_pagar AS DOUBLE PRECISION) THEN
    RAISE EXCEPTION 'O Valor Informado é Diferente do Valor da Inscrição';
  END IF;
  IF (SELECT valor_inscricao FROM Inscricao WHERE Inscricao.id_inscricao = cast(id_inscricao_pagamento AS INTEGER)) = cast(valor_pagar AS DOUBLE PRECISION) THEN
    EXECUTE pagar_inscricao;
    EXECUTE valor_pago;
    EXECUTE data_pagamento;
    RAISE INFO 'Inscrição Paga';
  END IF;
END;
$pagar_inscricao$ LANGUAGE plpgsql;

-- CANCELAR INSCRICAO => CONCLUIDO
CREATE OR REPLACE FUNCTION cancelar_inscricao(id_inscricao_cancelar TEXT) RETURNS VOID AS $cancelar_inscricao$
DECLARE
  cancelar_inscricao      TEXT := 'update Inscricao set status_inscricao = ''CANCELADA'' where id_inscricao = ' || id_inscricao_cancelar;
BEGIN
  IF(cast(id_inscricao_cancelar as INTEGER) not in (SELECT id_inscricao from Inscricao))THEN
    RAISE EXCEPTION 'A inscricao informada não existe';
  END IF;
  IF (SELECT status_pagamento FROM Inscricao WHERE id_inscricao = cast(id_inscricao_cancelar AS INTEGER)) = 'PAGO' THEN
    RAISE EXCEPTION 'A Inscrição ja foi paga, não pode ser Cancelada';
  END IF;
  IF (SELECT status_inscricao FROM Inscricao WHERE id_inscricao = cast(id_inscricao_cancelar AS INTEGER)) = 'CANCELADA' THEN
    RAISE EXCEPTION 'A sua Inscrição ja esta cancelada';
  END IF;
  IF (SELECT status_inscricao FROM Inscricao WHERE id_inscricao = cast(id_inscricao_cancelar AS INTEGER)) = 'CONCLUIDA' THEN
    RAISE EXCEPTION 'A sua Inscrição não esta Aberta, ja foi Cancelada ou Concluida';
  END IF;
  EXECUTE cancelar_inscricao;
END;
$cancelar_inscricao$ LANGUAGE plpgsql;

-- FUNCAO PARA CONCLUIR INSCRICAO => CONCLUIDO
CREATE OR REPLACE FUNCTION concluir_inscricao(id_inscricao_concluir TEXT) RETURNS VOID AS $concluir_inscricao$
DECLARE
  concluir_inscricao TEXT := 'update Inscricao set status_inscricao = ''CONCLUIDA'' WHERE ID_INSCRICAO = ' || id_inscricao_concluir;
BEGIN
  IF (SELECT status_pagamento FROM Inscricao WHERE id_inscricao = cast(id_inscricao_concluir AS INTEGER)) = 'PAGO' THEN
    RAISE EXCEPTION 'Sua Inscrição não foi Paga, Pague sua Inscricao';
  END IF;
  IF (SELECT status_inscricao FROM Inscricao WHERE id_inscricao = cast(id_inscricao_concluir AS INTEGER)) = 'CANCELADA' OR 'CONCLUIDA' THEN
    RAISE EXCEPTION 'A sua Inscrição não esta Aberta, ja foi Cancelada ou Concluida';
  END IF;
  EXECUTE concluir_inscricao;
END;
$concluir_inscricao$ LANGUAGE plpgsql;


-- ========================================================================  CRIANDO TRIGGERS  ====================================================================

-- VALIDANDO CADASTRO USUARIO => CONCLUIDO
CREATE OR REPLACE FUNCTION validar_cadastro_usuario() RETURNS TRIGGER AS $validar_cadastro_usuario$
BEGIN
  IF new.email IN (SELECT email FROM usuario) THEN
    RAISE EXCEPTION 'O Email Cadastrado ja Esta Em Uso';
  END IF;
  RETURN new;
END;
$validar_cadastro_usuario$ LANGUAGE plpgsql;
CREATE TRIGGER trigger_cadastro_usuario BEFORE INSERT ON Usuario FOR EACH ROW EXECUTE PROCEDURE validar_cadastro_usuario();

-- VALIDANDO CADASTRO ATIVIDADE => CONCLUIDO
CREATE OR REPLACE FUNCTION validar_cadastro_atividade() RETURNS TRIGGER AS $validar_cadastro_atividade$
BEGIN
  IF(NEW.id_periodo IN (SELECT id_periodo FROM Atividade INNER JOIN Evento E ON Atividade.id_evento = E.id_evento WHERE E.id_evento = NEW.id_evento))THEN
    RAISE EXCEPTION 'JA EXISTE UMA ATIVIDADE NESSE HORARIO PARA ESSE EVENTO';
  END IF;
  IF new.id_evento NOT IN (SELECT id_evento FROM Evento) THEN
    RAISE EXCEPTION 'A Evento Informado não esta Cadastrado';
  END IF;
  IF new.id_evento NOT IN (SELECT id_evento FROM EventoInstituicao) THEN
    RAISE EXCEPTION 'O Evento Informado não possui Uma Instituicao Associada, Portanto Atividades estão Insdiponiveis Temporariamente';
  END IF;

  IF new.id_periodo NOT IN (SELECT id_periodo FROM Periodo) THEN
    RAISE EXCEPTION 'O Periodo Informado não esta Cadastrado';
  END IF;
  IF new.valor_atividade < 0 THEN
    RAISE EXCEPTION 'O valor da Atividade não pode ser Inferior ou igual a Zero';
  END IF;
  IF new.quantidade_vagas < 0 THEN
    RAISE EXCEPTION 'O Numero de Vagas Informado é Invalido';
  END IF;
  IF new.titulo_atividade IN (SELECT descricao_atividade FROM Atividade) THEN
    RAISE EXCEPTION 'A Atividade Ja foi Cadastrada';
  END IF;
  UPDATE Evento SET valor_total_evento = ((SELECT valor_total_evento FROM Evento WHERE id_evento = new.id_evento) + new.valor_atividade) WHERE id_evento = new.id_evento;
  RETURN new;
END;
$validar_cadastro_atividade$ LANGUAGE plpgsql;
CREATE TRIGGER trigger_cadastro_atividade BEFORE INSERT ON Atividade FOR EACH ROW EXECUTE PROCEDURE validar_cadastro_atividade();

-- VALIDANDO CADASTRO GRUPO => CONCLUIDO
CREATE OR REPLACE FUNCTION validar_cadastro_grupo() RETURNS TRIGGER AS $validar_cadastro_grupo$
BEGIN
  IF new.nome IN (SELECT nome FROM grupo) THEN
    RAISE EXCEPTION 'Esse Nome de Grupo ja foi Cadastrado';
  END IF;
  RETURN new;
END;
$validar_cadastro_grupo$ LANGUAGE plpgsql;
CREATE TRIGGER trigger_cadastro_grupo BEFORE INSERT ON Grupo FOR EACH ROW EXECUTE PROCEDURE validar_cadastro_grupo();

-- VALIDANDO PERIODO => CONCLUIDO
CREATE OR REPLACE FUNCTION validar_periodo() RETURNS TRIGGER AS $validar_periodo$
BEGIN
  IF new.periodo_fim < new.periodo_inicio THEN
    RAISE EXCEPTION 'A data de Inicio é Anterior a Data de Fim';
  END IF;
  IF new.periodo_inicio < current_date THEN
    RAISE EXCEPTION 'A data de Inicio é Anterior a Data Atual';
  END IF;
  IF new.periodo_fim < current_date THEN
    RAISE EXCEPTION 'A data de Fim é Anterior a Data Atual';
  END IF;
  RETURN new;
END;
$validar_periodo$ LANGUAGE plpgsql;
CREATE TRIGGER trigger_cadastro_periodo BEFORE INSERT ON Periodo FOR EACH ROW EXECUTE PROCEDURE validar_periodo();

-- VALIDANDO EVENTO => CONCLUIDO
CREATE OR REPLACE FUNCTION validar_cadastro_evento() RETURNS TRIGGER AS $validar_cadastro_evento$
BEGIN
  IF new.id_tipo_evento NOT IN (SELECT id_tipo_evento FROM TipoEvento) THEN
    RAISE EXCEPTION 'O TipoEvento Informdado não foi Cadastrado';
  END IF;
  IF new.periodo_evento NOT IN (SELECT id_periodo FROM Periodo) THEN
    RAISE EXCEPTION 'O Periodo Informdado não foi Cadastrado';
  END IF;
  IF new.id_usuario NOT IN (SELECT id_usuario FROM Usuario) THEN
    RAISE EXCEPTION 'O Usuario Informdado não foi Cadastrado';
  END IF;
  IF new.nome_evento IN (SELECT nome_evento FROM Evento) THEN
    RAISE EXCEPTION 'Esse nome de Evento ja foi Cadastrado';
  END IF;
  RETURN new;
END;
$validar_cadastro_evento$ LANGUAGE plpgsql;
CREATE TRIGGER trigger_cadastro_evento BEFORE INSERT ON Evento FOR EACH ROW EXECUTE PROCEDURE validar_cadastro_evento();

-- VALIDANDO INSTITUIÇÕES => CONCLUIDO
CREATE OR REPLACE FUNCTION validar_cadastro_instituicao()
  RETURNS TRIGGER AS $validar_cadastro_instituicao$
BEGIN
  IF new.nome_instituicao IN (SELECT nome_instituicao FROM Instituicao) THEN
    RAISE EXCEPTION 'Esse nome de Instituicao ja foi Cadastrado';
  END IF;
  RETURN new;
END;
$validar_cadastro_instituicao$ LANGUAGE plpgsql;
CREATE TRIGGER trigger_cadastro_instituicao BEFORE INSERT ON Instituicao FOR EACH ROW EXECUTE PROCEDURE validar_cadastro_instituicao();

SELECT * FROM Inscricao;
-- VALIDANDO INSCRICAO EVENTO => CONCLUIDO
CREATE OR REPLACE FUNCTION validar_cadastro_inscricao_evento() RETURNS TRIGGER AS $validar_cadastro_inscricao_evento$
BEGIN
  IF(NEW.ID_GRUPO NOT IN (SELECT id_grupo FROM GrupoUsuario))THEN
    RAISE EXCEPTION 'O GRUPO NAO POSSUI NENHUM USUARIO';
  END IF;
  IF (new.id_grupo NOT IN (SELECT id_grupo FROM Grupo)) THEN
    RAISE EXCEPTION 'O grupo Informado não foi Cadastrado';
  END IF;
  IF new.data_vencimento_pagamento < current_date THEN
    RAISE EXCEPTION 'A data De Criação não pode ser Inferior a Data Atual';
  END IF;
  RETURN new;
END;
$validar_cadastro_inscricao_evento$ LANGUAGE plpgsql;
CREATE TRIGGER trigger_cadastro_inscricao BEFORE INSERT ON Inscricao FOR EACH ROW EXECUTE PROCEDURE validar_cadastro_inscricao_evento();

SELECT * FROM ItemInscricao;
-- VALIDADANDO CADASTRO ITEM INSCRICAO => CONCLUIDO
CREATE OR REPLACE FUNCTION validar_cadastro_item_inscricao() RETURNS TRIGGER AS $validar_cadastro_item_inscricao$
BEGIN
  IF(SELECT status_evento FROM ItemInscricao
    INNER JOIN Inscricao I ON ItemInscricao.id_inscricao = I.id_inscricao
    INNER JOIN Atividade A ON ItemInscricao.id_atividade = A.id_atividade
    INNER JOIN Evento E ON A.id_evento = E.id_evento
  WHERE A.id_atividade = NEW.id_atividade) NOT ILIKE 'INSCRICOES_ABERTAS' THEN
    RAISE EXCEPTION 'O PERIODO DAS INSCRIÇÕES JA ENCERROU';
  END IF;
  IF new.id_inscricao NOT IN (SELECT id_inscricao FROM Inscricao) THEN
    RAISE EXCEPTION 'A Inscricao Informada não foi Cadastrada';
  END IF;
  IF new.id_atividade NOT IN (SELECT id_atividade FROM Atividade) THEN
    RAISE EXCEPTION 'A Atividade Informada não foi Cadastrada';
  END IF;
  IF new.id_atividade IN (SELECT id_atividade FROM iteminscricao) THEN
    RAISE EXCEPTION 'Você Já se Inscreveu nessa Atividade';
  END IF;
  IF (SELECT quantidade_vagas FROM Atividade WHERE id_atividade = new.id_atividade) = 0 THEN
    DELETE FROM Inscricao WHERE id_inscricao IN (SELECT max(id_inscricao) FROM inscricao);
    RAISE EXCEPTION 'A Atividade não Possui Vagas Em Aberto';
  END IF;
  IF new.id_atividade NOT IN (SELECT Atividade.id_atividade FROM Atividade) THEN
    RAISE EXCEPTION 'A Atividade Informada não foi Cadastrada';
  END IF;
  RETURN new;
END;
$validar_cadastro_item_inscricao$ LANGUAGE plpgsql;
CREATE TRIGGER trigger_cadastro_item_inscricao BEFORE INSERT ON ItemInscricao FOR EACH ROW EXECUTE PROCEDURE validar_cadastro_item_inscricao();

-- VALIDAR CADASTRO INSTITUIÇÃO => CONCLUIDO
CREATE OR REPLACE FUNCTION validar_cadastro_evento_instituicao() RETURNS TRIGGER AS $validar_cadastro_evento_instituicao$
BEGIN
  IF NEW.ID_EVENTO IN (SELECT ID_EVENTO FROM EventoInstituicao WHERE id_instituicao = NEW.ID_INSTITUICAO)THEN
    RAISE EXCEPTION 'ESSE EVENTO JA ESTA ASSOCIADO A ESSA INSTITUICAO';
  END IF;
  IF new.id_evento NOT IN (SELECT id_evento FROM Evento) THEN
    RAISE EXCEPTION 'O Evento Informado não foi Cadastrado';
  END IF;
  IF new.id_instituicao NOT IN (SELECT id_instituicao FROM Instituicao) THEN
    RAISE EXCEPTION 'A Instituicao Informada não foi Cadastrada';
  END IF;
  RETURN new;
END;
$validar_cadastro_evento_instituicao$ LANGUAGE plpgsql;
CREATE TRIGGER trigger_cadastro_evento_instituicao BEFORE INSERT ON EventoInstituicao FOR EACH ROW EXECUTE PROCEDURE validar_cadastro_evento_instituicao();
-- DROP TRIGGER trigger_cadastro_evento_instituicao ON EventoInstituicao;

-- VALIDAR CADASTRO GRUPO => CONCLUIDO
CREATE OR REPLACE FUNCTION validar_cadastro_grupo_usuario() RETURNS TRIGGER AS $validar_cadastro_grupo_usuario$
BEGIN
  IF new.id_grupo NOT IN (SELECT id_grupo FROM Grupo) THEN
    RAISE EXCEPTION 'O grupo Informado não foi Cadastrado';
  END IF;
  IF new.id_usuario NOT IN (SELECT id_usuario FROM Usuario) THEN
    RAISE EXCEPTION 'O Usuario Informado não foi Cadastrado';
  END IF;
  RETURN new;
END;
$validar_cadastro_grupo_usuario$ LANGUAGE plpgsql;
CREATE TRIGGER trigger_cadastro_grupo_usuario BEFORE INSERT ON GrupoUsuario FOR EACH ROW EXECUTE PROCEDURE validar_cadastro_grupo_usuario();
-- DROP TRIGGER trigger_cadastro_grupo_usuario ON GrupoUsuario;


-- VALIDAR TIPO EVENTO
CREATE OR REPLACE FUNCTION validar_cadastro_tipo_evento() RETURNS TRIGGER AS $$
BEGIN
  IF(NEW.descricao_tipo_evento IN (SELECT descricao_tipo_evento FROM TipoEvento))THEN
    RAISE EXCEPTION 'A DESCRICAO INFORMADA JA FOI CADASTRADA';
  END IF;
  RETURN NEW;
END;
$$ LANGUAGE plpgsql;
CREATE TRIGGER trigger_cadastro_tipo_evento BEFORE INSERT ON TipoEvento FOR EACH ROW EXECUTE PROCEDURE validar_cadastro_tipo_evento();


CREATE OR REPLACE FUNCTION verificar_delete() RETURNS TRIGGER AS $$
BEGIN

  IF(tg_table_name = 'instituicao') THEN
    IF(OLD.ID_INSTITUICAO IN (SELECT Instituicao.ID_INSTITUICAO FROM Instituicao
      INNER JOIN EventoInstituicao E ON Instituicao.id_instituicao = E.id_instituicao
      INNER JOIN Evento E2 ON E.id_evento = E2.id_evento WHERE status_evento = 'EM_ANDAMENTO'))THEN
      RAISE EXCEPTION 'VOCE NAO PODE DELETAR INSTITUICAO COM UM EVENTO EM ANDAMENTO';
    END IF;
    DELETE FROM EventoInstituicao WHERE id_instituicao = OLD.id_instituicao;
  END IF;

  IF(tg_table_name = 'evento')THEN
    IF 'PAGA' IN (SELECT status_inscricao FROM Inscricao
      INNER JOIN ItemInscricao I2 ON Inscricao.id_inscricao = I2.id_inscricao
      INNER JOIN Atividade A ON I2.id_atividade = A.id_atividade
      INNER JOIN Evento E3 ON A.id_evento = E3.id_evento) THEN
        RAISE EXCEPTION 'VOCE NAO PODE EXCLUIR O EVENTO, POIS ELE JA POSSUI INSCRICOES PAGAS';
    END IF;
    IF(SELECT status_evento FROM Evento WHERE id_evento = OLD.ID_EVENTO) = 'EM_ANDAMENTO' THEN
      RAISE EXCEPTION 'VOCE NAO PODE EXCLUIR UM EVENTO EM ANDAMENTO';
    END IF;
    UPDATE Atividade SET id_evento = 0 WHERE id_evento = OLD.ID_EVENTO;
    DELETE FROM EventoInstituicao WHERE id_evento = OLD.ID_EVENTO;
  END IF;

  IF(tg_table_name = 'grupo')THEN
    DELETE FROM ItemInscricao WHERE id_inscricao IN (SELECT id_inscricao FROM Inscricao WHERE id_grupo = OLD.ID_GRUPO);
    DELETE FROM Inscricao WHERE id_grupo = old.ID_GRUPO;
    DELETE FROM GrupoUsuario WHERE id_grupo = OLD.ID_GRUPO;
  END IF;

  IF(tg_table_name = 'inscricao') THEN
    IF OLD.ID_INSCRICAO IN (SELECT Inscricao.id_inscricao FROM Inscricao
      INNER JOIN ItemInscricao Inscricao2 ON Inscricao.id_inscricao = Inscricao2.id_inscricao
      INNER JOIN Atividade A2 ON Inscricao2.id_atividade = A2.id_atividade
      INNER JOIN Evento E4 ON A2.id_evento = E4.id_evento WHERE status_evento = 'EM_ANDAMENTO') THEN
        RAISE EXCEPTION 'A INSCRICAO NAO PODE SER EXCLUIDA, PERTENCE A UM EVENTO EM ANDAMENTO';
    END IF;

    IF OLD.ID_INSCRICAO IN (SELECT Inscricao.id_inscricao FROM Inscricao
      INNER JOIN ItemInscricao Inscricao2 ON Inscricao.id_inscricao = Inscricao2.id_inscricao
      INNER JOIN Atividade A2 ON Inscricao2.id_atividade = A2.id_atividade
      INNER JOIN Evento E4 ON A2.id_evento = E4.id_evento WHERE status_inscricao = 'PAGA') THEN
        RAISE EXCEPTION 'A INSCRICAO NAO PODE SER EXCLUIDA, POIS JA ESTA PAGA';
    END IF;
    DELETE FROM ItemInscricao WHERE id_inscricao = OLD.ID_INSCRICAO;
  END IF;
  IF(tg_table_name = 'usuario') THEN
    IF(OLD.ID_USUARIO IN (SELECT id_usuario FROM Evento WHERE status_evento = 'EM_ANDAMENTO'))THEN
       RAISE EXCEPTION 'VOCE NAO PODE DELETAR ESSE USUARIO, O EVENTO QUE ELE CRIOU ESTA EM ANDAMENTO';
    END IF;
    UPDATE Evento SET id_usuario = 0 WHERE id_usuario = old.ID_USUARIO;
    DELETE FROM GrupoUsuario WHERE id_usuario = OLD.ID_USUARIO;
  END IF;
  IF(tg_table_name = 'tipoevento') THEN
    IF OLD.ID_TIPO_EVENTO IN (SELECT id_tipo_evento FROM Evento WHERE status_evento = 'EM_ANDAMENTO')THEN
      RAISE EXCEPTION 'VOCE NAO PODE EXCLUIR UM TIPO ASSOCIADO A UM EVENTO EM ANDAMENTO';
    END IF;
    UPDATE Evento SET id_tipo_evento = 0 WHERE id_tipo_evento = OLD.ID_TIPO_EVENTO;
  END IF;
  RETURN OLD;
END;
$$ LANGUAGE plpgsql;
CREATE TRIGGER trigger_on_delete BEFORE DELETE on Instituicao FOR EACH ROW EXECUTE PROCEDURE verificar_delete();
CREATE TRIGGER trigger_on_delete BEFORE DELETE on Evento FOR EACH ROW EXECUTE PROCEDURE verificar_delete();
CREATE TRIGGER trigger_on_delete BEFORE DELETE on Grupo FOR EACH ROW EXECUTE PROCEDURE verificar_delete();
CREATE TRIGGER trigger_on_delete BEFORE DELETE on Inscricao FOR EACH ROW EXECUTE PROCEDURE verificar_delete();
CREATE TRIGGER trigger_on_delete BEFORE DELETE on Usuario FOR EACH ROW EXECUTE PROCEDURE verificar_delete();
CREATE TRIGGER trigger_on_delete BEFORE DELETE on TipoEvento FOR EACH ROW EXECUTE PROCEDURE verificar_delete();

select * from Inscricao INNER JOIN ItemInscricao I2 ON Inscricao.id_inscricao = I2.id_inscricao;
SELECT * from Evento;
select * from EventoInstituicao;


select remover('evento', 'id_EVENTO = 4');
select remover('GRUPO', 'ID_GRUPO = 2');
SELECT * FROM Instituicao;
SELECT * FROM Atividade;
SELECT * FROM Grupo;
DELETE FROM Instituicao WHERE id_instituicao = 2;

-- CRIANDO TRIGGER PERMISSAO USER
CREATE OR REPLACE FUNCTION permissao_user() RETURNS TRIGGER AS $$
DECLARE
  usuario TEXT;
BEGIN
    SELECT USER INTO usuario;
    IF usuario NOT LIKE 'USUARIO_GRUPO' AND usuario NOT LIKE 'postgres' THEN
      RAISE EXCEPTION 'O USUARIO NAO TEM PERMISSAO PARA ALTERAÇÃO DE DADOS';
    END IF;
  RETURN NEW;
END;
$$ LANGUAGE plpgsql;


CREATE TRIGGER trigger_user BEFORE INSERT OR DELETE ON Inscricao EXECUTE PROCEDURE permissao_user();
CREATE TRIGGER trigger_user BEFORE INSERT OR DELETE ON Evento EXECUTE PROCEDURE permissao_user();
CREATE TRIGGER trigger_user BEFORE INSERT OR DELETE ON ItemInscricao EXECUTE PROCEDURE permissao_user();
CREATE TRIGGER trigger_user BEFORE INSERT OR DELETE ON Periodo EXECUTE PROCEDURE permissao_user();
CREATE TRIGGER trigger_user BEFORE INSERT OR DELETE on Instituicao EXECUTE PROCEDURE permissao_user();
CREATE TRIGGER trigger_user BEFORE INSERT OR DELETE ON TipoEvento EXECUTE PROCEDURE permissao_user();

CREATE OR REPLACE FUNCTION CRIAR_TABELAS_DELETE() RETURNS VOID AS $$
BEGIN
  INSERT INTO Usuario VALUES (0, '', '', NOW());
  INSERT INTO Grupo VALUES (0,'');
  INSERT INTO Instituicao VALUES (0, '');
  INSERT INTO Periodo VALUES (0, NOW(), NOW());
  INSERT INTO TipoEvento VALUES (0,'');
  INSERT INTO Evento VALUES (0, '', 1, NOW(), 'CANCELADO', 0, 0, 0);
  INSERT  INTO EventoInstituicao VALUES (0,0,0);
  INSERT INTO Atividade VALUES (0, '', '', 1, 1, 0, 0);
END;
$$ LANGUAGE plpgsql;

-- ============================================================   POPULAR BANCO DE DADOS  ===============================================================
CREATE USER USUARIO_GRUPO WITH PASSWORD '123';

SELECT CRIAR_TABELAS_DELETE();

-- CRIANDO USUARIO
SELECT inserir('Usuario', ('default, ''Kassio Lucas de Holanda'', ''kassioholandaleodido@gmail.com'', current_date'));
SELECT inserir('Usuario', ('default, ''Kaio Lucas de Holanda'', ''kaioluks@gmail.com'', current_date'));
-- SELECT atualizar_dados('Usuario', 'id_usuario = 4', ' nome= ''Kassio Lucas de Holanda Leodido'' ');
-- SELECT remover('usuario', 'id_usuario = 8');
SELECT * from Usuario;

-- CRIANDO GRUPO
SELECT inserir('Grupo', 'default, ''Grupo Da Fulia''');
SELECT inserir('Grupo', 'default, ''Grupo Dos Estudos''');
SELECT inserir('Grupo', 'default, ''Grupo Gamer''');
SELECT * FROM Grupo;

-- CRIANDO INSTITUICAO
SELECT inserir('Instituicao', 'default, ''IFPI''');
SELECT inserir('Instituicao', 'default, ''Prefeitura de Teresina''');
SELECT * FROM Instituicao;

-- CRIANDO TIPO EVENTO
SELECT inserir('TipoEvento', 'default, ''Palestras'' ');
SELECT inserir('TipoEvento', 'default, ''Mini Cursos'' ');
SELECT * FROM TipoEvento;

-- CRIANDO PERIODO
SELECT inserir('Periodo', 'default, current_date, current_date + INTERVAL ''20 days'' ');
SELECT inserir('Periodo', 'default, current_date + INTERVAL ''2 days'' , current_date + INTERVAL ''15 days'' ');
SELECT * FROM Periodo;

-- CRIANDO EVENTO
-- INFORMAR NOME EVENTO, ID USUARIO, ID TIPO EVENTO, ID PERIRODO
SELECT criar_evento('Casa dos Estudos', '1', '1', '1');
SELECT criar_evento('GAMERS', '2', '2', '2');
SELECT * from Evento;


-- ASSOCIAR EVENTO INSTITUICAO
-- INFORMAR ID_EVENTO E ID_INSTITUICAO
SELECT associar_evento_instituicao('2', '1');
SELECT associar_evento_instituicao('3', '2');
SELECT * from EventoInstituicao;


-- CRIANDO ATIVIDADE
SELECT inserir('Atividade', 'default, ''Aprendendo a Bater Falta'', ''Nessa Atividade você Aprendera a Bater Falta no FIFA'', 15, 35.50, 1, 2');
SELECT inserir('Atividade', 'default, ''Matematica - Matrizes'', ''Nessa Atividade você Aprendera um Pouco Sobre Matrizes'', 15, 35.50, 2, 3');
SELECT inserir('Atividade', 'default, ''Geografia - Planiceis'', ''Nessa Atividade você Aprendera um Pouco Sobre Planicies'', 31, 35.50, 2, 3');
SELECT inserir('Atividade', 'default, ''The Last Of Us'', ''Nessa Atividade você Aprendera tudo Sobre The Last Of Us, um dos melhores jogos de todos os tempos'', 25, 100.50, 2, 2');
SELECT inserir('Atividade', 'default, ''Matematica - Matrizes'', ''Nessa Atividade você Aprendera um Pouco Sobre Matrizes'', 15, 35.50, 2, 1000'); -- EVENTO NAO EXISTE
SELECT * FROM Atividade;
SELECT * FROM Evento;

-- PARTICIPAR GRUPO
-- INFORMAR ID_GRUPO E ID_USUARIO
SELECT participar_grupo('1', '2');
SELECT participar_grupo('2', '1');
SELECT * FROM Usuario;
SELECT * FROM GrupoUsuario;

-- INSCRICAO POR EVENTO
-- INFORMAR ID_GRUPO E ID_EVENTO
SELECT inscricao_completa('2', '3');
SELECT * FROM Inscricao;
SELECT * FROM ItemInscricao;
SELECT * FROM Evento INNER JOIN Atividade A ON Evento.id_evento = A.id_evento;
SELECT * FROM Grupo;
SELECT * from Atividade where id_evento = 3;


-- INSCRICAO POR ATIVIDADE
-- INFORMAR ID_GRUPO E ID_ATIVIDADE
SELECT inscricao_por_atividade('2', '3');
-- SELECT inscricao_por_atividade('1', '4');
SELECT * FROM Atividade;


-- APLICANDO DESCONTOS
-- INFOROMAR ID_INCRICAO
SELECT aplicar_desconto('9');
SELECT * FROM Inscricao;

-- PAGAR INSCRICAO
-- INFORMAR ID_INSCRICAO E VALOR A PAGAR
SELECT pagar_inscricao('9', '100.5');


-- CANCELAR INSCRICAO
-- INFORMAR ID_INSCRICAO PARA CANCELAR
SELECT cancelar_inscricao('8');
SELECT cancelar_inscricao('5211');
