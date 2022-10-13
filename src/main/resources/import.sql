DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigserial, title VARCHAR(255), price int, PRIMARY KEY (id));
INSERT INTO products (title, price) VALUES ('BREAD', 45), ('BUTTER', 245), ('MILK', 75), ('SALT', 5), ('PAPER', 545);

DROP TABLE clients IF EXISTS;
CREATE TABLE IF NOT EXISTS clients (id bigserial, name VARCHAR(255), PRIMARY KEY (id));
INSERT INTO clients (name) VALUES ('BOB'), ('BILL'), ('MARY');

DROP TABLE clients_products IF EXISTS;
CREATE TABLE clients_products (product_id bigint, client_id bigint, FOREIGN KEY (product_id) REFERENCES products(id), FOREIGN KEY (client_id) REFERENCES clients(id));
INSERT INTO clients_products VALUES (1,1), (2,1), (2,2), (2,3);
