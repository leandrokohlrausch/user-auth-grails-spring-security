CREATE DATABASE user-auth_test-db;

CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(255) NOT NULL,
  enabled boolean,
  account_expired boolean,
  account_locked boolean,
  password_expired boolean,
  email VARCHAR(50) NOT NULL,
  name VARCHAR(50) NOT NULL,
);

CREATE TABLE roles (
  id SERIAL PRIMARY KEY,
  authority VARCHAR(50) NOT NULL
);

CREATE TABLE users_roles (
  user_id INTEGER NOT NULL,
  role_id INTEGER NOT NULL,
  CONSTRAINT user_on_user_role_fkey FOREIGN KEY (user_id) REFERENCES users(id),
  CONSTRAINT role_on_user_role_fkey FOREIGN KEY (role_id) REFERENCES roles(id)
);

CREATE TABLE request_maps (
  id SERIAL PRIMARY KEY,
  url VARCHAR(100) NOT NULL,
  config_attribute VARCHAR (100) NOT NULL,
  http_method VARCHAR(10)
);
