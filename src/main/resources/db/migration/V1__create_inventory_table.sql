CREATE SCHEMA IF NOT EXISTS inventory_service;

CREATE TABLE IF NOT EXISTS inventory_service.inventory (
    id SERIAL PRIMARY KEY,
    sku_code VARCHAR(255),
    quantity INTEGER
);

INSERT into inventory_service.inventory (sku_code, quantity)
VALUES ('iphone_15', 100),
       ('samsung_f34_5g', 100),
       ('nokia_3310', 100),
       ('redmi_note_16', 100);