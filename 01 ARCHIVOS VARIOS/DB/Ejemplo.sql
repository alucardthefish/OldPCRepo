-- Database: "Ejemplo"

-- DROP DATABASE "Ejemplo";

CREATE DATABASE "Ejemplo"
  WITH OWNER = sergio
       ENCODING = 'SQL_ASCII'
       TABLESPACE = pg_default;
CREATE TABLE usuario(
codigo VARCHAR(10), nombre VARCHAR(20));