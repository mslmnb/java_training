package practice1.apartment;

import practice1.apartment.model.Direction;
import practice1.apartment.model.Room;

import static practice1.apartment.model.Direction.NORTH;
import static practice1.apartment.model.Direction.SOUTH;

/**
 * Created by Mussulmanbekova_GE on 26.10.2018.
 */
public class Utilits {

    public static float getWidthFromRoomByDirection(Room room, Direction direction) {
        if (direction==NORTH||direction==SOUTH) {
            return room.getNorthAndSouthWidth();
        } else {
            return room.getEastAndWestWidth();
        }
    }


}
