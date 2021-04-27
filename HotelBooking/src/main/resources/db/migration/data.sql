INSERT INTO Motels(motelcode, citySt) VALUES
    (100, 'Chicago, IL'),
    (200, 'Los Angeles, CA'),
    (300, 'New York, NY'),
    (400, 'Denver, CO');

INSERT INTO Rooms(roomcode, roomType, cost) VALUES
    (001, 'Suite', 200.00),
    (002, 'King', 100.00),
    (003, 'Queen', 50.00);

INSERT INTO ChicagoMotel(motelcode, roomNum, citySt, roomType, roomcode) VALUES
    (100, 2, 'Chicago, IL', 'Suite', 001),
    (100, 5, 'Chicago, IL', 'King', 002),
    (100, 10, 'Chicago, IL', 'Queen', 003);

INSERT INTO LAMotel(motelcode, roomNum, citySt, roomType, roomcode) VALUES
    (200, 2, 'Los Angeles, CA', 'Suite', 001),
    (200, 5, 'Los Angeles, CA', 'King', 002),
    (200, 10, 'Los Angeles, CA', 'Queen', 003),

INSERT INTO NYMotel(motelcode, roomNum, citySt, roomType, roomcode) VALUES
    (300, 2, 'New York, NY', 'Suite', 001),
    (300, 5, 'New York, NY', 'King', 002),
    (300, 10, 'New York, NY', 'Queen', 003);

INSERT INTO DenverMotel(id, roomNum, citySt, roomType, roomcode) VALUES
    (400, 2, 'New York, NY', 'Suite', 001),
    (400, 5, 'New York, NY', 'King', 001),
    (400, 10, 'New York, NY', 'Queen', 001);
