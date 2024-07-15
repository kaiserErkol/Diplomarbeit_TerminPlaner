CREATE SEQUENCE kunde_id_seq AS INT START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE mechaniker_id_seq AS INT START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE verwalter_id_seq AS INT START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE fahrzeug_id_seq AS INT START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE reapartur_id_seq AS INT START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE reparaturtyp_id_seq AS INT START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE reparatureintrag_id_seq AS INT START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE feedback_id_seq AS INT START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE kostenvrs_id_seq AS INT START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE leihfahrzeug_id_seq AS INT START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE leihvertrag_id_seq AS INT START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE terminvrs_id_seq AS INT START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE termin_id_seq AS INT START WITH 1 INCREMENT BY 1;

CREATE TABLE kunde (
    kunde_id INT NOT NULL DEFAULT NEXT VALUE FOR kunde_id_seq,
    vorname VARCHAR(250),
    nachname VARCHAR(250),
    email VARCHAR(250),
    telefonnummer VARCHAR(250),
    adresse VARCHAR(250),
    PRIMARY KEY (kunde_id)
);

CREATE TABLE mechaniker (
    mechaniker_id INT NOT NULL DEFAULT NEXT VALUE FOR mechaniker_id_seq,
    namekrzl      VARCHAR(250),
    vorname       VARCHAR(250),
    nachname      VARCHAR(250),
    telefonnummer VARCHAR(250),
    email         VARCHAR(250),
    adresse       VARCHAR(250),
    PRIMARY KEY (mechaniker_id)
);

CREATE TABLE verwalter (
    verwalter_id  INT NOT NULL DEFAULT NEXT VALUE FOR verwalter_id_seq,
    namekrzl      VARCHAR(250),
    vorname       VARCHAR(250),
    nachname      VARCHAR(250),
    telefonnummer VARCHAR(250),
    email         VARCHAR(250),
    adresse       VARCHAR(250),
    PRIMARY KEY (verwalter_id)
);

CREATE TABLE fahrzeug (
    fahrzeug_id INT NOT NULL DEFAULT NEXT VALUE FOR fahrzeug_id_seq,
    kennzeichen VARCHAR(250),
    marke VARCHAR(250),
    modell VARCHAR(250),
    baujahr DATE,
    zulassungsschein_root VARCHAR(250),
    PRIMARY KEY (fahrzeug_id)
);

CREATE TABLE leihfahrzeug (
    leihf_id    INT NOT NULL DEFAULT NEXT VALUE FOR leihfahrzeug_id_seq,
    kennzeichen VARCHAR(250),
    marke       VARCHAR(250),
    modell      VARCHAR(250),
    besetzt     CHAR(1),
    PRIMARY KEY (leihf_id)
);

CREATE TABLE leihvertrag (
    vertrag_id            INT NOT NULL DEFAULT NEXT VALUE FOR leihvertrag_id_seq,
    ausleihdatum          DATE,
    rueckgabedatum        DATE,
    k_kunde_id INT NOT NULL,
    lf_leihf_id INT NOT NULL,
    PRIMARY KEY (vertrag_id),
    FOREIGN KEY (k_kunde_id) REFERENCES kunde (kunde_id),
    FOREIGN KEY (lf_leihf_id) REFERENCES leihfahrzeug (leihf_id)
);

CREATE UNIQUE INDEX leihvertrag__idx ON leihvertrag (k_kunde_id);
CREATE UNIQUE INDEX leihvertrag__idxv1 ON leihvertrag (lf_leihf_id);

CREATE TABLE reparaturtyp (
    retyp_id       INT NOT NULL,
    bezeichnung    VARCHAR(250),
    dauerinmin     INT,
    klassifikation VARCHAR(250),
    PRIMARY KEY (retyp_id)
);

