-- liquibase formatted sql

-- changeset swann:1697895163781-1
CREATE TABLE inventory
(
    id       BINARY(16) NOT NULL,
    sku_code VARCHAR(255) NULL,
    quantity INT NULL,
    CONSTRAINT pk_inventory PRIMARY KEY (id)
);

