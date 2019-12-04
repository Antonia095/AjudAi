﻿﻿CREATE TABLE Usuario(
	Codigo SERIAL,
	NomeCompleto VARCHAR(200) NOT NULL,
    NomeUsuario VARCHAR(200) NOT NULL,
	DataNascimento DATE NOT NULL,
	Email VARCHAR(100) NOT NULL,
	Senha VARCHAR(100) NOT NULL,
	Ativo BOOLEAN DEFAULT TRUE NOT NULL,
	CONSTRAINT PK_Usuario PRIMARY KEY(Codigo)
);


CREATE TABLE Especialista(
	CodUsuario INTEGER,
	Descricao VARCHAR(500) NOT NULL,
	CONSTRAINT PK_Especialista PRIMARY KEY(CodUsuario),
	CONSTRAINT FK_Especialista FOREIGN KEY(CodUsuario) REFERENCES Usuario(Codigo)
		ON UPDATE CASCADE ON DELETE RESTRICT
);


CREATE TABLE AreaEspecialista(
	CodEspecialista INTEGER,
	Area VARCHAR(50),
	CONSTRAINT PK_AreaEspecialista PRIMARY KEY(CodEspecialista, Area),
	CONSTRAINT FK_AreaEspecialista FOREIGN KEY(CodEspecialista) REFERENCES Especialista(CodUsuario)
		ON UPDATE CASCADE ON DELETE RESTRICT
);


CREATE TABLE Administrador(
	Codigo INTEGER,
	NomeCompleto VARCHAR(200) NOT NULL,
	Email VARCHAR(100) NOT NULL,
	Senha VARCHAR(100) NOT NULL,
	DataInicio DATE NOT NULL,
	DataFim DATE NOT NULL,
	CONSTRAINT PK_Administrador PRIMARY KEY(Codigo)

);

CREATE TABLE Postagem(
	Id SERIAL,
	Area VARCHAR(50) NOT NULL,
	Descricao VARCHAR(500) NOT NULL,
	DataPostagem DATE NOT NULL,
	CodUsuario INTEGER,
	Denuncia INTEGER,
	CONSTRAINT PK_Postagem PRIMARY KEY(Id),
	CONSTRAINT FK_Postagem FOREIGN KEY(CodUsuario) REFERENCES Usuario(Codigo)
		ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE Comentario(
	Codigo SERIAL,
	IdPostagem INTEGER,
    Descricao VARCHAR(500) NOT NULL,
	DataComentario DATE NOT NULL,
	CodUsuario INTEGER NOT NULL,
    Denuncia INTEGER NOT NULL,
	CONSTRAINT PK_Comentario PRIMARY KEY(Codigo,IdPostagem),
	CONSTRAINT FK_Comentario FOREIGN KEY(IdPostagem) REFERENCES Postagem(Id)
		ON UPDATE CASCADE ON DELETE RESTRICT,
	CONSTRAINT FK_Usuario FOREIGN KEY(CodUsuario) REFERENCES Usuario(Codigo)
	        ON UPDATE CASCADE ON DELETE RESTRICT
);


CREATE TABLE Estante(
	Id SERIAL,
	DataCriacao DATE NOT NULL,
	CodUsuario INTEGER,
	CONSTRAINT PK_Estante PRIMARY KEY(Id),
	CONSTRAINT FK_Usuario FOREIGN KEY(CodUsuario) REFERENCES Usuario(Codigo)
		ON UPDATE CASCADE ON DELETE RESTRICT

);

CREATE TABLE Prateleira(
	Codigo SERIAL,
	IdEstante INTEGER,
	Descricao VARCHAR(500) NOT NULL,
	DataCriacao DATE NOT NULL,
	Tipo VARCHAR(50) NOT NULL,
	CONSTRAINT PK_Prateleira PRIMARY KEY(Codigo, IdEstante),
	CONSTRAINT FK_Prateleira FOREIGN KEY(IdEstante) REFERENCES Estante(Id)
		ON UPDATE CASCADE ON DELETE RESTRICT

);



CREATE TABLE Conteudo(
	Id SERIAL,
	Nome VARCHAR(100) NOT NULL,
	Local VARCHAR(100) NOT NULL,
	IdPostagem INTEGER,
	CONSTRAINT PK_Conteudo PRIMARY KEY(Id),
	CONSTRAINT FK_Postagem FOREIGN KEY(IdPostagem) REFERENCES Postagem(Id)
		ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE AvaliaConteudo(
	CodUsuario INTEGER,
	IdConteudo INTEGER,
	Nota INTEGER,
	CONSTRAINT PK_AvaliaConteudo PRIMARY KEY(CodUsuario, IdConteudo),
	CONSTRAINT FK1_AvaliaConteudo FOREIGN KEY(CodUsuario) REFERENCES Usuario(Codigo)
		ON UPDATE CASCADE ON DELETE RESTRICT,
	CONSTRAINT FK2_AvaliaConteudo FOREIGN KEY(IdConteudo) REFERENCES Conteudo(Id)
		ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE PrateleiraConteudo(
  CodPrateleira INTEGER,
  IdEstante INTEGER,
  CodConteudo INTEGER,
  CONSTRAINT PK_PrateleiraConteudo PRIMARY KEY(CodPrateleira, CodConteudo),
  CONSTRAINT FK1_PrateleiraConteudo FOREIGN KEY(CodPrateleira,IdEstante) REFERENCES Prateleira(Codigo,IdEstante)
		ON UPDATE CASCADE ON DELETE RESTRICT,
  CONSTRAINT FK2_PrateleiraConteudo FOREIGN KEY(CodConteudo) REFERENCES Conteudo(Id)
		ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE Alerta(
   Id SERIAL,
   Conteudo VARCHAR(1000),
   CodUsuario INTEGER,
   CONSTRAINT PK_Alerta PRIMARY KEY(Id),
   CONSTRAINT FK_Alerta FOREIGN KEY(CodUsuario) REFERENCES Usuario(Codigo)
		ON UPDATE CASCADE ON DELETE RESTRICT

)