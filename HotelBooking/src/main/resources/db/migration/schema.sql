DROP TABLE IF EXISTS ChicagoMotel;
DROP TABLE IF EXISTS NYMotel;
DROP TABLE IF EXISTS LAMotel;
DROP TABLE IF EXISTS DenverMotel;
DROP TABLE IF EXISTS Motels;
DROP TABLE IF EXISTS Rooms;


create table Motels {
    motelcode int,
    citySt varchar(50),
    primary key (motelcode),
};

create table Rooms (
    roomcode int,
    roomType varchar(50),
    cost decimal (10,2),
    primary key (roomcode),
);

create table ChicagoMotel (
    motelcode int,
    roomNum int,
    citySt varchar(50),
    roomType varchar(50),
    roomcode int,
    primary key (motelcode) 
    foreign key (motelcode) references Motels(motelcode),
    foreign key (roomcode) references Rooms(roomcode),
);

create table NYMotel (
    motelcode int,
    roomNum int,
    citySt varchar(50),
    roomType varchar(50),
    roomcode int,
    primary key (motelcode) 
    foreign key (motelcode) references Motels(motelcode),
    foreign key (roomcode) references Rooms(roomcode),
);

create table LAMotel (
    motelcode int,
    roomNum int,
    citySt varchar(50),
    roomType varchar(50),
    roomcode int,
    primary key (motelcode) 
    foreign key (motelcode) references Motels(motelcode),
    foreign key (roomcode) references Rooms(roomcode),
);

create table DenverMotel (
    motelcode int,
    roomNum int,
    citySt varchar(50),
    roomType varchar(50),
    roomCode int,
    primary key (motelcode) 
    foreign key (motelcode) references Motels(motelcode),
    foreign key (roomcode) references Rooms(roomcode),
); 