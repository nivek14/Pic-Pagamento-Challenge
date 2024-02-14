CREATE TABLE lojista (
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    nome TEXT NOT NULL,
    cpfOrCnpj TEXT NOT NULL,
    email TEXT NOT NULL,
    password TEXT NOT NULL,
    saldo FLOAT DEFAULT VALUE 0
);