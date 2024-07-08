-- Inserts für die Tabelle kunde
INSERT INTO kunde (vorname, nachname, email, telefonnummer, adresse)
VALUES ('Max', 'Mustermann', 'max.mustermann@example.com', '0123456789', 'Musterstr. 1, 12345 Musterstadt');

INSERT INTO kunde (vorname, nachname, email, telefonnummer, adresse)
VALUES ('Yasin', 'Erkol', 'yasin.erkol@example.com', '0123451241', 'Linzerstrasse 2, 2141 Linz');

/*
-- Inserts für die Tabelle verwalter
INSERT INTO verwalter (verwalter_id)
VALUES (1);

-- Inserts für die Tabelle service
INSERT INTO service (service_id, bezeichnung, beschreibung, dauerinmin)
VALUES
    (1, 'Ölwechsel', 'Ölwechsel und Filteraustausch', 2),
    (2, 'Getriebe-Reparatur', 'Eine umfassende und komplexe Reparatur, die den Austausch oder die Instandsetzung des Getriebes umfasst.', 0),
    (3, 'Bremsenservice', 'Eine Routinewartung, die die Überprüfung, Reinigung und gegebenenfalls den Austausch der Bremsbeläge und -scheiben beinhaltet.', 80),
    (4, 'Direktabwicklung', 'Ein flexibler Service, der je nach Bedarf sowohl kleine als auch große Reparaturen umfassen kann.', -1),
    (5, 'Service nach Herstellervorgabe', 'Ein Wartungsservice, der den spezifischen Vorgaben des Fahrzeugherstellers folgt und sowohl kleinere als auch umfangreichere Reparaturen umfassen kann.', -1),
    (6, 'Klima-Service', 'Eine Wartung des Klimaanlagensystems, inklusive Überprüfung und Auffüllung des Kältemittels.', 80),
    (7, 'Felgen/Reifen-Service', ' Ein Service, der das Wechseln, Auswuchten und eventuell die Reparatur von Reifen und Felgen beinhaltet.', 60),
    (8, 'Turbolader-Reparatur', 'Eine größere Reparatur, die den Austausch oder die Instandsetzung des Turboladers umfasst.', 0),
    (9, 'Ersatzteile', 'Austausch oder Einbau von Ersatzteilen, oft als Teil einer kleineren Reparatur.', 90),
    (10, 'Windschutzscheiben-Service', 'Umfassende Reparatur oder Austausch der Windschutzscheibe bei Schäden oder Rissen.', 0),
    (11, 'Lack-Instandsetzung', 'Reparatur von Lackschäden, wie Kratzer, Dellen oder größere Lackierarbeiten.', 0),
    (12, 'Karosserie-Arbeiten', 'Umfangreiche Reparaturen an der Fahrzeugkarosserie, die bei Unfallschäden oder Rost erforderlich sind.', 0),
    (13, 'Zahnriemen-Service', 'Eine wichtige Wartungsarbeit, die den Austausch des Zahnriemens umfasst, um Motorschäden zu vermeiden.', 0),
    (14, 'Fahrzeug-Tuning', 'Eine umfassende Modifikation des Fahrzeugs zur Leistungssteigerung oder optischen Verbesserung.', 0),
    (15, 'Pickerl-Überprüfungen', 'Eine gesetzlich vorgeschriebene Überprüfung des Fahrzeugs auf Verkehrstauglichkeit und Sicherheit.', 60);

-- Inserts für die Tabelle termin
INSERT INTO termin (termin_id, datum, uhrzeit, status, notizen, service_service_id, kunde_kunde_id, verwalter_verwalter_id)
VALUES (1, '2024-07-10', '10:00:00', 'GEPLANT', 'Keine Notizen', 1, 1, 1);

-- Inserts für die Tabelle mechaniker
INSERT INTO mechaniker (mechaniker_id, vorname, nachname, namenkuerzel, telefon, termin_termin_id)
VALUES (1, 'John', 'Doe', 'JD', '0987654321', 1);

-- Inserts für die Tabelle benachrichtigung
INSERT INTO benachrichtigung (benachrichtigung_id, nachricht, datum, kunde_kunde_id)
VALUES (1, 'Ihr Fahrzeug ist zur Abholung bereit.', '2024-07-11', 1);

-- Inserts für die Tabelle fahrzeug
INSERT INTO fahrzeug (fahrzeug_id, marke, modell, baujahr, kunde_kunde_id, kilometerstand, zulassungsschein)
VALUES ('AM 123AB', 'BMW', '3er', '2020-05-15', 1, 150603, './assets/img1.jpg');

-- Inserts für die Tabelle kostenvorschlag
INSERT INTO kostenvorschlag (kostenvorschlag_id, kunde_kunde_id, kosten, verwalter_verwalter_id)
VALUES (1, 1, 500.00, 1);

-- Inserts für die Tabelle terminvorschlag
INSERT INTO terminvorschlag (terminvorschlag_id, datum, uhrzeit, kunde_kunde_id, verwalter_verwalter_id)
VALUES (1, '2024-07-09', '09:00:00', 1, 1);

-- Inserts für die Tabelle verleihauto
INSERT INTO verleihauto (verleihauto_id, marke, modell, besetzt, verwalter_verwalter_id, kunde_kunde_id)
VALUES ('AM 941CD', 'Audi', 'A4', 'N', 1, null);

-- Inserts für die Tabelle wartungsverlauf
INSERT INTO wartungsverlauf (wartungsverlauf_id, datum, fahrzeug_fahrzeug_id, service_service_id, mechaniker_mechaniker_id, notiz, status)
VALUES (1, '2024-07-11', 'AM 123AB', 1, 1, 'Ölwechsel durchgeführt', 'ABHOLBEREIT');
*/