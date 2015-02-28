DROP TABLE customer
IF EXISTS CASCADE;
DROP TABLE order
IF EXISTS CASCADE;

CREATE TABLE customer (
	customer_id BIGINT IDENTITY,
	customer_firstname VARCHAR(100),
	customer_lastname VARCHAR(100)
);
 
CREATE TABLE order (
	order_id BIGINT IDENTITY,
	customer_id BIGINT,
	amount DOUBLE,
	FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
);

CREATE TABLE configuration (
	config_id BIGINT IDENTITY,
	config_key VARCHAR(255) NOT NULL,
	config_value VARCHAR(255),
	create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);