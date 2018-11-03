package com.epam.apartment.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.epam.apartment.Utilities.*;

public class Apartment extends BaseEntity {
    private float height;
    private List<Room> rooms = new ArrayList<>();

    public Apartment(float height) {
        checkPositive(height, "Значение height должно быть положительно");
        this.height = height;
    }

    public float getHeight() {
        return height;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    // добавить метод deleteRoom(Room room)
    // нужно пройтись по всем стенам квартиры и удлаить из них информаицю о удаляемой комнате

    public void createRoom(float northAndSouthWidth, float eastAndWestWidth) {
        Room room = new Room(this, northAndSouthWidth, eastAndWestWidth);
        rooms.add(room);
    }

    public void createWallForRoom(Room room, Direction direction) {
        checkNull(room, "Неопределен объект room.");
        checkNull(direction, "Неопределен объект direction.");
        if (!rooms.contains(room)) {
            throw new IllegalArgumentException("Недопустимое значение room.");
        }
        room.createWall(direction);
    }

    public void addWallForRoom(Room room, Wall wall, Direction direction) {

        checkNull(room, "Неопределен объект room.");
        checkNull(wall, "Неопределен объект wall.");
        checkNull(direction, "Неопределен объект direction.");

        if (!rooms.contains(room)) {
            throw new IllegalArgumentException("Недопустимое значение room.");
        }
        room.addWall(wall, direction);
    }

    public float getSquare() {
        return rooms.size() == 0 ? 0 : rooms.stream().map(room -> room.getSquare()).reduce((x, y) -> x + y).get();
    }

    public Set<Door> getDoors() {
        Set<Door> doors = new HashSet<>();
        for (Room room : rooms) {
            doors.addAll(room.getDoors());
        }
        return doors;
    }

    public Set<Window> getWindows() {
        Set<Window> windows = new HashSet<>();
        for (Room room : rooms) {
            windows.addAll(room.getWindows());
        }
        return windows;
    }

    public Set<Wall> getWalls() {
        Set<Wall> walls = new HashSet<>();
        for (Room room : rooms) {
            walls.addAll(room.getWallSet());
        }
        return walls;
    }

    public float getPerimeter() {
        float perimeter = 0;
        for (Wall wall : getWalls()) {
            if (wall.getRooms().size() == 1) {
                perimeter = perimeter + wall.getWidth();
            }
        }
        return perimeter;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "height=" + height +
                ", rooms=" + rooms.stream().map(room -> room.getId().toString()).collect(Collectors.joining(", ")) +
                '}';
    }
}
