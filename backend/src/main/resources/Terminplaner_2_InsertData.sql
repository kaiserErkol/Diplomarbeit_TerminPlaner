-- Insert into verwalter table first
INSERT INTO verwalter (verwalter_id, bezeichnung)
VALUES (NEXT VALUE FOR verwalter_id_seq, 'Verwalter 1');

-- Inserts für die Tabelle kunde
INSERT INTO kunde (vorname, nachname, email, telefonnummer, adresse)
VALUES ('Max', 'Mustermann', 'max.mustermann@example.com', '0123456789', 'Musterstr. 1, 12345 Musterstadt');

INSERT INTO kunde (vorname, nachname, email, telefonnummer, adresse)
VALUES ('Yasin', 'Erkol', 'yasin.erkol@example.com', '0123451241', 'Linzerstrasse 2, 2141 Linz');

-- Inserts für die Tabelle service
INSERT INTO service (bezeichnung, beschreibung, dauerinmin)
VALUES
    ('Getriebe-Reparatur', 'Eine umfassende und komplexe Reparatur, die den Austausch oder die Instandsetzung des Getriebes umfasst.', 0),
    ('Bremsenservice', 'Eine Routinewartung, die die Überprüfung, Reinigung und gegebenenfalls den Austausch der Bremsbeläge und -scheiben beinhaltet.', 80),
    ('Direktabwicklung', 'Ein flexibler Service, der je nach Bedarf sowohl kleine als auch große Reparaturen umfassen kann.', -1),
    ('Service nach Herstellervorgabe', 'Ein Wartungsservice, der den spezifischen Vorgaben des Fahrzeugherstellers folgt und sowohl kleinere als auch umfangreichere Reparaturen umfassen kann.', -1),
    ('Klima-Service', 'Eine Wartung des Klimaanlagensystems, inklusive Überprüfung und Auffüllung des Kältemittels.', 80),
    ('Felgen/Reifen-Service', ' Ein Service, der das Wechseln, Auswuchten und eventuell die Reparatur von Reifen und Felgen beinhaltet.', 60),
    ('Turbolader-Reparatur', 'Eine größere Reparatur, die den Austausch oder die Instandsetzung des Turboladers umfasst.', 0),
    ('Ersatzteile', 'Austausch oder Einbau von Ersatzteilen, oft als Teil einer kleineren Reparatur.', 90),
    ('Windschutzscheiben-Service', 'Umfassende Reparatur oder Austausch der Windschutzscheibe bei Schäden oder Rissen.', 0),
    ('Lack-Instandsetzung', 'Reparatur von Lackschäden, wie Kratzer, Dellen oder größere Lackierarbeiten.', 0),
    ('Karosserie-Arbeiten', 'Umfangreiche Reparaturen an der Fahrzeugkarosserie, die bei Unfallschäden oder Rost erforderlich sind.', 0),
    ('Zahnriemen-Service', 'Eine wichtige Wartungsarbeit, die den Austausch des Zahnriemens umfasst, um Motorschäden zu vermeiden.', 0),
    ('Fahrzeug-Tuning', 'Eine umfassende Modifikation des Fahrzeugs zur Leistungssteigerung oder optischen Verbesserung.', 0),
    ('Pickerl-Überprüfungen', 'Eine gesetzlich vorgeschriebene Überprüfung des Fahrzeugs auf Verkehrstauglichkeit und Sicherheit.', 60);

-- Inserts für die Tabelle termin
INSERT INTO termin (datum, uhrzeit, status, notizen, service_service_id, kunde_kunde_id, verwalter_verwalter_id)
VALUES ('2024-07-10', '10:00:00', '', '', 1, 1, 1);

-- Inserts für die Tabelle mechaniker
INSERT INTO mechaniker (mechaniker_id, vorname, nachname, namenkuerzel, telefon, termin_termin_id)
VALUES (NEXT VALUE FOR mechaniker_id_seq, 'John', 'Doe', 'JD', '0987654321', 1);

-- Inserts für die Tabelle benachrichtigung
INSERT INTO benachrichtigung (benachrichtigung_id, nachricht, datum, kunde_kunde_id)
VALUES (NEXT VALUE FOR benachrichtigung_id_seq, 'Ihr Fahrzeug ist zur Abholung bereit.', '2024-07-11', 1);

-- Inserts für die Tabelle fahrzeug
INSERT INTO fahrzeug (fahrzeug_id, marke, modell, baujahr, kunde_kunde_id, kilometerstand, zulassungsschein)
VALUES ('AM 123AB', 'BMW', '3er', '2020-05-15', 1, 150603, './assets/img1.jpg');

-- Inserts für die Tabelle kostenvorschlag
INSERT INTO kostenvorschlag (kostenvorschlag_id, kunde_kunde_id, kosten, verwalter_verwalter_id)
VALUES (NEXT VALUE FOR kostenvorschlag_id_seq, 1, 500.00, 1);

-- Inserts für die Tabelle terminvorschlag
INSERT INTO terminvorschlag (terminvorschlag_id, datum, uhrzeit, kunde_kunde_id, verwalter_verwalter_id)
VALUES (NEXT VALUE FOR terminvorschlag_id_seq, '2024-07-09', '09:00:00', 1, 1);

-- Inserts für die Tabelle verleihauto
INSERT INTO verleihauto (verleihauto_id, marke, modell, besetzt, verwalter_verwalter_id, kunde_kunde_id)
VALUES (NEXT VALUE FOR verwalter_id_seq, 'Audi', 'A4', 'N', 1, NULL);

-- Inserts für die Tabelle wartungsverlauf
INSERT INTO wartungsverlauf (wartungsverlauf_id, datum, fahrzeug_fahrzeug_id, service_service_id, mechaniker_mechaniker_id, notiz, status)
VALUES (NEXT VALUE FOR wartungsverlauf_id_seq, '2024-07-11', 'AM 123AB', 1, 1, 'Ölwechsel durchgeführt', 'ABHOLBEREIT');

-- Insert for the new table Terminanfrage
INSERT INTO terminanfrage (terminanfrage_id, datum, notiz, kunde_kunde_id, fahrzeug_fahrzeug_id, service_service_id, verwalter_verwalter_id)
VALUES (NEXT VALUE FOR terminanfrage_id_seq, '2024-07-15', 'keine Notizen', 1, 'AM 123AB', 1, 1);

