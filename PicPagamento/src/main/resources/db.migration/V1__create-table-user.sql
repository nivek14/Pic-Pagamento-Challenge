CREATE TABLE comum (
    id INT PRIMARY KEY UNIQUE NOT NULL,
    nome varchar(255) NOT NULL,
    cpf varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    saldo FLOAT DEFAULT VALUE 0,
    tipo varchar(255) NOT NULL
);