package practice1.apartment.model;

import practice1.apartment.exception.ForbiddenChangeException;
import practice1.apartment.exception.UnacceptableValueException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Apartment extends BaseEntity  {
    private float height;
    private List<Room> rooms = new ArrayList<>();

    public Apartment(float height) throws UnacceptableValueException {
        if (height<=0) {
            throw new UnacceptableValueException("Недопустимое значение height при создании объекта Apartment");
        }
        this.height = height;
    }

    public float getHeight() {
        return height;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    // добавить метод deleteRoom(Room room)

    public Room addNewRoom(float northAndSouthWidth, float eastAndWestWidth) throws ForbiddenChangeException, UnacceptableValueException {
        Room room = new Room(this, northAndSouthWidth, eastAndWestWidth);
        rooms.add(room);
        return room;
    }


    public void addWallForRoom(Room room, Wall wall, Direction direction) throws UnacceptableValueException, ForbiddenChangeException {

        if (room==null || (!rooms.contains(room))) {
            throw new UnacceptableValueException("Недопустимое значение room при обновлении объекта apartment");
        }
        if (wall==null) {
            throw new UnacceptableValueException("Недопустимое значение wall при обновлении объекта apartment");
        }
        if (direction==null) {
            throw new UnacceptableValueException("Недопустимое значение direction при обновлении объекта apartment");
        }
        room.addWall(wall, direction);
    }

    public float getSquare() {
        return rooms.size()==0 ? 0 : rooms.stream().map(room->room.getSquare()).reduce((x,y)-> x+y).get();
    }

    public Set<Door> getDoors() {
        Set<Door> doors = new HashSet<>();
        for (Room room: rooms) {
            doors.addAll(room.getDoors());
        }
        return doors;
    }

    public Set<Window> getWindows () {
        Set<Window> windows =  new HashSet<>();
        for (Room room: rooms) {
            windows.addAll(room.getWindows());
        }
        return windows;
    }

    public Set<Wall> getWalls () {
        Set<Wall> walls = new HashSet<>() ;
        for (Room room: rooms) {
            walls.addAll(room.getWallSet());
        }
        return walls;
    }

    public float getPerimeter () {
        float perimeter = 0;
        for (Wall wall: getWalls()) {
            if (wall.getRooms().size()==1) {
                perimeter = perimeter + wall.getWidth();
            }
        }
        return perimeter;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "height=" + height +
                ", rooms=" + rooms.stream().map(room->room.getId().toString()).collect(Collectors.joining(", ")) +
                '}';
    }
}
