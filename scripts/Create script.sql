DROP TABLE FBOOKING_GUESTS;
DROP TABLE FACILITYBOOKING;
DROP TABLE INSTRUCTOR;
DROP TABLE FACILITY;
DROP TABLE BOOKINGS_GUESTS;
DROP TABLE BOOKINGS;
DROP TABLE TRAVELAGENCY_GUESTS;
DROP TABLE GUESTS;
DROP TABLE TRAVELAGENCY;
DROP TABLE ROOMS;

CREATE TABLE ROOMS(
Room_id number(3) NOT NULL,
Room_size number(1) NOT NULL,
PRIMARY KEY (Room_id)
);

CREATE TABLE TRAVELAGENCY(
ID NUMBER(2) NOT NULL,
Name varchar2(255) NOT NULL,
Country varchar2(255) ,
Phone number(22) ,
Email varchar2(255) ,
PRIMARY KEY (ID)
);

CREATE TABLE GUESTS(
Guest_id number(11) NOT NULL,
Firstname varchar2(50) NOT NULL,
Familyname varchar2(50) NOT NULL,
Address varchar2(55) NOT NULL,
Country varchar2(50) NOT NULL,
Phone number(22),
Email varchar2(55),
Age number(3) NOT NULL,
username varchar2(20),
password varchar2(20),
PRIMARY KEY (Guest_id)
);

CREATE TABLE TRAVELAGENCY_GUESTS(
TRAVEL_ID NUMBER(2) NOT NULL,
GUEST_ID NUMBER(11) NOT NULL,
PRIMARY KEY (TRAVEL_ID, GUEST_ID),
FOREIGN KEY (TRAVEL_ID) REFERENCES TRAVELAGENCY,
FOREIGN KEY (GUEST_ID) REFERENCES GUESTS ON delete cascade
);

CREATE TABLE BOOKINGS(
ID NUMBER(11) NOT NULL,
Start_date date NOT NULL,
End_date date NOT NULL,
Room_id number(3) NOT NULL,
Deposit_paid varchar2(3) NOT NULL,
Reg_date date NOT NULL,
PRIMARY KEY (ID),
FOREIGN KEY (Room_id) REFERENCES ROOMS
);

CREATE TABLE BOOKINGS_GUESTS(
BOOKING_ID NUMBER(11) NOT NULL,
GUEST_ID NUMBER(11) NOT NULL,
PRIMARY KEY (BOOKING_ID, GUEST_ID),
FOREIGN KEY (BOOKING_ID) REFERENCES BOOKINGS,
FOREIGN KEY (GUEST_ID) REFERENCES GUESTS on delete cascade
);

CREATE TABLE FACILITY(
ID number(11) not null,
name varchar2(30) not null,
Courts number (2) not null,
Players number (2),
PRIMARY KEY (ID)
);

CREATE TABLE INSTRUCTOR(
ID number(11) NOT NULL,
Name varchar2(255) NOT NULL,
Lastname varchar2(255) NOT NULL,
Email varchar2(255) NOT NULL,
Phone number(22) NOT NULL,
Sport varchar2(255) NOT NULL,
PRIMARY KEY (ID)
);

CREATE TABLE FACILITYBOOKING(
ID NUMBER(11) NOT NULL,
Start_date date NOT NULL,
End_date date NOT NULL,
FID number(3) NOT NULL,
IID number(11),
Reg_date date NOT NULL,
PRIMARY KEY (ID),
FOREIGN KEY (FID) REFERENCES FACILITY,
FOREIGN KEY (IID) REFERENCES INSTRUCTOR
);

CREATE TABLE FBOOKING_GUESTS(
FID number(11) NOT NULL,
GID number(11) NOT NULL,
PRIMARY KEY (FID, GID),
FOREIGN KEY (FID) REFERENCES FACILITYBOOKING ON delete cascade,
FOREIGN KEY (GID) REFERENCES GUESTS
);

drop sequence guestseq;
create sequence guestseq start with 1;

drop sequence bookingseq;
create sequence bookingseq start with 1;

drop sequence facilitybseq;
create sequence facilitybseq start with 1;

drop sequence instructorseq;
create sequence instructorseq start with 1;