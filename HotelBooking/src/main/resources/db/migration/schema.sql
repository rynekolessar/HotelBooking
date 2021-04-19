DROP TABLE IF EXISTS hotels;
DROP TABLE IF EXISTS rooms;
DROP TABLE IF EXISTS guests;

create table hotels (
    id serial primary key,
    roomNum int,
    citySt varchar(50)
    roomType varchar(50),
);

create table rooms (
    id serial primary key,
    roomType varchar(50),
    cost decimal (10,2),
);

create table guests (
    if INT AUTO_INCREMENT PRIMARY KEY.
    guest_id VARCHAR(10),
    name VARCHAR(50),
    email VARCHAR(50),
    admitted_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (ID)
);

    