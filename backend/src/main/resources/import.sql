insert into Kunde (vorname,nachname,email,telefonnummer, postleitzahl, ort, adresse)
values ('Max', 'Mustermann', 'maxmustermann@gmail.com', '06676317872', 'XXXX', 'Musterort', 'Musteradresse');


insert into Verwalter (adresse, email, nachname, namekrzl, telefonnummer, vorname)
values ('K&C Automobil', 'verwaltert@gmail.com', 'Keles', 'MRL', '06914219849', 'Meral');


insert into Mechaniker (vorname,nachname, namekrzl, email,telefonnummer, postleitzahl, ort, adresse)
values ('Maximilian', 'Mustermann', 'MM','maxmustermann@gmail.com', '06676317872', 'XXXX', 'Musterort', 'Musteradresse');


insert into Fahrzeug (baujahr, kennzeichen, marke, modell, zulassungsscheinRoot, kunde_id)
values ('2015-05-10', 'W-12345X', 'BMW', 'X5', 'angularRoot/bmw_x5.pdf', 1);


insert into ReparaturEintrag (verwalter_id, abschlussdatum, beschreibung, status)
values (1,null,'keine Beschreibung', 'EINGANG');
insert into ReparaturEintrag (verwalter_id, abschlussdatum, beschreibung, status)
values (1,null,'keine Beschreibung', 'EINGANG');


INSERT INTO Feedback (bewertung, kommentar)
VALUES ('keine', 'keine Kommentar');
INSERT INTO Feedback (bewertung, kommentar)
values ('keine', 'kein Kommentar');


INSERT INTO Kostenvorschlag (bestaetigt, kosten, datum, beschreibung)
VALUES ('j', 40, '2024-07-16', 'Keine Beschreibung');
insert into Kostenvorschlag (bestaetigt, kosten, datum, beschreibung)
values ('j', 60, '2024-07-17', 'Keine Beschreibung');


INSERT INTO Terminvorschlag (bestaetigt, kostenvrs_id, kunde_id, datum, uhrzeit)
VALUES ('j', 1, 1, '2024-08-14', '15:30:00');
INSERT INTO Terminvorschlag (bestaetigt, kostenvrs_id, kunde_id, datum, uhrzeit)
VALUES ('n', 1, 1, '2024-08-20', '13:30:00');

INSERT INTO Terminvorschlag (bestaetigt, kostenvrs_id, kunde_id, uhrzeit, datum)
values ('j', 2, 1, '2024-10-14', '10:00:00');
INSERT INTO Terminvorschlag (bestaetigt, kostenvrs_id, kunde_id, uhrzeit, datum)
values ('n', 2, 1, '2024-10-20', '13:00:00');



insert into Termin (terminvrs_id, verwalter_id, notiz, status)
VALUES (1,1,'Keine Notiz', 'GEPLANT');
insert into Termin (terminvrs_id, verwalter_id, notiz, status)
values (3, 1, 'keine Notiz', 'GEPLANT');


INSERT INTO Reparatur (fahrzeug_id, kunde_id, feedback_id, kostenvrs_id, eintrag_id, termin_id, wunschtag_end, wunschtag_start, beschreibung)
VALUES (1, 1, 1, 1, 1, 1, '2024-08-11', '2024-08-05', 'keine Beschreibung');
INSERT INTO Reparatur (fahrzeug_id, kunde_id, feedback_id, kostenvrs_id, eintrag_id, termin_id, wunschtag_end, wunschtag_start, beschreibung)
VALUES (1, 1, 2, 2 , 2, 2, '2024-09-11', '2024-09-05', 'keine Beschreibung');


INSERT INTO Leihfahrzeug (besetzt, kennzeichen, marke, modell)
values ('j', 'AM 732 GH', 'Skoda', 'Octaiva');
INSERT INTO Leihfahrzeug (besetzt, kennzeichen, marke, modell)
values ('j', 'W 909 AF', 'Volvo', 'XC30');


INSERT INTO Leihvertrag (kunde_id, leihf_id, ausleihdatum, rueckgabedatum)
values (1, 1, '2024-08-14', null);

