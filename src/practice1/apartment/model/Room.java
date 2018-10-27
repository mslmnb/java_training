package practice1.apartment.model;

import practice1.apartment.exception.ForbiddenChangeException;
import practice1.apartment.exception.UnacceptableValueException;

import java.util.*;
import java.util.stream.Collectors;

public class Room extends BaseEntity {
    private float northAndSouthWidth;
    private float eastAndWestWidth;
    private Map<Direction, Wall> walls = new HashMap<>();
    private Apartment apartment;

    Room(Apartment apartment, float northAndSouthWidth, float eastAndWestWidth) throws UnacceptableValueException, ForbiddenChangeException {
        if (apartment==null) {
            throw new UnacceptableValueException("Недопустимое значение apartment при создании объекта Room");
        }
        if (northAndSouthWidth<=0) {
            throw new UnacceptableValueException("Недопустимое значение northAndSouthWidth при создании объекта Room");
        }
        if (eastAndWestWidth<=0) {
            throw new UnacceptableValueException("Недопустимое значение eastAndWestWidth при создании объекта Room");
        }
        this.northAndSouthWidth = northAndSouthWidth;
        this.eastAndWestWidth = eastAndWestWidth;
        this.apartment = apartment;
    }

    Apartment getApartment() {
        return apartment;
    }

    void setApartment(Apartment apartment) throws UnacceptableValueException {
        if (apartment==null) {
            throw new UnacceptableValueException("Недопустимое значение apartment при изменении объекта Room");
        }
        this.apartment = apartment;
    }

    public float getHeight() {
        return apartment==null ? 0 : apartment.getHeight();
    }

    public float getNorthAndSouthWidth() {
        return northAndSouthWidth;
    }

    public float getEastAndWestWidth() {
        return eastAndWestWidth;
    }

    Map<Direction, Wall> getWalls() {
        return walls;
    }

    void addWall(Wall wall, Direction direction) throws ForbiddenChangeException, UnacceptableValueException {
        if (wall==null) {
            throw new UnacceptableValueException("Неопределен объект wall при изменении объекта Room");
        }
        if (direction==null) {
            throw new UnacceptableValueException("Неопределен объект direction при изменении объекта Room");
        }
        wall.addRoom(this, direction);
        walls.put(direction, wall);
        // добавить проверку дублирования по id объекта wall в одной комнате
    }

    public float getSquare() {
        return northAndSouthWidth*eastAndWestWidth;
    }

    public float getPerimeter() {
        return 2*(northAndSouthWidth+eastAndWestWidth);
    }

    public Set<Door> getDoors() {
        Set<Door> doors = new HashSet<>();
        for (Wall wall: walls.values()) {
            doors.addAll(wall.getDoors());
        }
        return doors;
    }

    public Set<Window> getWindows () {
        Set<Window> windows =  new HashSet<>();
        for (Wall wall: walls.values()) {
            windows.addAll(wall.getWindows());
        }
        return windows;
    }

    public Set<Wall> getWallSet() {
        Set<Wall> walls = new HashSet<>();
        walls.addAll(this.walls.values());
        return walls;
    }


    @Override
    public String toString() {
        return "Room{" +
                "id=" + getId() +
                ", northAndSouthWidth=" + northAndSouthWidth +
                ", eastAndWestWidth=" + eastAndWestWidth +
                ", walls=" + walls.values().stream().map(wall -> wall.getId().toString()).collect(Collectors.joining(", ")) +
                ", apartmentId=" + apartment.getId() +
                '}';
    }
}


