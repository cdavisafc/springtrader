-- Run as POSTGRES/administrator user
-- Creates database an user

CREATE DATABASE IF NOT EXISTS nanotrader;

GRANT ALL PRIVILEGES ON nanotrader.* TO 'nanotrader'@'localhost' IDENTIFIED BY 'nanotrader';
