CREATE DATABASE IF NOT EXISTS aspro;
USE aspro;

CREATE TABLE customers (
  customer_id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  cpf_cnpj VARCHAR(18) NOT NULL UNIQUE,
  phone BIGINT NOT NULL,
  email VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (customer_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE address (
  address_id INT NOT NULL AUTO_INCREMENT,
  zip_code BIGINT NOT NULL,
  street VARCHAR(45) NOT NULL,
  number SMALLINT DEFAULT NULL,
  neighborhood VARCHAR(45) NOT NULL,
  city VARCHAR(25) NOT NULL,
  complement VARCHAR(45) DEFAULT NULL,
  customer_id_FK INT NOT NULL,
  PRIMARY KEY (address_id),
  FOREIGN KEY (customer_id_FK) REFERENCES customers (customer_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE materials (
  material_id INT NOT NULL AUTO_INCREMENT,
  description VARCHAR(150) NOT NULL,
  type ENUM('S','P','U') NOT NULL COMMENT 'S = Service, P = Part, U = Consumable',
  unit CHAR(2) NOT NULL,
  purchase_price DECIMAL(10,2) NOT NULL,
  sale_price DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (material_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE orders (
  order_id INT NOT NULL AUTO_INCREMENT,
  vehicle_id_FK INT NOT NULL,
  customer_id_FK INT NOT NULL,
  status ENUM('P','A','R') NOT NULL COMMENT 'P = Pending, A = Approved, R = Rejected',
  total_price DECIMAL(10,2) NOT NULL,
  creation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (order_id),
  FOREIGN KEY (customer_id_FK) REFERENCES customers (customer_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE orders_materials (
  order_id INT NOT NULL,
  material_id INT NOT NULL,
  PRIMARY KEY (order_id, material_id),
  FOREIGN KEY (order_id) REFERENCES orders (order_id),
  FOREIGN KEY (material_id) REFERENCES materials (material_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

