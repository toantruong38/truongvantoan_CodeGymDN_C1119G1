package Models;

public interface HouseSetting
{
    String HOUSE_URL = "House.csv";

    String HOUSE_LABEL = ",roomStandard,cvntDescription,floorAmount";

    String getRoomStandard();

    void setRoomStandard(String roomStandard);

    String getCvntDescription();

    void setCvntDescription(String convenientDescription);

    short getFloorAmount();

    void setFloorAmount(short floorAmount);
}
