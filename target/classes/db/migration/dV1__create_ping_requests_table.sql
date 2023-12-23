CREATE TABLE IF NOT EXISTS ping_requests (
    id SERIAL PRIMARY KEY,
    ip_address VARCHAR(255) NOT NULL,
    domain VARCHAR(255) NOT NULL,
    check_date TIMESTAMP,
    test_status INTEGER NOT NULL,
    ping_result TEXT
    );