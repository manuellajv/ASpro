USE aspro;

-- Inserindo clientes
INSERT INTO customers (name, cpf_cnpj, phone, email) VALUES
('João Silva', '123.456.789-00', 11987654321, 'joao@email.com'),
('Maria Oliveira', '987.654.321-00', 21987654321, 'maria@email.com'),
('Carlos Souza', '321.654.987-00', 31987654321, 'carlos@email.com');

-- Inserindo endereços
INSERT INTO address (zip_code, street, number, district, city, complement, customer_id_FK) VALUES
(12345678, 'Rua das Flores', 100, 'Centro', 'São Paulo', 'Apto 101', 1),
(87654321, 'Av. Brasil', 200, 'Jardins', 'Rio de Janeiro', NULL, 2),
(56781234, 'Rua 7 de Setembro', 300, 'Bela Vista', 'Belo Horizonte', 'Bloco B', 3);

-- Inserindo materiais
INSERT INTO materials (description, type, unit, purchase_price, sale_price) VALUES
('Óleo do motor', 'U', 'LT', 30.00, 50.00),
('Filtro de ar', 'P', 'UN', 25.00, 45.00),
('Troca de óleo', 'S', 'UN', 0.00, 100.00);

-- Inserindo orçamentos
INSERT INTO orders (vehicle_id_FK, customer_id_FK, status, total_price) VALUES
(1, 1, 'P', 150.00),
(2, 2, 'A', 200.00),
(3, 3, 'R', 120.00);

-- Associando materiais aos orçamentos
INSERT INTO orders_materials (order_id, material_id) VALUES
(1, 1), -- Orçamento 1 inclui Óleo do motor
(1, 3), -- Orçamento 1 inclui Troca de óleo
(2, 2), -- Orçamento 2 inclui Filtro de ar
(3, 1); -- Orçamento 3 inclui Óleo do motor
