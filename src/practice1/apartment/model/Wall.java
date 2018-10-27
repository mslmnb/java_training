package practice1.apartment.model;

import static practice1.apartment.Utilits.getWidthFromRoomByDirection;

import practice1.apartment.exception.UnacceptableValueException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Wall extends BaseEntity {
    private Map<Direction, Room> rooms = new HashMap<>();
    private List<Door> doors = new ArrayList<>();
    private List<Window> windows = new ArrayList<>();

    public Wall() {
    }

    public Wall(Room room, Direction direction) throws UnacceptableValueException {
        addRoom(room, direction);
    }

    public List<Door> getDoors() {
        return doors;
    }

    public void addDoor(Door door) throws UnacceptableValueException {
        if (door==null) {
            throw new UnacceptableValueException("Недопустимое значение door при обновлении объекта Wall");
        }
        if (!doors.contains(door)) {
            doors.add(door);
        }
    }

    public void addWindow(Window window) throws UnacceptableValueException {
        if (window==null) {
            throw new UnacceptableValueException("Недопустимое значение window при обновлении объекта Wall");
        }
        if (!windows.contains(window)) {
            windows.add(window);
        }
    }

    public List<Window> getWindows() {
        return windows;
    }

    public float getHeight() {
        return rooms.size()==0 ? 0 : ((Room)rooms.values().toArray()[0]).getHeight();
    }

    public float getWidth() {
        if (rooms.size()==0) {
            return 0;
        }
        Direction direction = null ;
        Room room = null;
        for (Map.Entry<Direction, Room> pair: rooms.entrySet()) {
            direction = pair.getKey();
            room = pair.getValue();
        }
        return rooms.size()==0 ? 0 : getWidthFromRoomByDirection(room, direction);
    }

    public Map<Direction, Room> getRooms() {
        return rooms;
    }

    public void addRoom(Room room, Direction direction) throws UnacceptableValueException {
        if (room!=null) {
            if (direction==null) {
                throw new UnacceptableValueException("Недопустимое значение direction при создании/обновлении объекта Wall");
            }
            if (!rooms.containsValue(room)) {
                float roomHeight = room.getHeight();
                float roomWidthByDirection = getWidthFromRoomByDirection(room, direction);
                for (Map.Entry<Direction, Room> pair : rooms.entrySet()) {
                    Room curRoom = pair.getValue();
                    Direction curDirection = pair.getKey();
                    if (curRoom.getHeight()!=roomHeight||
                            getWidthFromRoomByDirection(curRoom,curDirection)!= roomWidthByDirection) {
                        throw new UnacceptableValueException("Недопустимое значение room при создании/обновлении объекта Wall");
                    }

                }
                this.rooms.put(direction, room);
            }
        } else {
            throw new UnacceptableValueException("Недопустимое значение room при создании объекта Wall");
        }
    }


    @Override
    public String toString() {
        return "Wall{" +
                "id=" + this.getId() +
                ", rooms=" + rooms.values().stream().map(room-> room.getId().toString()).collect(Collectors.joining(", ")) +
                '}';
    }
}
