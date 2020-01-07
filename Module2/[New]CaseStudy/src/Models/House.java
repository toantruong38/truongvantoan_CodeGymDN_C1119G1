package Models;

import Libs.FuncWriteFileCSV;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class House extends Services implements ServiceSetting, HouseSetting
{

    @Override
    public String getRoomStandard()
    {
        return this.roomStandard;
    }

    @Override
    public void setRoomStandard(String roomStandard)
    {
        this.roomStandard = roomStandard;
    }

    @Override
    public String getCvntDescription()
    {
        return this.cvntDescription;
    }

    @Override
    public void setCvntDescription(String convenientDescription)
    {
        this.cvntDescription = convenientDescription;
    }

    @Override
    public short getFloorAmount()
    {
        return this.floorAmount;
    }

    @Override
    public void setFloorAmount(short floorAmount)
    {
        this.floorAmount = floorAmount;
    }

    @Override
    public String getServiceName()
    {
        return this.serviceName;
    }

    @Override
    public void setServiceName(String serviceName)
    {
        this.serviceName = serviceName;
    }

    @Override
    public String getId()
    {
        return this.id;
    }

    @Override
    public void setId(String id)
    {
        this.id = id;
    }

    @Override
    public double getAreaUsing()
    {
        return this.areaUsing;
    }

    @Override
    public void setAreaUsing(double areaUsing)
    {
        this.areaUsing = areaUsing;
    }

    @Override
    public long getRentFee()
    {
        return this.rentFee;
    }

    @Override
    public void setRentFee(long rentFee)
    {
        this.rentFee = rentFee;
    }

    @Override
    public short getMaximumPeople()
    {
        return this.maximumPeople;
    }

    @Override
    public void setMaximumPeople(short maximumPeople)
    {
        this.maximumPeople = maximumPeople;
    }

    @Override
    public String getRentType()
    {
        return this.rentType;
    }

    @Override
    public void setRentType(String rentType)
    {
        this.rentType = rentType;
    }

    @Override
    public AccompanyService getAcpnyService()
    {
        return this.acpnyService;
    }

    @Override
    public void setAcpnyService(AccompanyService accompanyService)
    {
        this.acpnyService = accompanyService;
    }

    @Override
    public String showInfor()
    {
        return "----------House Information----------" + "\n" +
                "Id: " + this.getId() + "\n" +
                "Service name: " + this.getServiceName() + "\n" +
                "Area using: " + this.getAreaUsing() + "\n" +
                "Rent fee: " + this.getRentFee() + "\n" +
                "Maximum people: " + this.getMaximumPeople() + "\n" +
                "Rent type: " + this.getRentType() + "\n" +
                "Room standard: " + this.getRoomStandard() + "\n" +
                "Floor amount: " + this.getFloorAmount() + "\n" +
                "--------------Accompany Service--------------" + "\n" +
                "Service name: " + this.acpnyService.getServiceName() + "\n" +
                "Service cost: " + this.acpnyService.getCost() + "\n" +
                "Service currency: " + this.acpnyService.getCurrency();
    }

    @Override
    public ArrayList<Services> import_from_file(String url)
    {
        ArrayList<Services> house_list = new ArrayList<>();
        ArrayList<Object> formatted_data_by_line = FuncWriteFileCSV.readFile(url);
        ArrayList<Object> data = new ArrayList<>();

        for (int i = 1; i < formatted_data_by_line.size(); i++)
        {
            data.addAll(Arrays.asList(formatted_data_by_line.get(i).toString().split(",")));
            house_list.add(set_all_properties(data));
            data.clear();
        }
        return house_list;
    }

    @Override
    public void export_to_file(ArrayList<Services> services_list, String url)
    {
        services_list.addAll(import_from_file(url));
        String data_to_file = SERVICE_LABEL + HOUSE_LABEL + ACPNY_SERVICE_LABEL;

        for (Services service : services_list)
        {
            House house = (House) service;
            data_to_file += "\n" + house.getId() + "," + house.getServiceName() + "," + house.getAreaUsing()
                    + "," + house.getRentFee() + "," + house.getMaximumPeople() + "," + house.getRentType()
                    + "," + house.getRoomStandard() + "," + house.getFloorAmount()
                    + "," + house.acpnyService.getServiceName() + "," + house.acpnyService.getCost()
                    + "," + house.acpnyService.getCurrency();
        }
        FuncWriteFileCSV.writeFile(data_to_file, url);
    }

    @Override
    public Services set_all_properties(ArrayList<Object> data)
    {
        House house = new House();

        Iterator iterator = data.iterator();
        house.setId(iterator.next().toString());
        house.setServiceName(iterator.next().toString());
        house.setAreaUsing((double) iterator.next());
        house.setRentFee((long) iterator.next());
        house.setMaximumPeople((short) iterator.next());
        house.setRentType(iterator.toString()); //^ common

        house.setRoomStandard(iterator.toString());
        house.setCvntDescription(iterator.toString());
        house.setFloorAmount((short) iterator.next());//^ house only

        house.acpnyService.setServiceName(iterator.next().toString());
        house.acpnyService.setCost((long) iterator.next());
        house.acpnyService.setCurrency(iterator.next().toString()); //^ accompany service

        return house;
    }
}
