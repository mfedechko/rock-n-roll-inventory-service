CREATE TABLE audit
(
    id      BIGSERIAL PRIMARY KEY,
    type    VARCHAR(256) NOT NULL,
    details TEXT,
    created TIMESTAMP DEFAULT NOW()
);

CREATE TABLE products
(
    id           BIGSERIAL PRIMARY KEY,
    name         VARCHAR(255)   NOT NULL,
    description  TEXT,
    quantity     INTEGER        NOT NULL,
    origin_price NUMERIC(12, 2) NOT NULL CHECK ( origin_price > 0 ),
    sale_price   NUMERIC(12, 2) NOT NULL CHECK ( sale_price > 0 ),
    categories   INTEGER[] DEFAULT '{}',
    created_at   TIMESTAMP DEFAULT NOW(),
    updated_at   TIMESTAMP
);

CREATE TABLE product_sales
(
    id         BIGSERIAL PRIMARY KEY,
    product_id BIGINT         NOT NULL REFERENCES products (id) ON DELETE CASCADE,
    user_id    BIGINT         NOT NULL,
    quantity   INTEGER        NOT NULL,
    price      NUMERIC(12, 2) NOT NULL,
    timestamp  TIMESTAMP DEFAULT NOW()
);