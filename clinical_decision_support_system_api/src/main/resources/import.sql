-- Users
INSERT INTO user (username, password, email, role, first_name, last_name)
VALUES ('doc1', 'asd', 'WilliamSMarr@teleworm.us', 'DOCTOR', 'William', 'Marr');
INSERT INTO user (username, password, email, role, first_name, last_name)
VALUES ('doc2', 'asd', 'ShirleyRHogan@rhyta.com', 'DOCTOR', 'Shirley', 'Hogan');
INSERT INTO user (username, password, email, role, first_name, last_name)
VALUES ('admin', 'asd', 'drstevanovic@gmail.com', 'ADMIN', 'Drago', 'Stevanovic');
INSERT INTO user (username, password, email, role, first_name, last_name)
VALUES ('doc3', 'asd', 'JefferyWBaity@rhyta.com', 'DOCTOR', 'Jeffery', 'Baity');
INSERT INTO user (username, password, email, role, first_name, last_name)
VALUES ('doc4', 'asd', 'JoanEDiaz@teleworm.us', 'DOCTOR', 'Joan', 'Diaz');


-- symptoms
INSERT INTO symptom (id,name) VALUES (1, 'Curenje iz nosa');
INSERT INTO symptom (id,name) VALUES (2, 'Bol u grlu');
INSERT INTO symptom (id,name) VALUES (3, 'Glavobolja');
INSERT INTO symptom (id,name) VALUES (4, 'Kijanje');
INSERT INTO symptom (id,name) VALUES (5, 'Kasalj');

INSERT INTO symptom (id,name) VALUES (6, 'Temperatura veca od 38');
INSERT INTO symptom (id,name) VALUES (7, 'Drhtavica');

INSERT INTO symptom (id,name) VALUES (8, 'Bol koji se siri do usiju');
INSERT INTO symptom (id,name) VALUES (9, 'Temperatura izmedju 40 i 41');
INSERT INTO symptom (id,name) VALUES (10, 'Gubitak apetita');
INSERT INTO symptom (id,name) VALUES (11, 'Umor');
INSERT INTO symptom (id,name) VALUES (12, 'zuti sekret iz nosa');

INSERT INTO symptom (id,name) VALUES (13, 'Oticanje oko ociju');
INSERT INTO symptom (id,name) VALUES (14, 'cesto uriniranje');
INSERT INTO symptom (id,name) VALUES (15, 'Gubitak telesne tezine');
INSERT INTO symptom (id,name) VALUES (16, 'Zamor');
INSERT INTO symptom (id,name) VALUES (17, 'Mucnina i povracanje');

INSERT INTO symptom (id,name) VALUES (18, 'Nocturia');
INSERT INTO symptom (id,name) VALUES (19, 'Otoci nogu i zglobova');
INSERT INTO symptom (id,name) VALUES (20, 'Gusenje');
INSERT INTO symptom (id,name) VALUES (21, 'Bol u grudima');
INSERT INTO symptom (id,name) VALUES (22, 'Dijarea');
INSERT INTO symptom (id,name) VALUES (23, 'Oporavlja se od operacije');

INSERT INTO symptom (id,name) VALUES (24, 'Pacijent bolovao od prehlade ili groznice u poslednjih 60 dana');
INSERT INTO symptom (id,name) VALUES (25, 'U poslednjih 6 meseci zabelezeno barem 10 slucajeva u kojem je pacijent imao visok pritisak');
INSERT INTO symptom (id,name) VALUES (26, 'Pacijent boluje od hipertenzije vise od 6 meseci ');
INSERT INTO symptom (id,name) VALUES (27, 'Pacijent boluje od dijabetesa');
INSERT INTO symptom (id,name) VALUES (28, 'U poslednjih 14 dana dijagnostikovana bolest koja kao simptom ima povisenu telesnu temperaturu');
INSERT INTO symptom (id,name) VALUES (29, 'U poslednjih 21 dana dijagnostikovana bolest za koju je primao antibiotike');

