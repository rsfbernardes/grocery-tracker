-- src/main/resources/db/migration/V1__create_products.sql
CREATE TABLE products (
                          id BIGSERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL UNIQUE,
                          category VARCHAR(255),
                          current_price DOUBLE PRECISION,
                          supermarket VARCHAR(255)
);

CREATE TABLE product_price_history (
                                       product_id BIGINT NOT NULL,
                                       date DATE NOT NULL,
                                       price DOUBLE PRECISION NOT NULL,
                                       CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES products(id)
);
