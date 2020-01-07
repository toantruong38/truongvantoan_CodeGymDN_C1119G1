package Models;

public interface RoomSetting
{
    String ROOM_URL = "Room.csv";

    String ROOM_LABEL = ",freeService";

    String getFreeService();

    void setFreeService(String freeService);
}