/*
insert into Kunde (vorname,nachname,email,telefonnummer, postleitzahl, ort, adresse)
values ('Max', 'Musterman', 'maxmusterman@gmail.com', '98018481024', '4303', 'Ennsdorf', 'Baeckerstrasse 29');

insert into Kunde (vorname,nachname,email,telefonnummer, postleitzahl, ort, adresse)
values ('Anna', 'Schmidt', 'anna.schmidt@example.com', '06641234567', '1010', 'Wien', 'Kaerntner Strasse 10');

insert into Kunde (vorname,nachname,email,telefonnummer, postleitzahl, ort, adresse)
values ('Lukas', 'Bauer', 'lukas.bauer@example.com', '06761234567', '5020', 'Salzburg', 'Mirabellplatz 5');

insert into Kunde (vorname,nachname,email,telefonnummer, postleitzahl, ort, adresse)
values ('Marie', 'Mueller', 'marie.mueller@example.com', '06801234567', '6020', 'Innsbruck', 'Maria-Theresie-Strassen 1');

insert into Kunde (vorname,nachname,email,telefonnummer, postleitzahl, ort, adresse)
values ('Jonas', 'Hoffmann', 'jonas.hofmann@example.com', '06991234567', '8010', 'Graz', 'Hotplate 3');
*/
/*
insert into Fahrzeug (baujahr, kennzeichen, marke, modell, zulassungsscheinRoot, kunde_id)
values ('2018-08-20', 'S-54321Z', 'Audi', 'A4', '/documents/zulassungsschein/audi_a4.pdf', 2);

insert into Fahrzeug (baujahr, kennzeichen, marke, modell, zulassungsscheinRoot, kunde_id)
values ('2020-03-15', 'L-67890Y', 'Mercedes', 'C-Class', '/documents/zulassungsschein/mercedes_c_class.pdf', 3);

insert into Fahrzeug (baujahr, kennzeichen, marke, modell, zulassungsscheinRoot, kunde_id)
values ('2019-07-25', 'G-98765W', 'Volkswagen', 'Golf', '/documents/zulassungsschein/volkswagen_golf.pdf', 4);

insert into Fahrzeug (baujahr, kennzeichen, marke, modell, zulassungsscheinRoot, kunde_id)
values ('2017-11-30', 'B-11223A', 'Tesla', 'Model S', '/documents/zulassungsschein/tesla_model_s.pdf', 5);

insert into Fahrzeug (baujahr, kennzeichen, marke, modell, zulassungsscheinRoot, kunde_id)
values ('2021-04-10', 'M-33445B', 'Toyota', 'Corolla', '/documents/zulassungsschein/toyota_corolla.pdf', 6);
*/
/*
INSERT INTO Feedback (bewertung, kommentar)
VALUES ('Sehr Gut', 'Sehr freundliche Mitarbeiter. Mein Auto ist so gut wie neu.');

INSERT INTO Feedback (bewertung, kommentar)
VALUES ('Gut', N'Arbeit wurde schnell erledigt, aber die Kommunikation könnte besser sein.');

INSERT INTO Feedback (bewertung, kommentar)
VALUES ('Befriedigend', N'Reparatur dauerte länger als erwartet, aber das Ergebnis ist zufriedenstellend.');

INSERT INTO Feedback (bewertung, kommentar)
VALUES ('Ausreichend', N'Die Reparatur wurde ordentlich ausgeführt, jedoch gab es einige Verzögerungen.');

INSERT INTO Feedback (bewertung, kommentar)
VALUES ('Mangelhaft', 'Unzufrieden mit der Dienstleistung, musste zweimal zur Nachbesserung hin.');

INSERT INTO Feedback (bewertung, kommentar)
VALUES ('Exzellent', 'Ausgezeichneter Service und Beratung. Schnelle und effiziente Arbeit, sehr empfehlenswert.');
*/

/*
INSERT INTO Reparatur (fahrzeug_id, kunde_id, wunschtag_end, wunschtag_start, beschreibung)
VALUES (2, 2, '2024-09-15', '2024-09-10', 'keine Beschreibung');

INSERT INTO Reparatur (fahrzeug_id, kunde_id, wunschtag_end, wunschtag_start, beschreibung)
VALUES (3, 3,'2024-10-05', '2024-10-01', 'keine Beschreibung');

INSERT INTO Reparatur (fahrzeug_id, kunde_id, wunschtag_end, wunschtag_start, beschreibung)
VALUES (4, 4, '2024-11-20', '2024-11-15', 'keine Beschreibung');

INSERT INTO Reparatur (fahrzeug_id, kunde_id, wunschtag_end, wunschtag_start, beschreibung)
VALUES (5, 5, '2024-12-25', '2024-12-20', 'keine Beschreibung');

INSERT INTO Reparatur (fahrzeug_id, kunde_id, wunschtag_end, wunschtag_start, beschreibung)
VALUES (6, 6, '2024-07-30', '2024-07-25', 'keine Beschreibung');
*/