CREATE TABLE reparatur (
    reparatur_id INT NOT NULL DEFAULT NEXT VALUE FOR reapartur_id_seq,
    beschreibung VARCHAR(250),
    k_kunde_id INT NOT NULL,
    f_fahrzeug_id INT NOT NULL,
    rt_reptyp_id INT NOT NULL,
    PRIMARY KEY (reparatur_id),
    FOREIGN KEY (k_kunde_id) REFERENCES kunde (kunde_id),
    FOREIGN KEY (f_fahrzeug_id) REFERENCES fahrzeug (fahrzeug_id),
    FOREIGN KEY (rt_reptyp_id) REFERENCES reparaturtyp (retyp_id)
);

CREATE TABLE reparatur_e (
    eintrag_id             INT NOT NULL DEFAULT NEXT VALUE FOR reparatureintrag_id_seq,
    beschreibung           VARCHAR(250),
    abschlussdatum         DATE,
    status                 VARCHAR(250),
    r_reparatur_id         INT NOT NULL,
    v_verwalter_id         INT NOT NULL,
    PRIMARY KEY (eintrag_id),
    FOREIGN KEY (r_reparatur_id) REFERENCES reparatur (reparatur_id),
    FOREIGN KEY (v_verwalter_id) REFERENCES verwalter (verwalter_id)
);

CREATE UNIQUE INDEX reparature__idx ON reparatur_e (r_reparatur_id);

CREATE TABLE feedback (
    feedback_id            INT NOT NULL DEFAULT NEXT VALUE FOR feedback_id_seq,
    bewertung              VARCHAR(250),
    kommentar              VARCHAR(250),
    r_reparatur_id         INT NOT NULL,
    PRIMARY KEY (feedback_id),
    FOREIGN KEY (r_reparatur_id) REFERENCES reparatur (reparatur_id)
);

CREATE TABLE kostenvrs (
    kostenvrs_id           INT NOT NULL DEFAULT NEXT VALUE FOR kostenvrs_id_seq,
    datum                  DATE,
    kosten                 DOUBLE PRECISION,
    beschreibung           VARCHAR(250),
    r_reparatur_id INT NOT NULL,
    PRIMARY KEY (kostenvrs_id),
    FOREIGN KEY (r_reparatur_id) REFERENCES reparatur (reparatur_id)
);

CREATE UNIQUE INDEX kostenvrs__idx ON kostenvrs (r_reparatur_id);

CREATE TABLE terminvrs (
    terminvrs_id           INT NOT NULL,
    datum                  DATE,
    uhrzeit                DATE,
    bestaetigt             CHAR(1),
    kvrs_kostenvrs_id INT NOT NULL,
    k_kunde_id        INT NOT NULL,
    PRIMARY KEY (terminvrs_id),
    FOREIGN KEY (kvrs_kostenvrs_id) REFERENCES kostenvrs (kostenvrs_id),
    FOREIGN KEY (k_kunde_id) REFERENCES kunde (kunde_id)
);

CREATE TABLE termin (
    termin_id              INT NOT NULL DEFAULT NEXT VALUE FOR termin_id_seq,
    datum                  DATE,
    uhrzeit                TIME,
    status                 VARCHAR(250),
    r_reparatur_id INT NOT NULL,
    tvrs_terminvrs_id INT NOT NULL,
    v_verwalter_id INT NOT NULL,
    PRIMARY KEY (termin_id),
    FOREIGN KEY (r_reparatur_id) REFERENCES reparatur (reparatur_id),
    FOREIGN KEY (tvrs_terminvrs_id) REFERENCES terminvrs (terminvrs_id),
    FOREIGN KEY (v_verwalter_id) REFERENCES verwalter (verwalter_id)
);

CREATE UNIQUE INDEX termin__idx ON termin (tvrs_terminvrs_id);
CREATE UNIQUE INDEX termin__idxv1 ON termin (r_reparatur_id);

CREATE TABLE tm_me (
    t_termin_id         INT NOT NULL,
    m_mechaniker_id INT NOT NULL,
    PRIMARY KEY (t_termin_id, m_mechaniker_id),
    FOREIGN KEY (m_mechaniker_id) REFERENCES mechaniker (mechaniker_id),
    FOREIGN KEY (t_termin_id) REFERENCES termin (termin_id)
);