--  1st group

-- Prehlada
INSERT INTO illness (id,name) VALUES (1, 'Prehlada');
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (true, 1, 1);
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (true, 1, 2);
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (true, 1, 3);
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (true, 1, 4);
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (true, 1, 5);

INSERT INTO illness (id,name) VALUES (2, 'Groznica');
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (true, 2, 4);
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (true, 2, 2);
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (true, 2, 5);
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (true, 2, 6);
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (true, 2, 1);
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (true, 2, 3);
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (true, 2, 7);

INSERT INTO illness (id,name) VALUES (3, 'Upala krajnika');
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (true, 3, 2);
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (true, 3, 8);
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (true, 3, 3);
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (true, 3, 9);
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (true, 3, 7);
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (true, 3, 10);
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (true, 3, 11);
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (true, 3, 12);

INSERT INTO illness (id,name) VALUES (4, 'Sinusna infekcija');
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (true, 4, 13);
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (true, 4, 3);
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (true, 4, 12);
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (true, 4, 2);
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (true, 4, 6);
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (true, 4, 5);
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (false, 4, 24);

-- 2nd group
INSERT INTO illness (id,name) VALUES (5, 'Hipertenzija');
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (true, 5, 25);

INSERT INTO illness (id,name) VALUES (6, 'Dijabetes');
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (true, 6, 14);
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (true, 6, 15);
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (true, 6, 16);
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (true, 6, 17);

INSERT INTO illness (id,name) VALUES (7, 'Hronicna bubrezna bolest');
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (true, 7, 16);
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (true, 7, 18);
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (true, 7, 19);
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (true, 7, 20);
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (true, 7, 21);
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (false, 7, 26);
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (false, 7, 27);

INSERT INTO illness (id,name) VALUES (8, 'Akutna bubrezna povreda');
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (true, 8, 16);
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (true, 8, 20);
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (true, 8, 19);
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (true, 8, 22);
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (false, 8, 23);
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (false, 8, 28);
INSERT INTO illness_symptom (ordinary, illness_id, symptom_id) VALUES (false, 8, 29);


INSERT INTO patient (id,jmbg, first_name, last_name)
VALUES (1, '2112995805065', 'James', 'Mendoza');
INSERT INTO patient (id,jmbg, first_name, last_name)
VALUES (2, '2112995805068', 'Karen', 'Riggs');
INSERT INTO patient (id,jmbg, first_name, last_name)
VALUES (3, '2112995805069', 'Richard', 'Foley');
INSERT INTO patient (id,jmbg, first_name, last_name)
VALUES (4, '2112995805045', 'John', 'Wilbanks');
INSERT INTO patient (id,jmbg, first_name, last_name)
VALUES (5, '2112995805075', 'Wilton', 'Candelaria');
INSERT INTO patient (id,jmbg, first_name, last_name)
VALUES (6, '2112995805055', 'Lawrence', 'Pratt');

INSERT INTO patient_allergic_ingredients (patient_id, allergic_ingredients)
VALUES ('1', 'sastojak1');
INSERT INTO patient_allergic_ingredients (patient_id, allergic_ingredients)
VALUES ('1', 'sastojak2');
INSERT INTO patient_allergic_ingredients (patient_id, allergic_ingredients)
VALUES ('1', 'sastojak3');
INSERT INTO patient_allergic_ingredients (patient_id, allergic_ingredients)
VALUES ('2', 'sastojak1');

INSERT INTO medicine (id,name, medicine_type)
VALUES (1, 'lek1', 'ANALGESIC');
INSERT INTO medicine (id,name, medicine_type)
VALUES (2, 'lek2', 'ANALGESIC');
INSERT INTO medicine (id,name, medicine_type)
VALUES (3, 'lek3', 'ANTIBIOTIC');
INSERT INTO medicine (id,name, medicine_type)
VALUES (4, 'lek4', 'ANTIBIOTIC');
INSERT INTO medicine (id,name, medicine_type)
VALUES (5, 'lek5', 'ANTIBIOTIC');
INSERT INTO medicine (id,name, medicine_type)
VALUES (6, 'lek6', 'ANALGESIC');
INSERT INTO medicine (id,name, medicine_type)
VALUES (7, 'lek7', 'OTHER');
INSERT INTO medicine (id,name, medicine_type)
VALUES (8, 'lek8', 'OTHER');
INSERT INTO medicine (id,name, medicine_type)
VALUES (9, 'lek9', 'OTHER');


