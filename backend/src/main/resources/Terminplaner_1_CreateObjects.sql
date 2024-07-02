CREATE TABLE benachrichtigung (
    benachrichtigung_id INT NOT NULL,
    nachricht           VARCHAR(250),
    datum               DATE,
    kunde_kunde_id      INT NOT NULL,
    CONSTRAINT benachrichtigung_pk PRIMARY KEY (benachrichtigung_id)
);

CREATE TABLE fahrzeug (
    fahrzeug_id    INT NOT NULL,
    marke          VARCHAR(250),
    modell         VARCHAR(250),
    baujahr        DATE,
    kennzeichen    VARCHAR(250),
    kunde_kunde_id INT NOT NULL,
    CONSTRAINT fahrzeug_pk PRIMARY KEY (fahrzeug_id)
);

CREATE TABLE kunde (
    kunde_id      INT NOT NULL,
    vorname       VARCHAR(250),
    nachname      VARCHAR(250),
    email         VARCHAR(250),
    telefonnummer VARCHAR(250),
    adresse       VARCHAR(250),
    CONSTRAINT kunde_pk PRIMARY KEY (kunde_id)
);

CREATE TABLE mitarbeiter (
    mitarbeiter_id INT NOT NULL,
    vorname        VARCHAR(250),
    nachname       VARCHAR(250),
    email          VARCHAR(250),
    telefonnummer  VARCHAR(250),
    CONSTRAINT mitarbeiter_pk PRIMARY KEY (mitarbeiter_id)
);

CREATE TABLE service (
    service_id       INT NOT NULL,
    bezeichnung      VARCHAR(250),
    beschreibung     VARCHAR(250),
    dauerinstunden   INT,
    kosten           DECIMAL(10, 2),
    serviceintervall INT,
    CONSTRAINT service_pk PRIMARY KEY (service_id)
);

CREATE TABLE termin (
    termin_id                  INT NOT NULL,
    datum                      DATE,
    uhrzeit                    TIME,
    status                     VARCHAR(250),
    notizen                    VARCHAR(250),
    kunde_kunde_id             INT NOT NULL,
    mitarbeiter_mitarbeiter_id INT NOT NULL,
    CONSTRAINT termin_pk PRIMARY KEY (termin_id)
);

CREATE TABLE termin_service (
    termin_termin_id   INT NOT NULL,
    service_service_id INT NOT NULL,
    CONSTRAINT termin_service_pk PRIMARY KEY (termin_termin_id, service_service_id)
);

CREATE TABLE terminv (
    terminv_id                 INT NOT NULL,
    datum                      DATE,
    uhrzeit                    DATETIME,
    notizen                    VARCHAR(250),
    mitarbeiter_mitarbeiter_id INT NOT NULL,
    kunde_kunde_id             INT NOT NULL,
    CONSTRAINT terminvorschlag_pk PRIMARY KEY (terminv_id)
);

CREATE TABLE terminv_service (
    terminv_terminv_id INT NOT NULL,
    service_service_id INT NOT NULL,
    CONSTRAINT terminv_service_pk PRIMARY KEY (terminv_terminv_id, service_service_id)
);

CREATE TABLE wartungsverlauf (
    wartungsverlauf_id    INT NOT NULL,
    datum                 DATE,
    beschreibung          VARCHAR(250),
    kosten                DECIMAL(10, 2),
    naechsterservicedatum DATE,
    fahrzeug_fahrzeug_id  INT NOT NULL,
    service_service_id    INT NOT NULL,
    CONSTRAINT wartungsverlauf_pk PRIMARY KEY (wartungsverlauf_id)
);

ALTER TABLE benachrichtigung
    ADD CONSTRAINT benachrichtigung_kunde_fk FOREIGN KEY (kunde_kunde_id)
    REFERENCES kunde (kunde_id);

ALTER TABLE fahrzeug
    ADD CONSTRAINT fahrzeug_kunde_fk FOREIGN KEY (kunde_kunde_id)
    REFERENCES kunde (kunde_id);

ALTER TABLE termin
    ADD CONSTRAINT termin_kunde_fk FOREIGN KEY (kunde_kunde_id)
    REFERENCES kunde (kunde_id);

ALTER TABLE termin
    ADD CONSTRAINT termin_mitarbeiter_fk FOREIGN KEY (mitarbeiter_mitarbeiter_id)
    REFERENCES mitarbeiter (mitarbeiter_id);

ALTER TABLE termin_service
    ADD CONSTRAINT termin_service_service_fk FOREIGN KEY (service_service_id)
    REFERENCES service (service_id);

ALTER TABLE termin_service
    ADD CONSTRAINT termin_service_termin_fk FOREIGN KEY (termin_termin_id)
    REFERENCES termin (termin_id);

ALTER TABLE terminv
    ADD CONSTRAINT terminv_kunde_fk FOREIGN KEY (kunde_kunde_id)
    REFERENCES kunde (kunde_id);

ALTER TABLE terminv
    ADD CONSTRAINT terminv_mitarbeiter_fk FOREIGN KEY (mitarbeiter_mitarbeiter_id)
    REFERENCES mitarbeiter (mitarbeiter_id);

ALTER TABLE terminv_service
    ADD CONSTRAINT terminv_service_service_fk FOREIGN KEY (service_service_id)
    REFERENCES service (service_id);

ALTER TABLE terminv_service
    ADD CONSTRAINT terminv_service_terminv_fk FOREIGN KEY (terminv_terminv_id)
    REFERENCES terminv (terminv_id);

ALTER TABLE wartungsverlauf
    ADD CONSTRAINT wartungsverlauf_fahrzeug_fk FOREIGN KEY (fahrzeug_fahrzeug_id)
    REFERENCES fahrzeug (fahrzeug_id);

ALTER TABLE wartungsverlauf
    ADD CONSTRAINT wartungsverlauf_service_fk FOREIGN KEY (service_service_id)
    REFERENCES service (service_id);
