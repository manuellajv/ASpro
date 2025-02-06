SET foreign_key_checks = 0;
SET SQL_SAFE_UPDATES = 0;

DELETE FROM `mydb`.`orcamentos_has_materiais`;
DELETE FROM `mydb`.`transacoes`;
DELETE FROM `mydb`.`endereco`;
DELETE FROM `mydb`.`veiculos`;
DELETE FROM `mydb`.`orcamentos`;
DELETE FROM `mydb`.`materiais`;
DELETE FROM `mydb`.`clientes`;

SET foreign_key_checks = 1;
SET SQL_SAFE_UPDATES = 1;

INSERT INTO `mydb`.`materiais` (`descricao`, `tipo`, `unidade_medida`, `preco_compra`, `preco_venda`) 
VALUES
('Servico de pintura', 'S', 'UN', 150.00, 200.00),
('Peça de suspensão', 'P', 'UN', 50.00, 75.00),
('Óleo de motor', 'U', 'L', 10.00, 15.00),
('Filtro de ar', 'P', 'UN', 25.00, 35.00),
('Servico de alinhamento', 'S', 'UN', 120.00, 150.00),
('Pastilha de freio', 'P', 'UN', 30.00, 45.00),
('Servico de troca de óleo', 'S', 'UN', 100.00, 130.00),
('Lâmpada de farol', 'P', 'UN', 15.00, 20.00),
('Cinta de amarração', 'U', 'UN', 5.00, 7.00),
('Servico de balanceamento', 'S', 'UN', 80.00, 100.00);

INSERT INTO `mydb`.`clientes` (`nome`, `cpf_cnpj`, `telefone`, `email`) 
VALUES
('Carlos Silva', '123.456.789-00', 11987654321, 'carlos@email.com'),
('Maria Oliveira', '987.654.321-00', 11876543210, 'maria@email.com'),
('João Souza', '456.789.123-00', 11765432109, 'joao@email.com'),
('Ana Santos', '321.654.987-00', 11654321098, 'ana@email.com'),
('Roberto Lima', '159.753.486-00', 11543210987, 'roberto@email.com'),
('Fernanda Costa', '753.159.246-00', 11432109876, 'fernanda@email.com'),
('Paulo Pereira', '963.852.741-00', 11321098765, 'paulo@email.com'),
('Luciana Gomes', '741.258.963-00', 11210987654, 'luciana@email.com'),
('Carlos Eduardo', '258.147.369-00', 11109876543, 'carlosedu@email.com'),
('Julia Almeida', '147.258.369-00', 11098765432, 'julia@email.com');

INSERT INTO `mydb`.`endereco` (`cep`, `rua`, `numero`, `bairro`, `cidade`, `complemento`, `id_cliente_FK`) 
VALUES
(11010001, 'Rua A', 100, 'Centro', 'São Paulo', 'Apto 101', 52),
(11010002, 'Rua B', 200, 'Bairro B', 'São Paulo', 'Apto 202', 53),
(11010003, 'Rua C', 300, 'Bairro C', 'São Paulo', 'Casa', 54),
(11010004, 'Rua D', 400, 'Bairro D', 'São Paulo', 'Apto 303', 55),
(11010005, 'Rua E', 500, 'Bairro E', 'São Paulo', 'Casa', 56),
(11010006, 'Rua F', 600, 'Bairro F', 'São Paulo', 'Apto 404', 57),
(11010007, 'Rua G', 700, 'Bairro G', 'São Paulo', 'Apto 505', 58),
(11010008, 'Rua H', 800, 'Bairro H', 'São Paulo', 'Casa', 59),
(11010009, 'Rua I', 900, 'Bairro I', 'São Paulo', 'Apto 606', 60),
(11010010, 'Rua J', 1000, 'Bairro J', 'São Paulo', 'Casa', 61);

-- Inserir dados na tabela 'veiculos'
INSERT INTO `mydb`.`veiculos` (`cor`, `placa`, `marca_modelo`) 
VALUES
('Preto', 'ABC1234', 'Fusca 1972'),
('Branco', 'DEF5678', 'Gol 2004'),
('Azul', 'GHI9012', 'Civic 2015'),
('Vermelho', 'JKL3456', 'Corolla 2018'),
('Prata', 'MNO7890', 'Fiesta 2012'),
('Cinza', 'PQR2345', 'Celta 2010'),
('Verde', 'STU6789', 'Kombi 2000'),
('Amarelo', 'VWX0123', 'Onix 2019'),
('Laranja', 'YZA4567', 'Palio 2017'),
('Roxo', 'BCD8901', 'HB20 2020');

-- Inserir dados na tabela 'orcamentos'
INSERT INTO `mydb`.`orcamentos` (`id_veiculo_FK`, `id_cliente_FK`, `status`, `preco_total`) 
VALUES
(11, 52, 'P', 1500.00),
(12, 53, 'A', 2000.00),
(13, 54, 'R', 500.00),
(14, 55, 'P', 1200.00),
(15, 56, 'A', 1800.00),
(16, 57, 'R', 450.00),
(17, 58, 'P', 1100.00),
(18, 59, 'A', 1900.00),
(19, 60, 'R', 600.00),
(20, 61, 'P', 1400.00);

-- Inserir dados na tabela 'transacoes'
INSERT INTO `mydb`.`transacoes` (`tipo`, `qtd_material`, `id_material_FK`, `id_orcamento_FK`) 
VALUES
('V', 2.0, 61, 11),
('E', 3.0, 62, 12),
('S', 1.0, 63, 13),
('V', 4.0, 64, 14),
('E', 2.5, 65, 15),
('S', 5.0, 66, 16),
('V', 3.0, 67, 17),
('E', 4.0, 68, 18),
('S', 2.0, 69, 19),
('V', 5.0, 70, 20);

-- Inserir dados na tabela 'orcamentos_has_materiais'
INSERT INTO `mydb`.`orcamentos_has_materiais` (`id_orcamento`, `id_material`) 
VALUES
(11, 61),
(12, 62),
(13, 63),
(14, 64),
(15, 65),
(16, 66),
(17, 67),
(18, 68),
(19, 69),
(20, 70);