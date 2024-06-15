## Projeto Locadora de Veículos - Documentação Oficial

**Introdução**

O projeto Locadora de Veículos consiste na implementação de um sistema de gerenciamento de locadora de veículos, utilizando Java e MySQL. O projeto permite a gestão de associados, veículos e preços de locação.

**Funcionalidades**

O sistema implementa as seguintes funcionalidades:

* **Cadastro de Associados:** Permite a criação de perfis de associados com informações como nome, telefone, e-mail e CPF.
* **Gerenciamento de Veículos:** Facilita a organização e o controle dos veículos disponíveis na locadora, incluindo cadastro, edição e exclusão de veículos com diversos atributos (marca, modelo, ano, placa, etc.).
* **Gerenciamento de Preços:** Permite a definição e atualização dos preços de locação por categoria de veículo.
* **Interface Intuitiva:** Prioriza a usabilidade e a navegação facilitada, através de um menu intuitivo, proporcionando uma experiência satisfatória aos usuários.

**Tecnologias Utilizadas**

O desenvolvimento do sistema Locadora de Veículos se baseou nas seguintes tecnologias:

* **GitHub Desktop:** Para versionamento de código.
* **Visual Studio Code:** Como editor de código.
* **MySQL:** Para gerenciamento do banco de dados.
* **LiveShare:** Extensão do Visual Studio Code para colaboração em tempo real.
* **Maven:** Como ferramenta de automação de build e gerenciamento de dependências.

**Demonstração**

Para visualizar uma demonstração do funcionamento do sistema Locadora de Veículos, acesse o seguinte link:

**Diferenciais do Projeto**

O projeto Locadora de Veículos se destaca por:

* **Abordagem Orientada a Objetos:** A adoção do paradigma OOP possibilita um código mais organizado, reutilizável e fácil de manter, além de promover a extensibilidade do sistema.
* **Foco na Usabilidade:** A interface intuitiva e o design agradável priorizam a experiência do usuário, facilitando a navegação e o acesso às funcionalidades do sistema.
* **Versatilidade:** A plataforma permite a criação e o gerenciamento de diversos tipos de veículos, atendendo a diferentes preferências e necessidades dos usuários.
* **Potencial de Expansão:** A arquitetura modular do sistema facilita a implementação de novas funcionalidades e a integração com recursos externos, como bancos de dados e interfaces gráficas.

**Estrutura do Banco de Dados**

### Criação do Banco de Dados e Tabelas

-- Criação do Banco de Dados
CREATE DATABASE locadoradeveiculos;
USE locadoradeveiculos;

-- Criação da Tabela Associado
CREATE TABLE Associado (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    telefone VARCHAR(15) NOT NULL,
    email VARCHAR(255) NOT NULL,
    cpf VARCHAR(15) NOT NULL
);

-- Criação da Tabela TabelaPrecos
CREATE TABLE TabelaPrecos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    categoria ENUM('Sedã', 'Picape', 'Hatch', 'Esportivo', 'SUV') NOT NULL UNIQUE,
    preco_por_dia DECIMAL(10, 2) NOT NULL
);

-- Criação da Tabela Veiculos
CREATE TABLE Veiculos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(255) NOT NULL,
    modelo VARCHAR(255) NOT NULL,
    ano INT NOT NULL,
    placa VARCHAR(10) NOT NULL,
    disponivel TINYINT(1) NOT NULL,
    categoria ENUM('Sedã', 'Picape', 'Hatch', 'Esportivo', 'SUV') NOT NULL,
    url_veiculo VARCHAR(500),
    preco DECIMAL(10, 2) NOT NULL,
    CONSTRAINT fk_categoria FOREIGN KEY (categoria) REFERENCES TabelaPrecos(categoria)
);

### Inserção de valores nas Tabelas

-- Inserção de Dados na Tabela TabelaPrecos
INSERT INTO TabelaPrecos (categoria, preco_por_dia) VALUES 
('Sedã', 10.00),
('Hatch', 15.00),
('Picape', 12.00),
('Esportivo', 20.00),
('SUV', 25.00);

