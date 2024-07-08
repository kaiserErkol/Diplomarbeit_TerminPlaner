CREATE TABLE kunde (
                       kunde_id INT NOT NULL,
                       vorname VARCHAR(250),
                       nachname VARCHAR(250),
                       email VARCHAR(250),
                       telefonnummer VARCHAR(250),
                       adresse VARCHAR(250),
                       PRIMARY KEY (kunde_id)
);


/*

CREATE TABLE benachrichtigung (
                                  benachrichtigung_id INT NOT NULL,
                                  nachricht           VARCHAR(250),
                                  datum               DATE,
                                  kunde_kunde_id      INT NOT NULL,
                                  PRIMARY KEY (benachrichtigung_id),
                                  FOREIGN KEY (kunde_kunde_id) REFERENCES kunde (kunde_id)
);

CREATE TABLE fahrzeug (
                          fahrzeug_id      VARCHAR(250) NOT NULL,
                          marke            VARCHAR(250),
                          modell           VARCHAR(250),
                          baujahr          DATE,
                          kunde_kunde_id   INT NOT NULL,
                          kilometerstand   INT,
                          zulassungsschein VARCHAR(250),
                          PRIMARY KEY (fahrzeug_id),
                          FOREIGN KEY (kunde_kunde_id) REFERENCES kunde (kunde_id)
);

CREATE TABLE kostenvorschlag (
                                 kostenvorschlag_id     INT NOT NULL,
                                 kunde_kunde_id         INT NOT NULL,
                                 kosten                 DECIMAL(18, 2),
                                 verwalter_verwalter_id INT NOT NULL,
                                 PRIMARY KEY (kostenvorschlag_id),
                                 FOREIGN KEY (kunde_kunde_id) REFERENCES kunde (kunde_id),
                                 FOREIGN KEY (verwalter_verwalter_id) REFERENCES verwalter (verwalter_id)
);



CREATE TABLE mechaniker (
                            mechaniker_id INT NOT NULL,
                            vorname       VARCHAR(250),
                            nachname      VARCHAR(250),
                            namenkuerzel  VARCHAR(50),
                            telefon       VARCHAR(50),
                            termin_termin_id INT NOT NULL,
                            PRIMARY KEY (mechaniker_id),
                            FOREIGN KEY (termin_termin_id) REFERENCES termin (termin_id)
);

CREATE TABLE service (
                         service_id     INT NOT NULL,
                         bezeichnung    VARCHAR(250),
                         beschreibung   VARCHAR(250),
                         dauerinmin     INT,
                         PRIMARY KEY (service_id)
);

CREATE TABLE termin (
                        termin_id              INT NOT NULL,
                        datum                  DATE,
                        uhrzeit                TIME,
                        status                 VARCHAR(250),
                        notizen                VARCHAR(250),
                        service_service_id     INT NOT NULL,
                        kunde_kunde_id         INT NOT NULL,
                        verwalter_verwalter_id INT NOT NULL,
                        PRIMARY KEY (termin_id),
                        FOREIGN KEY (service_service_id) REFERENCES service (service_id),
                        FOREIGN KEY (kunde_kunde_id) REFERENCES kunde (kunde_id),
                        FOREIGN KEY (verwalter_verwalter_id) REFERENCES verwalter (verwalter_id)
);

CREATE TABLE terminvorschlag (
                                 terminvorschlag_id     INT NOT NULL,
                                 datum                  DATE,
                                 uhrzeit                TIME,
                                 kunde_kunde_id         INT NOT NULL,
                                 verwalter_verwalter_id INT NOT NULL,
                                 PRIMARY KEY (terminvorschlag_id),
                                 FOREIGN KEY (kunde_kunde_id) REFERENCES kunde (kunde_id),
                                 FOREIGN KEY (verwalter_verwalter_id) REFERENCES verwalter (verwalter_id)
);

CREATE TABLE verleihauto (
                             verleihauto_id          VARCHAR(250) NOT NULL,
                             marke                  VARCHAR(250),
                             modell                 VARCHAR(250),
                             besetzt                CHAR(1),
                             verwalter_verwalter_id INT NOT NULL,
                             kunde_kunde_id         INT,
                             PRIMARY KEY (verleihauto_id),
                             FOREIGN KEY (verwalter_verwalter_id) REFERENCES verwalter (verwalter_id),
                             FOREIGN KEY (kunde_kunde_id) REFERENCES kunde (kunde_id)
);

CREATE TABLE verwalter (
                           verwalter_id INT NOT NULL,
                           PRIMARY KEY (verwalter_id)
);

CREATE TABLE wartungsverlauf (
                                 wartungsverlauf_id       INT NOT NULL,
                                 datum                    DATE,
                                 status                   VARCHAR(250),
                                 fahrzeug_fahrzeug_id     VARCHAR(250) NOT NULL,
                                 service_service_id       INT NOT NULL,
                                 mechaniker_mechaniker_id INT NOT NULL,
                                 notiz                    VARCHAR(250),
                                 PRIMARY KEY (wartungsverlauf_id),
                                 FOREIGN KEY (fahrzeug_fahrzeug_id) REFERENCES fahrzeug (fahrzeug_id),
                                 FOREIGN KEY (service_service_id) REFERENCES service (service_id),
                                 FOREIGN KEY (mechaniker_mechaniker_id) REFERENCES mechaniker (mechaniker_id)
);
*/