INSERT INTO medicine_ingredients (medicine_id, ingredients)
VALUES ('1', 'sastojak1');
INSERT INTO medicine_ingredients (medicine_id, ingredients)
VALUES ('1', 'sastojak2');
INSERT INTO medicine_ingredients (medicine_id, ingredients)
VALUES ('1', 'sastojak3');
INSERT INTO medicine_ingredients (medicine_id, ingredients)
VALUES ('2', 'sastojak1');
INSERT INTO medicine_ingredients (medicine_id, ingredients)
VALUES ('2', 'sastojak2');
INSERT INTO medicine_ingredients (medicine_id, ingredients)
VALUES ('3', 'sastojak2');
INSERT INTO medicine_ingredients (medicine_id, ingredients)
VALUES ('3', 'sastojak3');
INSERT INTO medicine_ingredients (medicine_id, ingredients)
VALUES ('4', 'sastojak1');
INSERT INTO medicine_ingredients (medicine_id, ingredients)
VALUES ('5', 'sastojak4');
INSERT INTO medicine_ingredients (medicine_id, ingredients)
VALUES ('6', 'sastojak5');
INSERT INTO medicine_ingredients (medicine_id, ingredients)
VALUES ('7', 'sastojak7');
INSERT INTO medicine_ingredients (medicine_id, ingredients)
VALUES ('7', 'sastojak1');

--zadovoljava sinusnu infekciju, groznica manje od 60 dana (pacijent 1)
INSERT INTO medical_examination (id,date, illness_id, doctor_id)
VALUES (1, '2018-09-22 23:59:59', '2', '1');
--ne zadovoljava sinusnu infekciju, groznica proslo vise od 60 dana (pacijent 1)
INSERT INTO medical_examination (id,date, illness_id, doctor_id)
VALUES (2, '2017-01-14 23:59:59', '2', '2');
-- pacijent 1
INSERT INTO medical_examination (id,date, illness_id, doctor_id)
VALUES (3, '2018-06-14 23:59:59', '3', '2');
-- ne zadovoljava sinusnu infekciju, groznica proslo vise od 60 dana (pacijent 2)
INSERT INTO medical_examination (id,date, illness_id, doctor_id)
VALUES (4, '2018-04-14 23:59:59', '2', '1');

--hbb - hipertenzija vise od 6 meseci (pacijent 1)
INSERT INTO medical_examination (id,date, illness_id, doctor_id)
VALUES (5, '2017-04-14 23:59:59', '5', '1');

--hbb hipertenzija vise od 6 meseci - nije zadovoljeno (pacijent 2)
INSERT INTO medical_examination (id,date, illness_id, doctor_id)
VALUES (6, '2018-06-14 23:59:59', '5', '1');

--hbb dijabetes ikad - zadovoljeno (pacijent 3)
INSERT INTO medical_examination (id,date, illness_id, doctor_id)
VALUES (7, '2018-04-14 23:59:59', '6', '1');

--abb temperatura zadovoljena veca od -  zadovoljeno (pacijent 1)
INSERT INTO medical_examination (id,date, illness_id, doctor_id)
VALUES (8, '2018-06-14 23:59:59', '2', '1');

--abb temperatura zadovoljena veca od - nije zadovoljeno jer je vise od 14 dana proslo (pacijent 2)
INSERT INTO medical_examination (id,date, illness_id, doctor_id)
VALUES (9, '2018-05-14 23:59:59', '2', '1');

