package com.epam.apartment.model;

import com.epam.apartment.Utilities;

import static com.epam.apartment.Utilities.checkIsPositive;
import static com.epam.apartment.Utilities.checkNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Wall extends BaseEntity {
    private Map<Direction, Room> rooms = new HashMap<>();
    private List<Door> doors = new ArrayList<>();
    private List<Window> windows = new ArrayList<>();

    public Wall(Room room, Direction direction) {
        addRoom(room, direction);
    }

    public List<Door> getDoors() {
        return doors;
    }

    void createDoor(float height, float width) {
        checkIsPositive(height, "Значение height должно быть положительно");
        checkIsPositive(width, "Значение width должно быть положительно");
        if (height >= getHeight()) {
            throw new IllegalArgumentException("Недопустимое значение height");
        }
        if (width >= getWidth()) {
            throw new IllegalArgumentException("Недопустимое значение width");
        }
        Door door = new Door(height, width);
        doors.add(door);
    }

    void createWindow(float height, float width) {
        checkIsPositive(height, "Значение height должно быть положительно");
        checkIsPositive(width, "Значение width должно быть положительно");
        if (height >= getHeight()) {
            throw new IllegalArgumentException("Недопустимое значение height");
        }
        if (width >= getWidth()) {
            throw new IllegalArgumentException("Недопустимое значение width");
        }
        Window window = new Window(height, width);
        windows.add(window);
    }

    public List<Window> getWindows() {
        return windows;
    }

    public float getHeight() {
        return rooms.size() == 0 ? 0 : ((Room) rooms.values().toArray()[0]).getHeight();
    }

    public float getWidth() {
        if (rooms.size() == 0) {
            return 0;
        }
        Direction direction = null;
        Room room = null;
        for (Map.Entry<Direction, Room> pair : rooms.entrySet()) {
            direction = pair.getKey();
            room = pair.getValue();
        }
        return rooms.size() == 0 ? 0 : Utilities.getWidthFromRoomByDirection(room, direction);
    }

    Map<Direction, Room> getRooms() {
        return rooms;
    }

    void addRoom(Room room, Direction direction) {
        checkNull(room, "Неопределен объект room.");
        checkNull(direction, "Неопределен объект direction.");
        if (rooms.containsValue(room)) {
            throw new IllegalArgumentException("Объект room уже добавлен в объект Wall");
        } else {
            float roomHeight = room.getHeight();
            float roomWidthByDirection = Utilities.getWidthFromRoomByDirection(room, direction);
            for (Map.Entry<Direction, Room> pair : rooms.entrySet()) {
                Room curRoom = pair.getValue();
                Direction curDirection = pair.getKey();
                if (curRoom.getHeight() != roomHeight ||
                        Utilities.getWidthFromRoomByDirection(curRoom, curDirection) != roomWidthByDirection) {
                    throw new IllegalArgumentException("Недопустимое значение height для room");
                }
            }
            this.rooms.put(direction, room);
        }
    }

    boolean deleteRoom(Room room) {
        if (this.rooms.containsValue(room)) {
            for (Map.Entry<Direction, Room> pair : rooms.entrySet()) {
                if (room.equals(pair.getValue())) {
                    this.rooms.remove(pair.getKey(), room);
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    public String toString() {
        return "Wall{" +
                "id=" + this.getId() +
                ", rooms=" + rooms.values().stream().map(room -> room.getId().toString()).collect(Collectors.joining(", ")) +
                '}';
    }

}
