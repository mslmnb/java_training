package practice1.apartment;

import practice1.apartment.exception.ForbiddenChangeException;
import practice1.apartment.exception.UnacceptableValueException;
import practice1.apartment.model.*;

import static practice1.apartment.model.Direction.*;

public class MainClass {
    public static void main(String[] args) throws UnacceptableValueException, ForbiddenChangeException {

        Wall[] walls = new Wall[10];
        for (int i=0; i<10; i++) {
            walls[i] = new Wall();
        }

        Door[] doors = new Door[5];
        for (int i=0; i<5; i++) {
            doors[i] = new Door();
        }
        walls[3].addDoor(doors[0]);
        walls[3].addDoor(doors[1]);
        walls[3].addDoor(doors[2]);
        walls[4].addDoor(doors[3]);
        walls[6].addDoor(doors[4]);


        Window[] windows = new Window[3];
        for (int i=0; i<3; i++) {
            windows[i] = new Window();
        }
        walls[2].addWindow(windows[0]);
        walls[5].addWindow(windows[1]);
        walls[8].addWindow(windows[2]);

        float height = 4;
        float northAndSouthWidth = 7;
        float eastAndWestWidth = 9;
        Apartment apartment = new Apartment(height);

        for(int i=0; i<3; i++) {
            apartment.addNewRoom(northAndSouthWidth, eastAndWestWidth);
        }

        apartment.addWallForRoom(apartment.getRooms().get(0),walls[0], NORTH);
        apartment.addWallForRoom(apartment.getRooms().get(0),walls[1], EAST);
        apartment.addWallForRoom(apartment.getRooms().get(0),walls[2], SOUTH);
        apartment.addWallForRoom(apartment.getRooms().get(0),walls[3], WEST);

        apartment.addWallForRoom(apartment.getRooms().get(1),walls[4], NORTH);
        apartment.addWallForRoom(apartment.getRooms().get(1),walls[3], EAST);
        apartment.addWallForRoom(apartment.getRooms().get(1),walls[5], SOUTH);
        apartment.addWallForRoom(apartment.getRooms().get(1),walls[6], WEST);

        apartment.addWallForRoom(apartment.getRooms().get(2),walls[7], NORTH);
        apartment.addWallForRoom(apartment.getRooms().get(2),walls[6], EAST);
        apartment.addWallForRoom(apartment.getRooms().get(2),walls[8], SOUTH);
        apartment.addWallForRoom(apartment.getRooms().get(2),walls[9], WEST);


        for (Wall wall: walls) {
            System.out.println(wall);
        }

        for (Room room: apartment.getRooms()) {
            System.out.println(room);
            System.out.println("площадь room: " + room.getSquare());
            System.out.println("периметр room: " + room.getPerimeter());
        }
        System.out.println(apartment);
        System.out.println("площадь apartment: " + apartment.getSquare());
        System.out.println("периметр apartment: " + apartment.getPerimeter());
        System.out.println("список дверей: " + apartment.getDoors());
        System.out.println("список окон: " + apartment.getWindows());

    }
}
