package Models;

public interface VillaSetting
{
    String VILLA_URL = "Villa.csv";

    String VILLA_LABEL = ",roomStandard,cvntDescription,poolArea,floorAmount";

    String getRoomStandard();

    void setRoomStandard(String roomStandard);

    void setCvntDescription(String cvntDescription);

    String getConvenientDescription();

    double getPoolArea();

    void setPoolArea(double poolArea);

    short getFloorAmount();

    void setFloorAmount(short floorAmount);
}
