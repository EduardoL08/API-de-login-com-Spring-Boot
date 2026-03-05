create database banco_de_usuarios;

use banco_de_usuarios;
create table usuarios (
id integer auto_increment primary key,
nome varchar(50) not null,
email varchar(50) not null unique,
senha text not null,
telefone varchar(15) not null
);

INSERT INTO usuarios (nome, email, senha, telefone) VALUES 
('Eduardo Silva', 'eduardo@email.com', 'senha123', '11988887777'),
('Ana Beatriz', 'ana.beatriz@email.com', 'ana@2026', '11977776666'),
('Carlos Oliveira', 'carlos.oliveira@email.com', 'admin123', '21966665555'),
('Mariana Souza', 'mari.souza@email.com', 'mari#2025', '31955554444'),
('Ricardo Santos', 'ricardo.santos@email.com', 'root@pass', '41944443333'),
('Juliana Lima', 'juliana.lima@email.com', 'july@123', '51933332222'),
('Fernando Costa', 'fernando.costa@email.com', 'fefê99', '61922221111'),
('Patrícia Rocha', 'patricia.rocha@email.com', 'paty_secret', '71911110000'),
('Lucas Mendes', 'lucas.mendes@email.com', 'lucas@987', '81900009999'),
('Beatriz Gomes', 'beatriz.gomes@email.com', 'bea#gomes', '91999998888');

select * from usuarios;