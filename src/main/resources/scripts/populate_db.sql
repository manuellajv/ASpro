USE aspro;

-- Inserindo clientes
INSERT INTO customers (customer_name, cpf_cnpj, phone, email) VALUES
('João Silva', '123.456.789-00', 11987654321, 'joao@email.com'),
('Maria Oliveira', '987.654.321-00', 21987654321, 'maria@email.com'),
('Carlos Souza', '321.654.987-00', 31987654321, 'carlos@email.com');

-- Inserindo veículos (com relação a clientes)
INSERT INTO vehicles (customer_id_FK, color, license_plate, brand_model) VALUES
(1, 'Preto', 'ABC-1234', 'Fusca 1979'),
(2, 'Vermelho', 'XYZ-4321', 'Gol 2015'),
(3, 'Azul', 'LMN-5678', 'Civic 2020');

-- Inserindo endereços (relacionados aos clientes)
INSERT INTO address (zip_code, street, addrNumber, district, city, complement, customer_id_FK) VALUES
(12345678, 'Rua das Flores', 100, 'Centro', 'São Paulo', 'Apto 101', 1),
(87654321, 'Av. Brasil', 200, 'Jardins', 'Rio de Janeiro', NULL, 2),
(56781234, 'Rua 7 de Setembro', 300, 'Bela Vista', 'Belo Horizonte', 'Bloco B', 3);

-- Inserindo materiais
INSERT INTO materials (material_desc, material_type, unit, purchase_price, sale_price) VALUES
('Óleo do motor', 'U', 'LT', 30.00, 50.00),
('Filtro de ar', 'P', 'UN', 25.00, 45.00),
('Troca de óleo', 'S', 'UN', 0.00, 100.00);

-- Inserindo orçamentos (relacionados aos veículos e clientes)
INSERT INTO orders (vehicle_id_FK, customer_id_FK, ord_status, total_price) VALUES
(1, 1, 'P', 150.00),  -- Orçamento para o veículo do João Silva
(2, 2, 'A', 200.00),  -- Orçamento para o veículo da Maria Oliveira
(3, 3, 'R', 120.00);  -- Orçamento para o veículo do Carlos Souza

-- Associando materiais aos orçamentos
INSERT INTO orders_materials (order_id, material_id) VALUES
(1, 1), -- Orçamento 1 (João Silva) inclui Óleo do motor
(1, 3), -- Orçamento 1 (João Silva) inclui Troca de óleo
(2, 2), -- Orçamento 2 (Maria Oliveira) inclui Filtro de ar
(3, 1); -- Orçamento 3 (Carlos Souza) inclui Óleo do motor
