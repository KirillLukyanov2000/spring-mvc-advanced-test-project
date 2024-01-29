CREATE TABLE IF NOT EXISTS users
(
    id       BIGSERIAL PRIMARY KEY,
    login    VARCHAR(50),
    password VARCHAR(50)
);

INSERT INTO users(login, password)
VALUES ('Log1', 'Pass1');
INSERT INTO users(login, password)
VALUES ('Log2', 'Pass2');
INSERT INTO users(login, password)
VALUES ('Log3', 'Pass3');
INSERT INTO users(id, login, password)
VALUES (10, 'Log4', 'Pass4');