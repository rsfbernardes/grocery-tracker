CREATE TABLE IF NOT EXISTS products
(
    id     BIGSERIAL PRIMARY KEY,
    name   VARCHAR(255) NOT NULL UNIQUE,
    brand  VARCHAR(255),
    weight VARCHAR(64)
);

CREATE TABLE IF NOT EXISTS purchases
(
    id          BIGSERIAL PRIMARY KEY,
    product_id  BIGINT           NOT NULL REFERENCES products (id) ON DELETE CASCADE,
    value       DOUBLE PRECISION NOT NULL,
    date        DATE             NOT NULL,
    supermarket VARCHAR(255)     NOT NULL
);

CREATE INDEX IF NOT EXISTS idx_purchases_product_id ON purchases (product_id);
CREATE INDEX IF NOT EXISTS idx_purchases_date ON purchases (date);
CREATE INDEX IF NOT EXISTS idx_purchases_supermarket ON purchases (supermarket);
