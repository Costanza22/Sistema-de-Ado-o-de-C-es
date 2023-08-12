CREATE DATABASE canil;

USE canil;

CREATE TABLE IF NOT EXISTS caes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    raca VARCHAR(100),
    nome VARCHAR(100),
    coleira VARCHAR(100)
    racao BOOLEAN(100)
    vacina BOOLEAN(100)
);

CREATE TABLE racoes (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(255) NOT NULL,
  marca VARCHAR(255) NOT NULL,
  descricao VARCHAR(255) NOT NULL,
  preco DECIMAL(10, 2) NOT NULL
);
CREATE TABLE vacinas (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(255) NOT NULL,
  descricao VARCHAR(255) NOT NULL
);
CREATE TABLE Adocao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    adotanteNome VARCHAR(100) NOT NULL,
    adotanteEmail VARCHAR(100) NOT NULL,
    adotanteTelefone VARCHAR(20) NOT NULL,
    adotanteEndereco VARCHAR(100) NOT NULL,
    porte VARCHAR(20) NOT NULL,
    caoId INT NOT NULL,
    FOREIGN KEY (caoId) REFERENCES Caes(id)
);

INSERT INTO Caes (nome, raca, coleira, racao, porte) VALUES ('Rex', 'Labrador', 'C123', 'Ração A', 'Grande');
INSERT INTO Caes (nome, raca, coleira, racao, porte) VALUES ('Luna', 'Golden Retriever', 'G456', 'Ração B', 'Médio');


CREATE TABLE adotante (
  id INT AUTO_INCREMENT PRIMARY KEY,
  cao_id INT,
  adotante_nome VARCHAR(255) NOT NULL,
  adotante_email VARCHAR(255),
  adotante_telefone VARCHAR(20),
  adotante_endereco VARCHAR(255),
  data_adocao DATE,
  FOREIGN KEY (cao_id) REFERENCES caes(id)
);

-- Tabela para armazenar informações das entregas
CREATE TABLE Entrega (
  id INT PRIMARY KEY,
  cao_id INT,
  data_entrega DATE,
  FOREIGN KEY (cao_id) REFERENCES Cao(id)
);
