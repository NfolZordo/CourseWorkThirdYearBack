create TABLE _user (
  id INTEGER NOT NULL,
   firstname VARCHAR(255),
   lastname VARCHAR(255),
   email VARCHAR(255),
   password VARCHAR(255),
   role VARCHAR(255),
   CONSTRAINT pk__user PRIMARY KEY (id)
);

CREATE TABLE token (
  id INTEGER NOT NULL,
   token VARCHAR(255),
   token_type VARCHAR(255),
   revoked BOOLEAN NOT NULL,
   expired BOOLEAN NOT NULL,
   user_id INTEGER,
   CONSTRAINT pk_token PRIMARY KEY (id)
);

ALTER TABLE token ADD CONSTRAINT uc_token_token UNIQUE (token);

ALTER TABLE token ADD CONSTRAINT FK_TOKEN_ON_USER FOREIGN KEY (user_id) REFERENCES _user (id);

DROP TABLE logs CASCADE;

DROP TABLE test_l CASCADE;

DROP TABLE tickets CASCADE;

DROP TABLE tickets3 CASCADE;

DROP TABLE visitors CASCADE;

DROP TABLE visitors2 CASCADE;

DROP TABLE visitors3 CASCADE;

DROP SEQUENCE user_seq CASCADE;