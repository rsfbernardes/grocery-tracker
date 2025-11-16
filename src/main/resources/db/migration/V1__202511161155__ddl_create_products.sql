CREATE TABLE products
(
    id            BIGSERIAL PRIMARY KEY,
    name          VARCHAR(255) NOT NULL UNIQUE,
    category      VARCHAR(255),
    current_price DOUBLE PRECISION,
    supermarket   VARCHAR(255)
);

CREATE TABLE product_price_history
(
    product_id BIGINT           NOT NULL,
    date       DATE             NOT NULL,
    price      DOUBLE PRECISION NOT NULL,
    CONSTRAINT fk_product
        FOREIGN KEY (product_id)
            REFERENCES products (id)
            ON DELETE CASCADE
);

CREATE INDEX idx_product_price_history_product_id ON product_price_history (product_id);
CREATE INDEX idx_product_price_history_date ON product_price_history (date);
