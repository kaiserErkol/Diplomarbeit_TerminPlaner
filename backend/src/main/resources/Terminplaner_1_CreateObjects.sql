-- Creating sequences for IDs
CREATE SEQUENCE kunde_id_seq AS INT START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE benachrichtigung_id_seq AS INT START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE kostenvorschlag_id_seq AS INT START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE mechaniker_id_seq AS INT START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE service_id_seq AS INT START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE termin_id_seq AS INT START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE terminvorschlag_id_seq AS INT START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE verwalter_id_seq AS INT START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE wartungsverlauf_id_seq AS INT START WITH 1 INCREMENT BY 1;

-- Creating primary tables first without foreign key dependencies
CREATE TABLE kunde (
                       kunde_id INT NOT NULL DEFAULT NEXT VALUE FOR kunde_id_seq,
                       vorname VARCHAR(250),
                       nachname VARCHAR(250),
                       email VARCHAR(250),
                       telefonnummer VARCHAR(250),
                       adresse VARCHAR(250),
                       PRIMARY KEY (kunde_id)
);

CREATE TABLE service (
                         service_id INT NOT NULL DEFAULT NEXT VALUE FOR service_id_seq,
                         bezeichnung VARCHAR(250),
                         beschreibung VARCHAR(250),
                         dauerinmin INT,
                         PRIMARY KEY (service_id)
);

CREATE TABLE verwalter (
                           verwalter_id INT NOT NULL DEFAULT NEXT VALUE FOR verwalter_id_seq,
                           bezeichnung VARCHAR(250) NOT NULL DEFAULT 'Jeder kann sich als den Verwalter anmelden, dem es erlaubt ist den Terminplan zu bearbeiten.',
                           PRIMARY KEY (verwalter_id)
);

-- Creating tables with foreign key dependencies
CREATE TABLE benachrichtigung (
                                  benachrichtigung_id INT NOT NULL DEFAULT NEXT VALUE FOR benachrichtigung_id_seq,
                                  nachricht VARCHAR(250),
                                  datum DATE,
                                  kunde_kunde_id INT NOT NULL,
                                  PRIMARY KEY (benachrichtigung_id),
                                  FOREIGN KEY (kunde_kunde_id) REFERENCES kunde (kunde_id)
);

CREATE TABLE fahrzeug (
                          fahrzeug_id VARCHAR(250) NOT NULL,
                          marke VARCHAR(250),
                          modell VARCHAR(250),
                          baujahr DATE,
                          kunde_kunde_id INT NOT NULL,
                          kilometerstand INT,
                          zulassungsschein VARCHAR(250),
                          PRIMARY KEY (fahrzeug_id),
                          FOREIGN KEY (kunde_kunde_id) REFERENCES kunde (kunde_id)
);

CREATE TABLE termin (
                        termin_id INT NOT NULL DEFAULT NEXT VALUE FOR termin_id_seq,
                        datum DATE,
                        uhrzeit TIME,
                        status VARCHAR(250) NOT NULL DEFAULT 'GEPLANT',
                        notizen VARCHAR(250) NOT NULL DEFAULT 'Keine Notizen',
                        service_service_id INT NOT NULL,
                        kunde_kunde_id INT NOT NULL,
                        verwalter_verwalter_id INT NOT NULL,
                        PRIMARY KEY (termin_id),
                        FOREIGN KEY (service_service_id) REFERENCES service (service_id),
                        FOREIGN KEY (kunde_kunde_id) REFERENCES kunde (kunde_id),
                        FOREIGN KEY (verwalter_verwalter_id) REFERENCES verwalter (verwalter_id)
);

CREATE TABLE kostenvorschlag (
                                 kostenvorschlag_id INT NOT NULL DEFAULT NEXT VALUE FOR kostenvorschlag_id_seq,
                                 kunde_kunde_id INT NOT NULL,
                                 kosten DECIMAL(18, 2),
                                 verwalter_verwalter_id INT NOT NULL,
                                 PRIMARY KEY (kostenvorschlag_id),
                                 FOREIGN KEY (kunde_kunde_id) REFERENCES kunde (kunde_id),
                                 FOREIGN KEY (verwalter_verwalter_id) REFERENCES verwalter (verwalter_id)
);

CREATE TABLE terminvorschlag (
                                 terminvorschlag_id INT NOT NULL DEFAULT NEXT VALUE FOR terminvorschlag_id_seq,
                                 datum DATE NOT NULL DEFAULT GETDATE(),
                                 uhrzeit TIME,
                                 kunde_kunde_id INT NOT NULL,
                                 verwalter_verwalter_id INT NOT NULL,
                                 PRIMARY KEY (terminvorschlag_id),
                                 FOREIGN KEY (kunde_kunde_id) REFERENCES kunde (kunde_id),
                                 FOREIGN KEY (verwalter_verwalter_id) REFERENCES verwalter (verwalter_id)
);

CREATE TABLE verleihauto (
                             verleihauto_id INT NOT NULL DEFAULT NEXT VALUE FOR verwalter_id_seq,
                             marke VARCHAR(250),
                             modell VARCHAR(250),
                             besetzt CHAR(1) NOT NULL DEFAULT 'N',
                             verwalter_verwalter_id INT NOT NULL,
                             kunde_kunde_id INT,
                             PRIMARY KEY (verleihauto_id),
                             FOREIGN KEY (verwalter_verwalter_id) REFERENCES verwalter (verwalter_id),
                             FOREIGN KEY (kunde_kunde_id) REFERENCES kunde (kunde_id)
);

CREATE TABLE mechaniker (
                            mechaniker_id INT NOT NULL DEFAULT NEXT VALUE FOR mechaniker_id_seq,
                            vorname VARCHAR(250),
                            nachname VARCHAR(250),
                            namenkuerzel VARCHAR(50),
                            telefon VARCHAR(50),
                            termin_termin_id INT NOT NULL,
                            PRIMARY KEY (mechaniker_id),
                            FOREIGN KEY (termin_termin_id) REFERENCES termin (termin_id)
);

CREATE TABLE wartungsverlauf (
                                 wartungsverlauf_id INT NOT NULL DEFAULT NEXT VALUE FOR wartungsverlauf_id_seq,
                                 datum DATE,
                                 status VARCHAR(250) NOT NULL DEFAULT 'EINGANG',
                                 fahrzeug_fahrzeug_id VARCHAR(250) NOT NULL,
                                 service_service_id INT NOT NULL,
                                 mechaniker_mechaniker_id INT NOT NULL,
                                 notiz VARCHAR(250) NOT NULL DEFAULT 'Keine Notzien',
                                 PRIMARY KEY (wartungsverlauf_id),
                                 FOREIGN KEY (fahrzeug_fahrzeug_id) REFERENCES fahrzeug (fahrzeug_id),
                                 FOREIGN KEY (service_service_id) REFERENCES service (service_id),
                                 FOREIGN KEY (mechaniker_mechaniker_id) REFERENCES mechaniker (mechaniker_id)
);
