CREATE TABLE IF NOT EXISTS products (
                                        id SERIAL PRIMARY KEY,
                                        name VARCHAR(255) NOT NULL UNIQUE,
                                        category VARCHAR(255),
                                        current_price DOUBLE PRECISION,
                                        supermarket VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS product_price_history (
                                                     id SERIAL PRIMARY KEY,
                                                     product_id BIGINT NOT NULL REFERENCES products(id) ON DELETE CASCADE,
                                                     price DOUBLE PRECISION NOT NULL,
                                                     date DATE NOT NULL
);
