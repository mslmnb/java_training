package com.epam.apartment;

import static com.epam.apartment.model.Direction.*;

import com.epam.apartment.model.*;

import java.util.Locale;

public class MainClass {
    public static void main(String[] args) {

        float heightApartment = 4;
        float doorHeight = 2.5f;
        float windowHeight = 2;
        float northAndSouthWidth = 7;
        float eastAndWestWidth = 9;
        float doorWidth = 1;
        float windowWidth = 3;

        Apartment apartment = new Apartment(heightApartment);

        for (int i = 0; i < 3; i++) {
            apartment.createRoom(northAndSouthWidth, eastAndWestWidth);
        }

        Room firstRoom = apartment.getRooms().get(0);
        apartment.createWallForRoom(firstRoom, NORTH);
        apartment.createWallForRoom(firstRoom, EAST);
        apartment.createWallForRoom(firstRoom, SOUTH);
        apartment.createWallForRoom(firstRoom, WEST);
        firstRoom.createDoor(EAST, doorHeight, doorWidth);
        firstRoom.createDoor(EAST, doorHeight, doorWidth);
        firstRoom.createDoor(EAST, doorHeight, doorWidth);
        firstRoom.createWindow(SOUTH, windowHeight, windowWidth);

        Room secondRoom = apartment.getRooms().get(1);
        apartment.createWallForRoom(secondRoom, NORTH);
        apartment.createWallForRoom(secondRoom, EAST);
        apartment.createWallForRoom(secondRoom, SOUTH);
        apartment.addWallForRoom(secondRoom, firstRoom.getWall(EAST), WEST);
        secondRoom.createDoor(EAST, doorHeight, doorWidth);
        secondRoom.createWindow(SOUTH, windowHeight, windowWidth);

        Room thirdRoom = apartment.getRooms().get(2);
        apartment.createWallForRoom(thirdRoom, NORTH);
        apartment.createWallForRoom(thirdRoom, EAST);
        apartment.createWallForRoom(thirdRoom, SOUTH);
        apartment.addWallForRoom(thirdRoom, secondRoom.getWall(EAST), WEST);
        thirdRoom.createWindow(SOUTH, windowHeight, windowWidth);

        System.out.println();
        System.out.println(apartment);
        System.out.println("площадь apartment: " + apartment.getSquare());
        System.out.println("периметр apartment: " + apartment.getPerimeter());
        System.out.println("список дверей: " + apartment.getDoors());
        System.out.println("список окон: " + apartment.getWindows());

        System.out.println();
        for (Room room : apartment.getRooms()) {
            System.out.println(room);
            System.out.println("площадь room: " + room.getSquare());
            System.out.println("периметр room: " + room.getPerimeter());
            System.out.println(room.getDoors());
            System.out.println(room.getWindows());
            System.out.println();
        }

        System.out.println("******* Тестирование некорректных входных данных *******");

        System.out.println("1. Попытка создать слишком высокую дверь");
        try {
            secondRoom.createDoor(EAST, heightApartment, doorWidth);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("2. Попытка повторно добавить ту же стену");
        try {
            apartment.addWallForRoom(thirdRoom, secondRoom.getWall(EAST), WEST);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("3. Попытка создать квартиру с нулевой высотой");
        try {
            apartment = new Apartment(0);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

/*
Apartment{height=4.0, rooms=2, 3, 4}
площадь apartment: 189.0
периметр apartment: 60.0
список дверей: [Door{id=16}, Door{id=9}, Door{id=10}, Door{id=11}]
список окон: [Window{id=17}, Window{id=21}, Window{id=12}]

Room{id=2, northAndSouthWidth=7.0, eastAndWestWidth=9.0, walls=7, 6, 5, 8, apartmentId=1}
площадь room: 63.0
периметр room: 32.0
[Door{id=9}, Door{id=10}, Door{id=11}]
[Window{id=12}]

Room{id=3, northAndSouthWidth=7.0, eastAndWestWidth=9.0, walls=15, 14, 13, 6, apartmentId=1}
площадь room: 63.0
периметр room: 32.0
[Door{id=16}, Door{id=9}, Door{id=10}, Door{id=11}]
[Window{id=17}]

Room{id=4, northAndSouthWidth=7.0, eastAndWestWidth=9.0, walls=20, 19, 18, 14, apartmentId=1}
площадь room: 63.0
периметр room: 32.0
[Door{id=16}]
[Window{id=21}]

******* Тестирование некорректных входных данных *******
1. Попытка создать слишком высокую дверь
Недопустимое значение height
2. Попытка повторно добавить ту же стену
Объект wall уже добавлен в объект Room
3. Попытка создать квартиру с нулевой высотой
Значение height должно быть положительно
 */