-- Inserção de Dados na Tabela Veiculos
INSERT INTO Veiculos (marca, modelo, ano, placa, disponivel, categoria, url_veiculo, preco) VALUES 
('Toyota', 'Corolla', 2018, 'ABC1234', 1, 'Sedã', 'url1', 10.00),
('Chevrolet', 'S10', 2020, 'DEF5678', 1, 'Picape', 'url2', 12.00),
('Ford', 'Fiesta', 2015, 'GHI9101', 1, 'Hatch', 'url3', 15.00),
('BMW', 'X5', 2019, 'JKL2345', 1, 'SUV', 'url4', 25.00),
('Audi', 'A4', 2017, 'MNO6789', 1, 'Sedã', 'url5', 10.00),
('Volkswagen', 'Golf', 2016, 'PQR1122', 1, 'Hatch', 'url6', 15.00),
('Nissan', 'Frontier', 2018, 'STU3344', 1, 'Picape', 'url7', 12.00),
('Porsche', '911', 2021, 'VWX5566', 1, 'Esportivo', 'url8', 20.00),
('Mercedes', 'GLA', 2020, 'YZA7788', 1, 'SUV', 'url9', 25.00),
('Honda', 'Civic', 2019, 'BCD9900', 1, 'Sedã', 'url10', 10.00);

-- Inserção de Dados na Tabela Associado
INSERT INTO Associado (nome, telefone, email, cpf) VALUES 
('Yago Mendes', '123456789', 'yago.mendes@example.com', '32322332'),
('Vinicius Gonçalves', '987654321', 'vinicius.goncalves@example.com', '32321326'),
('Carlos Henrique', '456789123', 'carlos.henrique@example.com', '42320120'),
('Rafael Proença', '789123456', 'rafael.proenca@example.com', '42321742'),
('João Pedro', '321654987', 'joao.pedro@example.com', '42320831'),
('Gabriel Augusto', '654987321', 'gabriel.augusto@example.com', '42322170');

## Conclusão

O desenvolvimento do projeto Locadora de Veículos representou uma valiosa oportunidade para os alunos aplicarem e aprimorarem seus conhecimentos em Programação de Soluções Computacionais, além de desenvolverem habilidades essenciais para o mercado de trabalho, como trabalho em equipe, comunicação e gestão de tempo. A criação de um sistema de gerenciamento de locadora funcional e intuitivo evidenciou a capacidade dos alunos de solucionar problemas reais de forma criativa e eficiente, demonstrando sua aptidão para a área de desenvolvimento de software.

## Agradecimentos
Os alunos:
- Yago Mendes
- Vinicius Gonçalves
- Gabriel Augusto
- Carlos Henrique
- João Pedro
- Rafael Proença

Expressam seus sinceros agradecimentos aos professores Israel Severino Junior e Mark Alan Junho Song pela orientação, apoio e incentivo durante o desenvolvimento do projeto Locadora de Veículos.

## Contato
Para mais informações sobre o projeto Locadora de Veículos, os alunos se colocam à disposição para responder perguntas e esclarecer dúvidas através dos seguintes canais (GitHub / Linkedin):
- Yago Mendes
* https://github.com/DevMendes21
* LINKEDIN

- Vinicius Gonçalves
* https://github.com/vviniciws
* LINKEDIN

- Gabriel Augusto
* https://github.com/gabrielsaugusto
* LINKEDIN

- Carlos Henrique
* https://github.com/Carlos-Magalhaess
* LINKEDIN

- João Pedro
* https://github.com/JoaoPAlen
* LINKEDIN

- Rafael Proença
* https://github.com/FaelProenca
* LINKEDIN

## Observações Adicionais

A documentação oficial do projeto Locadora de Veículos estará disponível em breve nos repositórios GitHub dos alunos. Os alunos agradecem a oportunidade de compartilhar seu trabalho com a comunidade e esperam que o projeto Locadora de Veículos possa ser útil para outros estudantes e entusiastas de desenvolvimento de sistemas de gerenciamento.

Esperamos que este documento tenha apresentado o projeto Locadora de Veículos de forma clara e concisa. Agradecemos sua atenção!