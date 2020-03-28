CREATE DATABASE IF NOT EXISTS pms_api
  CHARACTER SET utf8
  COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS pms_api.claim_position_types (
    id INT AUTO_INCREMENT PRIMARY KEY,
    type_name VARCHAR(64) NOT NULL
);

CREATE TABLE IF NOT EXISTS pms_api.roles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    role_name VARCHAR(64) NOT NULL
);

CREATE TABLE IF NOT EXISTS pms_api.departments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    department_name VARCHAR(64) NOT NULL,
    responsible_user_id INT,

    INDEX ru_id (responsible_user_id)
);

CREATE TABLE IF NOT EXISTS pms_api.users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(64) NOT NULL,
    password VARCHAR(32) NOT NULL,
    department_id INT NOT NULL,
    role_id INT NOT NULL,
    full_name VARCHAR(200),

    INDEX rl_id (role_id),
    FOREIGN KEY (role_id)
        REFERENCES pms_api.roles(id),

    INDEX dp_id (department_id),
    FOREIGN KEY (department_id)
        REFERENCES pms_api.departments(id)
);

ALTER TABLE pms_api.departments ADD
        FOREIGN KEY (responsible_user_id)
        REFERENCES users(id);

CREATE TABLE IF NOT EXISTS pms_api.claims (
    id INT AUTO_INCREMENT PRIMARY KEY,
    creation_date DATE NOT NULL,
    user_id INT NOT NULL,

    INDEX us_id (user_id),
    FOREIGN KEY (user_id)
        REFERENCES pms_api.users(id)
);

CREATE TABLE IF NOT EXISTS pms_api.claim_positions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    comment TEXT,
    position_type_id INT NOT NULL,
    position_sum DECIMAL NOT NULL,

    INDEX pt_id (position_type_id),
    FOREIGN KEY (position_type_id)
        REFERENCES pms_api.claim_position_types(id)
);

ALTER TABLE pms_api.claim_positions ADD COLUMN claim_id INT NOT NULL;

ALTER TABLE pms_api.claim_positions ADD
        FOREIGN KEY (claim_id)
        REFERENCES claims(id);

CREATE TABLE IF NOT EXISTS pms_api.attachments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nested_file_name VARCHAR(256) NOT NULL,
    nested_file_path VARCHAR(512) NOT NULL,
    claim_position_id INT NOT NULL,

    INDEX att_id (claim_position_id),
    FOREIGN KEY (claim_position_id)
        REFERENCES pms_api.claim_positions(id)
);


