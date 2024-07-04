-- Werte in die Tabelle "verwalter" einfügen
INSERT INTO verwalter (verwalter_id) VALUES (1);

-- Werte in die Tabelle "kunde" einfügen
INSERT INTO kunde (kunde_id, vorname, nachname, email, telefonnummer, adresse, verleihauto_verleiauto_id)
VALUES (1, 'Max', 'Mustermann', 'max@mustermann.de', '123456789', 'Musterstr. 1', 1);

-- Werte in die Tabelle "verleihauto" einfügen
INSERT INTO verleihauto (verleiauto_id, kennzeichen, marke, modell, besetzt, verwalter_verwalter_id)
VALUES (1, 'B-MX1234', 'BMW', 'X5', 'N', 1);

-- Werte in die Tabelle "fahrzeug" einfügen
INSERT INTO fahrzeug (fahrzeug_id, marke, modell, baujahr, kennzeichen, kunde_kunde_id, kilometerstand, zulassungsschein)
VALUES (1, 'VW', 'Golf', '2020-01-01', 'B-GO1234', 1, 15000, 'Zulassungsschein1');

-- Werte in die Tabelle "mechaniker" einfügen
INSERT INTO mechaniker (mechaniker_id, vorname, nachname, namenkuerzel, telefon)
VALUES (1, 'Hans', 'Meier', 'HM', '+43 650 3304');

-- Werte in die Tabelle "kostenvorschlag" einfügen
INSERT INTO kostenvorschlag (kostenvorschlag_id, kunde_kunde_id, kosten, verwalter_verwalter_id)
VALUES (1, 1, 500.00, 1);

-- Werte in die Tabelle "service" einfügen
INSERT INTO service (service_id, bezeichnung, beschreibung, dauerinstunden, schwierigkeit, fahrzeug_fahrzeug_id, mechaniker_mechaniker_id, termin_termin_id)
VALUES (1, 'Ölwechsel', 'Wechsel des Motoröls', 2, 'M', 1, 1, 1);
INSERT INTO service (service_id, bezeichnung, beschreibung, dauerinstunden, schwierigkeit, fahrzeug_fahrzeug_id, mechaniker_mechaniker_id, termin_termin_id)
VALUES (2, 'Bremsenwechsel', 'Wechsel der Bremsbeläge', 3, 'S', 2, 2, 2);
INSERT INTO service (service_id, bezeichnung, beschreibung, dauerinstunden, schwierigkeit, fahrzeug_fahrzeug_id, mechaniker_mechaniker_id, termin_termin_id)
VALUES (3, 'Getriebe-Reparatur', 'Eine umfassende und komplexe Reparatur, die den Austausch oder die Instandsetzung des Getriebes umfasst.', 0, 'g', 2,2)

-- Werte in die Tabelle "termin" einfügen
INSERT INTO termin (termin_id, datum, uhrzeit, status, notizen, kunde_kunde_id, verwalter_verwalter_id)
VALUES (1, '2023-07-10', '08:00:00', 'Geplant', 'Ölwechsel', 1, 1);
INSERT INTO termin (termin_id, datum, uhrzeit, status, notizen, kunde_kunde_id, verwalter_verwalter_id)
VALUES (2, '2023-07-11', '10:00:00', 'Geplant', 'Bremsenwechsel', 2, 2);

-- Werte in die Tabelle "terminvorschlag" einfügen
INSERT INTO terminvorschlag (terminvorschlag_id, kunde_kunde_id, verwalter_verwalter_id)
VALUES (1, 1, 1);
INSERT INTO terminvorschlag (terminvorschlag_id, kunde_kunde_id, verwalter_verwalter_id)
VALUES (2, 2, 2);

-- Werte in die Tabelle "wartungsverlauf" einfügen
INSERT INTO wartungsverlauf (wartungsverlauf_id, datum, fahrzeug_fahrzeug_id, mechaniker_mechaniker_id, notiz)
VALUES (1, '2023-06-01', 1, 1, 'Regelmäßige Wartung');
INSERT INTO wartungsverlauf (wartungsverlauf_id, datum, fahrzeug_fahrzeug_id, mechaniker_mechaniker_id, notiz)
VALUES (2, '2023-06-15', 2, 2, 'Bremsbeläge gewechselt');
