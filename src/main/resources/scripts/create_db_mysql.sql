CREATE DATABASE IF NOT EXISTS aspro;
USE aspro;

CREATE TABLE customers (
  customer_id INT NOT NULL AUTO_INCREMENT,
  customer_name VARCHAR(100) NOT NULL,
  cpf_cnpj VARCHAR(18) NOT NULL UNIQUE,
  phone BIGINT NOT NULL,
  email VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (customer_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE vehicles (
  vehicle_id INT NOT NULL AUTO_INCREMENT,
  customer_id_FK INT NOT NULL,  -- Relacionamento com clientes
  color VARCHAR(100) NOT NULL,
  license_plate CHAR(8) NOT NULL,
  brand_model VARCHAR(25) NOT NULL,
  PRIMARY KEY (vehicle_id),
  UNIQUE KEY placa_UNIQUE (license_plate),
  FOREIGN KEY (customer_id_FK) REFERENCES customers (customer_id)  -- Relacionamento com a tabela customers
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE address (
  address_id INT NOT NULL AUTO_INCREMENT,
  zip_code BIGINT NOT NULL,
  street VARCHAR(45) NOT NULL,
  addrNumber SMALLINT DEFAULT NULL,
  district VARCHAR(45) NOT NULL,
  city VARCHAR(25) NOT NULL,
  complement VARCHAR(45) DEFAULT NULL,
  customer_id_FK INT NOT NULL,
  PRIMARY KEY (address_id),
  FOREIGN KEY (customer_id_FK) REFERENCES customers (customer_id)  -- Relacionamento com a tabela customers
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE materials (
  material_id INT NOT NULL AUTO_INCREMENT,
  material_desc VARCHAR(150) NOT NULL,
  material_type ENUM('S','P','U') NOT NULL COMMENT 'S = Service, P = Part, U = Consumable',
  unit CHAR(2) NOT NULL,
  purchase_price DECIMAL(10,2) NOT NULL,
  sale_price DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (material_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE orders (
  order_id INT NOT NULL AUTO_INCREMENT,
  vehicle_id_FK INT NOT NULL,  -- Correção do nome da coluna
  customer_id_FK INT NOT NULL,
  ord_status ENUM('P','A','R') NOT NULL COMMENT 'P = Pending, A = Approved, R = Rejected',
  total_price DECIMAL(10,2) NOT NULL,
  creation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (order_id),
  FOREIGN KEY (vehicle_id_FK) REFERENCES vehicles (vehicle_id),  -- Correção do nome da coluna
  FOREIGN KEY (customer_id_FK) REFERENCES customers (customer_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE transactions (
  transaction_id INT NOT NULL AUTO_INCREMENT,
  trs_type ENUM('V','E','S') NOT NULL COMMENT 'S = Sale, E = Stock Entry, S = Stock Exit',
  material_qty DECIMAL(5,2) DEFAULT NULL,
  material_id_FK INT DEFAULT NULL,
  quote_id_FK INT DEFAULT NULL,
  PRIMARY KEY (transaction_id),
  KEY `fk_transacoes_materiais1_idx` (`material_id_FK`),
  KEY `fk_transacoes_orcamentos1_idx` (`quote_id_FK`),
  CONSTRAINT `fk_transacoes_materiais` FOREIGN KEY (material_id_FK) REFERENCES materials (material_id),
  CONSTRAINT `fk_transacoes_orcamentos1` FOREIGN KEY (quote_id_FK) REFERENCES quotes (quote_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE orders_materials (
  order_id INT NOT NULL,
  material_id INT NOT NULL,
  PRIMARY KEY (order_id, material_id),
  FOREIGN KEY (order_id) REFERENCES orders (order_id),
  FOREIGN KEY (material_id) REFERENCES materials (material_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
