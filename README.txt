To run the application you need to install PostgreSQL (DB)
This is maven project so all needed libraries are set up automatically (using dependecy in the pom.xml)
The DB snapshot is attached, but you can create you own one, using these commands:

CREATE DATABASE customer
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'English_United States.1252'
       LC_CTYPE = 'English_United States.1252'
       CONNECTION LIMIT = -1;

And the table used:
CREATE TABLE users
(
  name_user character varying(255) NOT NULL,
  password_user character varying(255),
  CONSTRAINT users_pkey PRIMARY KEY ()
)
WITH (
  OIDS=FALSE
);
ALTER TABLE users
  OWNER TO postgres;

Password:
 name=postgres
 password = VeryVerySecret

The war file is attached, but you can generate your own one. (mvn clean, mvn install)
You can run the application through the tomcat, using war file or from the IDEA.

