DROP TABLE BOOKINGS;
DROP TABLE GUESTS;
DROP TABLE ROOMS;


CREATE TABLE ROOMS(
Room_id number(3) NOT NULL,
Room_size number(1) NOT NULL,
PRIMARY KEY (Room_id)
);

CREATE TABLE GUESTS(
Guest_id number(11) NOT NULL,
Firstname varchar2(255) NOT NULL,
Familyname varchar2(255) NOT NULL,
PRIMARY KEY (Guest_id)
);

CREATE TABLE BOOKINGS(
ID NUMBER(11) NOT NULL,
Start_date date NOT NULL,
End_date date NOT NULL,
Room_id number(3) NOT NULL,
Guest_id number(11) NOT NULL,
PRIMARY KEY (ID),
FOREIGN KEY (Room_id) REFERENCES ROOMS,
FOREIGN KEY (Guest_id) REFERENCES GUESTS
);


-- single rooms
INSERT INTO ROOMS VALUES (1,1);
INSERT INTO ROOMS VALUES (2,1);
INSERT INTO ROOMS VALUES (3,1);
INSERT INTO ROOMS VALUES (4,1);
INSERT INTO ROOMS VALUES (5,1);
INSERT INTO ROOMS VALUES (6,1);
INSERT INTO ROOMS VALUES (7,1);
INSERT INTO ROOMS VALUES (8,1);
INSERT INTO ROOMS VALUES (9,1);
INSERT INTO ROOMS VALUES (10,1);
INSERT INTO ROOMS VALUES (11,1);
INSERT INTO ROOMS VALUES (12,1);
INSERT INTO ROOMS VALUES (13,1);
INSERT INTO ROOMS VALUES (14,1);
INSERT INTO ROOMS VALUES (15,1);
INSERT INTO ROOMS VALUES (16,1);
INSERT INTO ROOMS VALUES (17,1);
INSERT INTO ROOMS VALUES (18,1);
INSERT INTO ROOMS VALUES (19,1);
INSERT INTO ROOMS VALUES (20,1);
INSERT INTO ROOMS VALUES (21,1);
INSERT INTO ROOMS VALUES (22,1);
INSERT INTO ROOMS VALUES (23,1);
INSERT INTO ROOMS VALUES (24,1); 
 
INSERT INTO ROOMS VALUES (25,2);
INSERT INTO ROOMS VALUES (26,2);
INSERT INTO ROOMS VALUES (27,2);
INSERT INTO ROOMS VALUES (28,2);
INSERT INTO ROOMS VALUES (29,2);
INSERT INTO ROOMS VALUES (30,2);
INSERT INTO ROOMS VALUES (31,2);
INSERT INTO ROOMS VALUES (32,2);
INSERT INTO ROOMS VALUES (33,2);
INSERT INTO ROOMS VALUES (34,2);
INSERT INTO ROOMS VALUES (35,2);
INSERT INTO ROOMS VALUES (36,2);
INSERT INTO ROOMS VALUES (37,2);
INSERT INTO ROOMS VALUES (38,2);
INSERT INTO ROOMS VALUES (39,2);
INSERT INTO ROOMS VALUES (40,2);
INSERT INTO ROOMS VALUES (41,2);
INSERT INTO ROOMS VALUES (42,2);
INSERT INTO ROOMS VALUES (43,2);
INSERT INTO ROOMS VALUES (44,2);
INSERT INTO ROOMS VALUES (45,2);
INSERT INTO ROOMS VALUES (46,2);
INSERT INTO ROOMS VALUES (47,2);
INSERT INTO ROOMS VALUES (48,2);
INSERT INTO ROOMS VALUES (49,2);
INSERT INTO ROOMS VALUES (50,2);
INSERT INTO ROOMS VALUES (51,2);
INSERT INTO ROOMS VALUES (52,2);
INSERT INTO ROOMS VALUES (53,2);
INSERT INTO ROOMS VALUES (54,2);
INSERT INTO ROOMS VALUES (55,2);
INSERT INTO ROOMS VALUES (56,2);
INSERT INTO ROOMS VALUES (57,2);
INSERT INTO ROOMS VALUES (58,2);
INSERT INTO ROOMS VALUES (59,2);
INSERT INTO ROOMS VALUES (60,2);
INSERT INTO ROOMS VALUES (61,2);
INSERT INTO ROOMS VALUES (62,2);
INSERT INTO ROOMS VALUES (63,2);
INSERT INTO ROOMS VALUES (64,2);
INSERT INTO ROOMS VALUES (65,2);
INSERT INTO ROOMS VALUES (66,2);
INSERT INTO ROOMS VALUES (67,2);
INSERT INTO ROOMS VALUES (68,2);
INSERT INTO ROOMS VALUES (69,2);
INSERT INTO ROOMS VALUES (70,2);



