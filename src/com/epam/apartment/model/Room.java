package com.epam.apartment.model;

import java.util.*;
import java.util.stream.Collectors;

import static com.epam.apartment.Utilities.checkIsPositive;
import static com.epam.apartment.Utilities.checkNull;

public class Room extends BaseEntity {
    private float northAndSouthWidth;
    private float eastAndWestWidth;
    private Map<Direction, Wall> walls = new HashMap<>();
    private Apartment apartment;

    Room(Apartment apartment, float northAndSouthWidth, float eastAndWestWidth) {
        checkNull(apartment, "Неопределен объект apartment.");
        checkIsPositive(northAndSouthWidth, "Значение northAndSouthWidth должно быть положительно");
        checkIsPositive(eastAndWestWidth, "Значение eastAndWestWidth должно быть положительно");

        this.northAndSouthWidth = northAndSouthWidth;
        this.eastAndWestWidth = eastAndWestWidth;
        this.apartment = apartment;
    }

    Apartment getApartment() {
        return apartment;
    }

    public float getHeight() {
        return apartment == null ? 0 : apartment.getHeight();
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

    Wall createWall(Direction direction) {
        try {
            checkNull(direction, "Неопределен объект direction.");
            Wall wall = new Wall(this, direction);
            this.walls.put(direction, wall);
            return wall;
        } catch (Exception ex) {
            return null;
        }
    }

    void addWall(Wall wall, Direction direction) {
        checkNull(wall, "Неопределен объект wall.");
        checkNull(direction, "Неопределен объект direction.");
        if (this.walls.containsValue(wall)) {
            throw new IllegalArgumentException("Объект wall уже добавлен в объект Room");
        } else {
            wall.addRoom(this, direction);
            walls.put(direction, wall);
        }
    }

    boolean deleteWall(Wall wall) {
        checkNull(wall, "Неопределен объект wall.");
        if (this.walls.containsValue(wall)) {
            for (Map.Entry<Direction, Wall> pair : walls.entrySet()) {
                if (wall.equals(pair.getValue())) {
                    this.walls.remove(pair.getKey(), wall);
                    wall.deleteRoom(this);
                    return true;
                }
            }
        }
        return false;
    }

    public void createDoor(Direction direction, float height, float width) {
        checkNull(direction, "Неопределен объект direction.");
        if (walls.containsKey(direction)) {
            walls.get(direction).createDoor(height, width);
        } else {
            throw new IllegalArgumentException("Недопустимое значение direction");
        }
    }

    public void createWindow(Direction direction, float height, float width) {
        checkNull(direction, "Неопределен объект direction.");
        if (walls.containsKey(direction)) {
            walls.get(direction).createWindow(height, width);
        } else {
            throw new IllegalArgumentException("Недопустимое значение direction");
        }
    }


    public Wall getWall(Direction direction) {
        checkNull(direction, "Неопределен объект direction.");
        if (walls.containsKey(direction)) {
            return walls.get(direction);
        }
        return null;
    }

    public float getSquare() {
        return northAndSouthWidth * eastAndWestWidth;
    }

    public float getPerimeter() {
        return 2 * (northAndSouthWidth + eastAndWestWidth);
    }

    public Set<Door> getDoors() {
        Set<Door> doors = new HashSet<>();
        for (Wall wall : walls.values()) {
            doors.addAll(wall.getDoors());
        }
        return doors;
    }

    public Set<Window> getWindows() {
        Set<Window> windows = new HashSet<>();
        for (Wall wall : walls.values()) {
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


