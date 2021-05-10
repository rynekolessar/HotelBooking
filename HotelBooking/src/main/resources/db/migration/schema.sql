DROP TABLE IF EXISTS ChicagoMotel;
DROP TABLE IF EXISTS NYMotel;
DROP TABLE IF EXISTS LAMotel;
DROP TABLE IF EXISTS DenverMotel;
DROP TABLE IF EXISTS Motels;
DROP TABLE IF EXISTS Rooms;


create table Motels (
    motelcode int,
    citySt varchar(50),
    primary key (motelcode)
);


create table Rooms (
    roomcode int,
    roomType varchar(50),
    cost decimal (10,2),
    primary key (roomcode)
);


create table ChicagoMotel (
    chicagocode int,
    roomNum int,
    citySt varchar(50),
    roomType varchar(50),
    roomcode int,
    primary key (roomcode), 
    foreign key (chicagocode) references Motels(motelcode),
    foreign key (roomcode) references Rooms(roomcode)
);


create table NYMotel (
    nycode int,
    roomNum int,
    citySt varchar(50),
    roomType varchar(50),
    roomcode int,
    primary key (roomcode), 
    foreign key (nycode) references Motels(motelcode),
    foreign key (roomcode) references Rooms(roomcode)
);


create table LAMotel (
    lacode int,
    roomNum int,
    citySt varchar(50),
    roomType varchar(50),
    roomcode int,
    primary key (roomcode),
    foreign key (lacode) references Motels(motelcode),
    foreign key (roomcode) references Rooms(roomcode)
);


create table DenverMotel (
    denvercode int,
    roomNum int,
    citySt varchar(50),
    roomType varchar(50),
    roomCode int,
    primary key (roomcode),
    foreign key (denvercode) references Motels(motelcode),
    foreign key (roomcode) references Rooms(roomcode)
);