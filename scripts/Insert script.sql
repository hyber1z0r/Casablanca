alter session set nls_date_format = 'dd-mm-yyyy hh24';
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
 
-- double rooms
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


-- family rooms
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
 
 
INSERT INTO TRAVELAGENCY VALUES (1, 'Spies', 'Sweden', 282828282, 'spies@spies.se');
INSERT INTO TRAVELAGENCY VALUES (2, 'Falk Lauritzen', 'Norway', 2029293021, 'fl@fl.no');
INSERT INTO TRAVELAGENCY VALUES (3, 'Albatros Travel', 'Denmark', 29293837, 'at@at.dk');
INSERT INTO TRAVELAGENCY VALUES (4, 'Travel Link', 'USA', 5558283239, 'tl@tl.com');
INSERT INTO TRAVELAGENCY VALUES (5, 'Private booking', null, null, null);

INSERT INTO FACILITY VALUES (1, 'Tennis', 1, 4);
INSERT INTO FACILITY VALUES (2, 'Tennis', 2, 4);
INSERT INTO FACILITY VALUES (3, 'Tennis', 3, 4);
INSERT INTO FACILITY VALUES (4, 'Tennis', 4, 4);
INSERT INTO FACILITY VALUES (5, 'Tennis', 5, 4);
INSERT INTO FACILITY VALUES (6, 'Tennis', 6, 4);
INSERT INTO FACILITY VALUES (7, 'Volleyball', 1, 10);
INSERT INTO FACILITY VALUES (8, 'Volleyball', 2, 10);
INSERT INTO FACILITY VALUES (9, 'Golf', 1, null);
INSERT INTO FACILITY VALUES (10, 'Badminton', 1, 4);
INSERT INTO FACILITY VALUES (11, 'Badminton', 2, 4);
INSERT INTO FACILITY VALUES (12, 'Badminton', 3, 4);
INSERT INTO FACILITY VALUES (13, 'Badminton', 4, 4);
INSERT INTO FACILITY VALUES (14, 'Swimming', 1, null);
INSERT INTO FACILITY VALUES (15, 'Fitness', 1, 20);
INSERT INTO FACILITY VALUES (16, 'Handball', 1, 12);
INSERT INTO FACILITY VALUES (17, 'Handball', 2, 12);

COMMIT;