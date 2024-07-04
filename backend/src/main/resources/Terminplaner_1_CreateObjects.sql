CREATE TABLE benachrichtigung (
                                  benachrichtigung_id INT NOT NULL,
                                  nachricht           NVARCHAR(250),
                                  datum               DATE,
                                  kunde_kunde_id      INT NOT NULL
);

ALTER TABLE benachrichtigung ADD CONSTRAINT benachrichtigung_pk PRIMARY KEY (benachrichtigung_id);

CREATE TABLE fahrzeug (
                          fahrzeug_id      INT NOT NULL,
                          marke            NVARCHAR(250),
                          modell           NVARCHAR(250),
                          baujahr          DATE,
                          kennzeichen      NVARCHAR(250),
                          kunde_kunde_id   INT NOT NULL,
                          kilometerstand   INT,
                          zulassungsschein NVARCHAR(250)
);

ALTER TABLE fahrzeug ADD CONSTRAINT fahrzeug_pk PRIMARY KEY (fahrzeug_id);

CREATE TABLE kostenvorschlag (
                                 kostenvorschlag_id     INT NOT NULL,
                                 kunde_kunde_id         INT NOT NULL,
                                 kosten                 DECIMAL(18, 2),
                                 verwalter_verwalter_id INT NOT NULL
);

ALTER TABLE kostenvorschlag ADD CONSTRAINT kostenvorschlag_pk PRIMARY KEY (kostenvorschlag_id);

CREATE TABLE kunde (
                       kunde_id                  INT NOT NULL,
                       vorname                   NVARCHAR(250),
                       nachname                  NVARCHAR(250),
                       email                     NVARCHAR(250),
                       telefonnummer             NVARCHAR(250),
                       adresse                   NVARCHAR(250),
                       verleihauto_verleiauto_id INT NOT NULL
);

CREATE UNIQUE INDEX kunde__idx ON kunde (verleihauto_verleiauto_id);

ALTER TABLE kunde ADD CONSTRAINT kunde_pk PRIMARY KEY (kunde_id);

CREATE TABLE mechaniker (
                            mechaniker_id INT NOT NULL,
                            vorname       NVARCHAR(250),
                            nachname      NVARCHAR(250),
                            namenkuerzel  NVARCHAR(50),
                            telefon       NVARCHAR(50)
);

ALTER TABLE mechaniker ADD CONSTRAINT mechaniker_pk PRIMARY KEY (mechaniker_id);

CREATE TABLE service (
                         service_id               INT NOT NULL,
                         bezeichnung              NVARCHAR(250),
                         beschreibung             NVARCHAR(250),
                         dauerinstunden           INT,
                         schwierigkeit            CHAR(1),
                         fahrzeug_fahrzeug_id     INT NOT NULL,
                         mechaniker_mechaniker_id INT NOT NULL,
                         termin_termin_id         INT NOT NULL
);

ALTER TABLE service ADD CONSTRAINT service_pk PRIMARY KEY (service_id);

CREATE TABLE termin (
                        termin_id              INT NOT NULL,
                        datum                  DATE,
                        uhrzeit                TIME,
                        status                 NVARCHAR(250),
                        notizen                NVARCHAR(250),
                        kunde_kunde_id         INT NOT NULL,
                        verwalter_verwalter_id INT NOT NULL
);

ALTER TABLE termin ADD CONSTRAINT termin_pk PRIMARY KEY (termin_id);

CREATE TABLE terminvorschlag (
                                 terminvorschlag_id     INT NOT NULL,
                                 kunde_kunde_id         INT,
                                 verwalter_verwalter_id INT NOT NULL
);

ALTER TABLE terminvorschlag ADD CONSTRAINT terminvorschlag_pk PRIMARY KEY (terminvorschlag_id);

CREATE TABLE verleihauto (
                             verleiauto_id          INT NOT NULL,
                             kennzeichen            NVARCHAR(250),
                             marke                  NVARCHAR(250),
                             modell                 NVARCHAR(250),
                             besetzt                CHAR(1),
                             verwalter_verwalter_id INT NOT NULL
);

