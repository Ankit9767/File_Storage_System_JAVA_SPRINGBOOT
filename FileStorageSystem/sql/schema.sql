CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    enabled BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE files (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    filename VARCHAR(255) NOT NULL,
    filepath VARCHAR(255) NOT NULL,
    uploaded_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    file_version INT DEFAULT 1,
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE file_shares (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    file_id BIGINT,
    shared_with BIGINT,
    FOREIGN KEY (file_id) REFERENCES files(id),
    FOREIGN KEY (shared_with) REFERENCES users(id)
);
