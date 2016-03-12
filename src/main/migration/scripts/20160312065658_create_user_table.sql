-- // create user table
-- Migration SQL that makes the change goes here.
CREATE TABLE users(
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL ,
  password VARCHAR(255) NOT NULL
);


-- //@UNDO
-- SQL to undo the change goes here.
DROP TABLE users;

