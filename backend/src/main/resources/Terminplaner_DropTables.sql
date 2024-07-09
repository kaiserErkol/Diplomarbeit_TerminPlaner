-- Dropping tables if they exist in the correct order to handle foreign key dependencies
DROP TABLE IF EXISTS wartungsverlauf;
DROP TABLE IF EXISTS benachrichtigung;
DROP TABLE IF EXISTS fahrzeug;
DROP TABLE IF EXISTS termin;
DROP TABLE IF EXISTS kostenvorschlag;
DROP TABLE IF EXISTS mechaniker;
DROP TABLE IF EXISTS terminvorschlag;
DROP TABLE IF EXISTS verleihauto;
DROP TABLE IF EXISTS verwalter;
DROP TABLE IF EXISTS service;
DROP TABLE IF EXISTS kunde;

-- Dropping sequences if they exist
DROP SEQUENCE IF EXISTS benachrichtigung_id_seq;
DROP SEQUENCE IF EXISTS kostenvorschlag_id_seq;
DROP SEQUENCE IF EXISTS kunde_id_seq;
DROP SEQUENCE IF EXISTS mechaniker_id_seq;
DROP SEQUENCE IF EXISTS service_id_seq;
DROP SEQUENCE IF EXISTS termin_id_seq;
DROP SEQUENCE IF EXISTS terminvorschlag_id_seq;
DROP SEQUENCE IF EXISTS verwalter_id_seq;
DROP SEQUENCE IF EXISTS wartungsverlauf_id_seq;