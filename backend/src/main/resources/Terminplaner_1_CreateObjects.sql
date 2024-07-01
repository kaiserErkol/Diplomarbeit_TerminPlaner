-- Generiert von Oracle SQL Developer Data Modeler 22.2.0.165.1149
--   am/um:        2024-07-01 13:49:14 MESZ
--   Site:      Oracle Database 11g
--   Typ:      Oracle Database 11g

CREATE TABLE benachrichtigung (
                                  benachrichtigung_id INT NOT NULL,
                                  nachricht           NVARCHAR(250),
                                  datum               DATE,
                                  kunde_kunde_id      INT NOT NULL,
                                  PRIMARY KEY (benachrichtigung_id)
);

CREATE TABLE fahrzeug (
                          fahrzeug_id    INT NOT NULL,
                          marke          NVARCHAR(250),
                          modell         NVARCHAR(250),
                          baujahr        DATE,
                          kennzeichen    NVARCHAR(250),
                          kunde_kunde_id INT NOT NULL,
                          PRIMARY KEY (fahrzeug_id)
);

CREATE TABLE kunde (
                       kunde_id      INT NOT NULL,
                       vorname       NVARCHAR(250),
                       nachname      NVARCHAR(250),
                       email         NVARCHAR(250),
                       telefonnummer NVARCHAR(250),
                       adresse       NVARCHAR(250),
                       PRIMARY KEY (kunde_id)
);

CREATE TABLE mitarbeiter (
                             mitarbeiter_id INT NOT NULL,
                             vorname        NVARCHAR(250),
                             nachname       NVARCHAR(250),
                             email          NVARCHAR(250),
                             telefonnummer  NVARCHAR(250), -- Größe der Spalte wurde hinzugefügt
                             PRIMARY KEY (mitarbeiter_id)
);

CREATE TABLE service (
                         service_id       INT NOT NULL,
                         bezeichnung      NVARCHAR(250),
                         beschreibung     NVARCHAR(250),
                         dauerinstunden   INT,
                         kosten           DECIMAL(18, 2),
                         serviceintervall INT,
                         PRIMARY KEY (service_id)
);

CREATE TABLE termin (
                        termin_id                  INT NOT NULL,
                        datum                      DATE,
                        uhrzeit                    TIMESTAMP,
                        status                     NVARCHAR(250),
                        notizen                    NVARCHAR(250),
                        kunde_kunde_id             INT NOT NULL,
                        mitarbeiter_mitarbeiter_id INT NOT NULL,
                        PRIMARY KEY (termin_id)
);

CREATE TABLE termin_service (
                                termin_termin_id   INT NOT NULL,
                                service_service_id INT NOT NULL,
                                PRIMARY KEY (termin_termin_id, service_service_id)
);

CREATE TABLE wartungseintrag (
                                 wartungseintrag_id    INT NOT NULL,
                                 datum                 DATE,
                                 beschreibung          NVARCHAR(250),
                                 kosten                DECIMAL(18, 2),
                                 naechsterservicedatum DATE,
                                 fahrzeug_fahrzeug_id  INT NOT NULL,
                                 service_service_id    INT NOT NULL,
                                 PRIMARY KEY (wartungseintrag_id)
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

ALTER TABLE wartungseintrag
    ADD CONSTRAINT wartungseintrag_fahrzeug_fk FOREIGN KEY (fahrzeug_fahrzeug_id)
        REFERENCES fahrzeug (fahrzeug_id);

ALTER TABLE wartungseintrag
    ADD CONSTRAINT wartungseintrag_service_fk FOREIGN KEY (service_service_id)
        REFERENCES service (service_id);
