-- Enable UUID generation
CREATE EXTENSION IF NOT EXISTS "pgcrypto";

-- Products table
CREATE TABLE IF NOT EXISTS products
(
    id    UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name  VARCHAR(255) NOT NULL UNIQUE,
    brand VARCHAR(255),
    size  VARCHAR(64)
);

-- Purchases table
CREATE TABLE IF NOT EXISTS purchases
(
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    product_id  UUID             NOT NULL REFERENCES products (id) ON DELETE CASCADE,
    value       DOUBLE PRECISION NOT NULL,
    date        DATE             NOT NULL,
    supermarket VARCHAR(255)     NOT NULL
);

-- Indexes
CREATE INDEX IF NOT EXISTS idx_purchases_product_id ON purchases (product_id);
CREATE INDEX IF NOT EXISTS idx_purchases_date ON purchases (date);
CREATE INDEX IF NOT EXISTS idx_purchases_supermarket ON purchases (supermarket);
