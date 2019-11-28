﻿﻿CREATE TABLE Usuario(
	Codigo SERIAL,
	Nome VARCHAR(200) NOT NULL,
	DataNascimento DATE NOT NULL,
	Email VARCHAR(100) NOT NULL,
	Senha VARCHAR(100) NOT NULL,
	CONSTRAINT PK_Usuario PRIMARY KEY(Codigo)
);

CREATE TABLE TelefoneUsuario(
	CodUsuario INTEGER,
	Telefone VARCHAR(20),
	CONSTRAINT PK_TelefoneUsuario PRIMARY KEY(CodUsuario, Telefone),
	CONSTRAINT FK_TelegoneUsuario FOREIGN KEY(CodUsuario) REFERENCES Usuario(Codigo) 
		ON UPDATE CASCADE ON DELETE RESTRICT
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
	CodUsuario INTEGER,
	DataInicio DATE NOT NULL,
	DataFim DATE NOT NULL,
	CONSTRAINT PK_Administrador PRIMARY KEY(CodUsuario),
	CONSTRAINT FK_Administrador FOREIGN KEY(CodUsuario) REFERENCES Usuario(Codigo)
		ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE Postagem(
	Id SERIAL,
	Area VARCHAR(50) NOT NULL,
	Descricao VARCHAR(500) NOT NULL,
	DataPostagem DATE NOT NULL,
	CodUsuario INTEGER,
	CONSTRAINT PK_Postagem PRIMARY KEY(Id),
	CONSTRAINT FK_Postagem FOREIGN KEY(CodUsuario) REFERENCES Usuario(Codigo)
		ON UPDATE CASCADE ON DELETE RESTRICT
);


CREATE TABLE Comentario(
	Codigo SERIAL,
	IdPostagem INTEGER,
	DataComentario DATE NOT NULL,
	CONSTRAINT PK_Comentario PRIMARY KEY(Codigo,IdPostagem),
	CONSTRAINT FK_Comentario FOREIGN KEY(IdPostagem) REFERENCES Postagem(Id)
		ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE Estante(
	Id SERIAL,
	DataCriacao DATE NOT NULL,
	CodUsuario INTEGER,
	CONSTRAINT PK_Estante PRIMARY KEY(Id),
	CONSTRAINT FK_Estante FOREIGN KEY(CodUsuario) REFERENCES Usuario(Codigo)
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
	CONSTRAINT FK_Conteudo FOREIGN KEY(IdPostagem) REFERENCES Postagem(Id)
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






	
	