ALTER TABLE verleihauto ADD CONSTRAINT verleihauto_pk PRIMARY KEY (verleiauto_id);

CREATE TABLE verwalter (
                           verwalter_id INT NOT NULL
);

ALTER TABLE verwalter ADD CONSTRAINT verwalter_pk PRIMARY KEY (verwalter_id);

CREATE TABLE wartungsverlauf (
                                 wartungsverlauf_id       INT NOT NULL,
                                 datum                    DATE,
                                 fahrzeug_fahrzeug_id     INT NOT NULL,
                                 mechaniker_mechaniker_id INT NOT NULL,
                                 notiz                    NVARCHAR(250)
);

ALTER TABLE wartungsverlauf ADD CONSTRAINT wartungsverlauf_pk PRIMARY KEY (wartungsverlauf_id);

ALTER TABLE benachrichtigung
    ADD CONSTRAINT benachrichtigung_kunde_fk FOREIGN KEY (kunde_kunde_id)
        REFERENCES kunde (kunde_id);

ALTER TABLE fahrzeug
    ADD CONSTRAINT fahrzeug_kunde_fk FOREIGN KEY (kunde_kunde_id)
        REFERENCES kunde (kunde_id);

ALTER TABLE kostenvorschlag
    ADD CONSTRAINT kostenvorschlag_kunde_fk FOREIGN KEY (kunde_kunde_id)
        REFERENCES kunde (kunde_id);

ALTER TABLE kostenvorschlag
    ADD CONSTRAINT kostenvorschlag_verwalter_fk FOREIGN KEY (verwalter_verwalter_id)
        REFERENCES verwalter (verwalter_id);

ALTER TABLE kunde
    ADD CONSTRAINT kunde_verleihauto_fk FOREIGN KEY (verleihauto_verleiauto_id)
        REFERENCES verleihauto (verleiauto_id);

ALTER TABLE service
    ADD CONSTRAINT service_fahrzeug_fk FOREIGN KEY (fahrzeug_fahrzeug_id)
        REFERENCES fahrzeug (fahrzeug_id);

ALTER TABLE service
    ADD CONSTRAINT service_mechaniker_fk FOREIGN KEY (mechaniker_mechaniker_id)
        REFERENCES mechaniker (mechaniker_id);

ALTER TABLE service
    ADD CONSTRAINT service_termin_fk FOREIGN KEY (termin_termin_id)
        REFERENCES termin (termin_id);

ALTER TABLE termin
    ADD CONSTRAINT termin_kunde_fk FOREIGN KEY (kunde_kunde_id)
        REFERENCES kunde (kunde_id);

ALTER TABLE termin
    ADD CONSTRAINT termin_verwalter_fk FOREIGN KEY (verwalter_verwalter_id)
        REFERENCES verwalter (verwalter_id);

ALTER TABLE terminvorschlag
    ADD CONSTRAINT terminvorschlag_kunde_fk FOREIGN KEY (kunde_kunde_id)
        REFERENCES kunde (kunde_id);

ALTER TABLE terminvorschlag
    ADD CONSTRAINT terminvorschlag_verwalter_fk FOREIGN KEY (verwalter_verwalter_id)
        REFERENCES verwalter (verwalter_id);

ALTER TABLE verleihauto
    ADD CONSTRAINT verleihauto_verwalter_fk FOREIGN KEY (verwalter_verwalter_id)
        REFERENCES verwalter (verwalter_id);

ALTER TABLE wartungsverlauf
    ADD CONSTRAINT wartungsverlauf_fahrzeug_fk FOREIGN KEY (fahrzeug_fahrzeug_id)
        REFERENCES fahrzeug (fahrzeug_id);

ALTER TABLE wartungsverlauf
    ADD CONSTRAINT wartungsverlauf_mechaniker_fk FOREIGN KEY (mechaniker_mechaniker_id)
        REFERENCES mechaniker (mechaniker_id);