--abb temperatura zadovoljena izmedju 40 i 41 -  zadovoljeno (pacijent 3)
INSERT INTO medical_examination (id,date, illness_id, doctor_id)
VALUES (10, '2018-06-14 23:59:59', '3', '1');

-- lecen 5 puta od iste bolesti u poslednjih 2 godine(pacijent 4)
INSERT INTO medical_examination (id,date, illness_id, doctor_id)
VALUES (11, '2017-1-14 23:59:59', '5', '1');
INSERT INTO medical_examination (id,date, illness_id, doctor_id)
VALUES (12, '2017-10-14 23:59:59', '5', '1');
INSERT INTO medical_examination (id,date, illness_id, doctor_id)
VALUES (13, '2017-08-14 23:59:59', '5', '1');
INSERT INTO medical_examination (id,date, illness_id, doctor_id)
VALUES (14, '2018-02-14 23:59:59', '5', '1');
INSERT INTO medical_examination (id,date, illness_id, doctor_id)
VALUES (15, '2018-06-14 23:59:59', '5', '1');

-- lecen 5 puta od iste bolesti u poslednjih 2 godine(pacijent 5)
INSERT INTO medical_examination (id,date, illness_id, doctor_id)
VALUES (16, '2018-1-14 23:59:59', '5', '1');
INSERT INTO medical_examination (id,date, illness_id, doctor_id)
VALUES (17, '2018-1-14 23:59:59', '5', '1');
INSERT INTO medical_examination (id,date, illness_id, doctor_id)
VALUES (18, '2018-03-14 23:59:59', '5', '1');
INSERT INTO medical_examination (id,date, illness_id, doctor_id)
VALUES (19, '2018-02-14 23:59:59', '5', '2');
INSERT INTO medical_examination (id,date, illness_id, doctor_id)
VALUES (20, '2018-06-14 23:59:59', '5', '4');
INSERT INTO medical_examination (id,date, illness_id, doctor_id)
VALUES (21, '2018-06-14 23:59:59', '7', '5');
INSERT INTO medical_examination (id,date, illness_id, doctor_id)
VALUES (22, '2018-06-14 23:59:59', '5', '1');
INSERT INTO medical_examination (id,date, illness_id, doctor_id)
VALUES (23, '2018-06-14 23:59:59', '5', '1');
INSERT INTO medical_examination (id,date, illness_id, doctor_id)
VALUES (24, '2018-06-14 23:59:59', '5', '1');
INSERT INTO medical_examination (id,date, illness_id, doctor_id)
VALUES (25, '2018-06-14 23:59:59', '5', '1');
INSERT INTO medical_examination (id,date, illness_id, doctor_id)
VALUES (26, '2018-06-14 23:59:59', '5', '1');
INSERT INTO medical_examination (id,date, illness_id, doctor_id)
VALUES (27, '2018-06-14 23:59:59', '5', '1');



INSERT INTO patient_examinations (patient_id, examinations_id)
VALUES ( '1', '1');
INSERT INTO patient_examinations (patient_id, examinations_id)
VALUES ( '1', '2');
INSERT INTO patient_examinations (patient_id, examinations_id)
VALUES ( '1', '3');
INSERT INTO patient_examinations (patient_id, examinations_id)
VALUES ( '2', '4');
INSERT INTO patient_examinations (patient_id, examinations_id)
VALUES ( '1', '5');
INSERT INTO patient_examinations (patient_id, examinations_id)
VALUES ( '2', '6');
INSERT INTO patient_examinations (patient_id, examinations_id)
VALUES ( '3', '7');
INSERT INTO patient_examinations (patient_id, examinations_id)
VALUES ( '1', '8');
INSERT INTO patient_examinations (patient_id, examinations_id)
VALUES ( '2', '9');
INSERT INTO patient_examinations (patient_id, examinations_id)
VALUES ( '3', '10');


