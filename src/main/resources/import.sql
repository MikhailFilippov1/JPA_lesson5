DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigserial, title VARCHAR(255), price int, PRIMARY KEY (id));
INSERT INTO products (title, price) VALUES ('BREAD', 45), ('BUTTER', 245), ('MILK', 75), ('SALT', 5), ('PAPER', 545);