INSERT INTO ROOMS VALUES (71,5);
INSERT INTO ROOMS VALUES (72,5);
INSERT INTO ROOMS VALUES (73,5);
INSERT INTO ROOMS VALUES (74,5);
INSERT INTO ROOMS VALUES (75,5);
INSERT INTO ROOMS VALUES (76,5);
INSERT INTO ROOMS VALUES (77,5);
INSERT INTO ROOMS VALUES (78,5);
INSERT INTO ROOMS VALUES (79,5);
INSERT INTO ROOMS VALUES (80,5);
INSERT INTO ROOMS VALUES (81,5);
INSERT INTO ROOMS VALUES (82,5);
INSERT INTO ROOMS VALUES (83,5);
INSERT INTO ROOMS VALUES (84,5);
INSERT INTO ROOMS VALUES (85,5);
INSERT INTO ROOMS VALUES (86,5);
INSERT INTO ROOMS VALUES (87,5);
INSERT INTO ROOMS VALUES (88,5);
INSERT INTO ROOMS VALUES (89,5);
INSERT INTO ROOMS VALUES (90,5);
INSERT INTO ROOMS VALUES (91,5);
INSERT INTO ROOMS VALUES (92,5);
INSERT INTO ROOMS VALUES (93,5);
INSERT INTO ROOMS VALUES (94,5);
INSERT INTO ROOMS VALUES (95,5);
INSERT INTO ROOMS VALUES (96,5);
INSERT INTO ROOMS VALUES (97,5);
INSERT INTO ROOMS VALUES (98,5);
INSERT INTO ROOMS VALUES (99,5);
INSERT INTO ROOMS VALUES (100,5);
INSERT INTO ROOMS VALUES (101,5);
INSERT INTO ROOMS VALUES (102,5);
INSERT INTO ROOMS VALUES (103,5);
INSERT INTO ROOMS VALUES (104,5);
 
INSERT INTO GUESTS VALUES (1, 'Jakob', 'Andersen');
INSERT INTO GUESTS VALUES (2, 'Vuk', 'Rajovic');
INSERT INTO GUESTS VALUES (3, 'Damjan', 'Filipovic');
INSERT INTO GUESTS VALUES (4, 'Youssef', 'Ahmed');
INSERT INTO GUESTS VALUES (5, 'Lille', 'Ove');
INSERT INTO GUESTS VALUES (6, 'S?de', 'Holger');
INSERT INTO GUESTS VALUES (7, 'Abdul', 'Hasam');
INSERT INTO GUESTS VALUES (8, 'Jens', 'Larsen');
INSERT INTO GUESTS VALUES (9, 'Mikkel', 'Kessler');
 
 
INSERT INTO BOOKINGS VALUES (1, to_date('21-03-2014', 'DD-MM-YYYY'), to_date('28-03-2014','DD-MM-YYYY'), 1, 1);
INSERT INTO BOOKINGS VALUES (2, to_date('21-03-2014', 'DD-MM-YYYY'), to_date('29-03-2014','DD-MM-YYYY'), 2, 2);
INSERT INTO BOOKINGS VALUES (3, to_date('22-03-2014', 'DD-MM-YYYY'), to_date('25-03-2014','DD-MM-YYYY'), 3, 3);
INSERT INTO BOOKINGS VALUES (4, to_date('23-03-2014', 'DD-MM-YYYY'), to_date('31-03-2014','DD-MM-YYYY'), 10, 4);
INSERT INTO BOOKINGS VALUES (5, to_date('01-04-2014', 'DD-MM-YYYY'), to_date('07-04-2014','DD-MM-YYYY'), 66, 5);
INSERT INTO BOOKINGS VALUES (6, to_date('03-04-2014', 'DD-MM-YYYY'), to_date('21-04-2014','DD-MM-YYYY'), 88, 6);
INSERT INTO BOOKINGS VALUES (7, to_date('22-04-2014', 'DD-MM-YYYY'), to_date('28-04-2014','DD-MM-YYYY'), 66, 7);
INSERT INTO BOOKINGS VALUES (8, to_date('01-04-2014', 'DD-MM-YYYY'), to_date('07-04-2014','DD-MM-YYYY'), 66, 8);
INSERT INTO BOOKINGS VALUES (9, to_date('02-04-2014', 'DD-MM-YYYY'), to_date('09-04-2014','DD-MM-YYYY'), 1, 9);

commit;