-- lecen 5 puta od iste bolesti u poslednjih 2 godine
INSERT INTO patient_examinations (patient_id, examinations_id)
VALUES ( '4', '11');
INSERT INTO patient_examinations (patient_id, examinations_id)
VALUES ( '4', '12');
INSERT INTO patient_examinations (patient_id, examinations_id)
VALUES ( '4', '13');
INSERT INTO patient_examinations (patient_id, examinations_id)
VALUES ( '4', '14');
INSERT INTO patient_examinations (patient_id, examinations_id)
VALUES ( '4', '15');

-- lecen 5 puta od iste bolesti u poslednjih 2 godine
INSERT INTO patient_examinations (patient_id, examinations_id)
VALUES ( '5', '16');
INSERT INTO patient_examinations (patient_id, examinations_id)
VALUES ( '5', '17');
INSERT INTO patient_examinations (patient_id, examinations_id)
VALUES ( '5', '18');
INSERT INTO patient_examinations (patient_id, examinations_id)
VALUES ( '5', '19');
INSERT INTO patient_examinations (patient_id, examinations_id)
VALUES ( '5', '20');
INSERT INTO patient_examinations (patient_id, examinations_id)
VALUES ( '5', '22');
INSERT INTO patient_examinations (patient_id, examinations_id)
VALUES ( '5', '23');
INSERT INTO patient_examinations (patient_id, examinations_id)
VALUES ( '5', '24');
INSERT INTO patient_examinations (patient_id, examinations_id)
VALUES ( '5', '25');
INSERT INTO patient_examinations (patient_id, examinations_id)
VALUES ( '5', '26');
INSERT INTO patient_examinations (patient_id, examinations_id)
VALUES ( '5', '27');


-- hbb za testiranje u monitoringu
INSERT INTO patient_examinations (patient_id, examinations_id)
VALUES ( '6', '21');

INSERT INTO medical_examination_medicines (medical_examination_id, medicines_id)
VALUES ( '1', '1');
INSERT INTO medical_examination_medicines (medical_examination_id, medicines_id)
VALUES ( '1', '2');
INSERT INTO medical_examination_medicines (medical_examination_id, medicines_id)
VALUES ( '2', '2');
INSERT INTO medical_examination_medicines (medical_examination_id, medicines_id)
VALUES ( '2', '4');
INSERT INTO medical_examination_medicines (medical_examination_id, medicines_id)
VALUES ( '3', '5');
INSERT INTO medical_examination_medicines (medical_examination_id, medicines_id)
VALUES ( '4', '8');

-- izvestaj 2 6 puta analgetici
INSERT INTO medical_examination_medicines (medical_examination_id, medicines_id)
VALUES ( '16', '2');
INSERT INTO medical_examination_medicines (medical_examination_id, medicines_id)
VALUES ( '17', '2');
INSERT INTO medical_examination_medicines (medical_examination_id, medicines_id)
VALUES ( '18', '2');
INSERT INTO medical_examination_medicines (medical_examination_id, medicines_id)
VALUES ( '19', '2');
INSERT INTO medical_examination_medicines (medical_examination_id, medicines_id)
VALUES ( '20', '2');
INSERT INTO medical_examination_medicines (medical_examination_id, medicines_id)
VALUES ( '22', '2');
INSERT INTO medical_examination_medicines (medical_examination_id, medicines_id)
VALUES ( '23', '3');
INSERT INTO medical_examination_medicines (medical_examination_id, medicines_id)
VALUES ( '24', '3');
INSERT INTO medical_examination_medicines (medical_examination_id, medicines_id)
VALUES ( '25', '3');


--abp lek antibiotic zadovoljen - pacijent 2
INSERT INTO medical_examination_medicines (medical_examination_id, medicines_id)
VALUES ( '6', '3');
--abp lek analgetic nije zadovoljen - pacijent 1
INSERT INTO medical_examination_medicines (medical_examination_id, medicines_id)
VALUES ( '8', '2');

INSERT INTO medical_examination_medicines (medical_examination_id, medicines_id)
VALUES ( '10', '3');





