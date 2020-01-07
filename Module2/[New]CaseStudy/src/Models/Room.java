package Models;

import Libs.FuncWriteFileCSV;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Room extends Services implements ServiceSetting, RoomSetting
{

    @Override
    public String getFreeService()
    {
        return this.freeService;
    }

    @Override
    public void setFreeService(String freeService)
    {
        this.freeService = freeService;
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
        return "----------Room Information----------" + "\n" +
                "Id: " + this.getId() + "\n" +
                "Service name: " + this.getServiceName() + "\n" +
                "Area using: " + this.getAreaUsing() + "\n" +
                "Rent fee: " + this.getRentFee() + "\n" +
                "Maximum people: " + this.getMaximumPeople() + "\n" +
                "Rent type: " + this.getRentType() + "\n" +
                "Free service: " + this.getFreeService() + "\n" +
                "--------------Accompany Service--------------" + "\n" +
                "Service name: " + this.acpnyService.getServiceName() + "\n" +
                "Service cost: " + this.acpnyService.getCost() + "\n" +
                "Service currency: " + this.acpnyService.getCurrency();
    }

    @Override
    public ArrayList<Services> import_from_file(String url)
    {
        ArrayList<Services> room_list = new ArrayList<>();
        ArrayList<Object> formatted_data_by_line = FuncWriteFileCSV.readFile(url);
        ArrayList<Object> data = new ArrayList<>();

        for (int i = 1; i < formatted_data_by_line.size(); i++)
        {
            data.addAll(Arrays.asList(formatted_data_by_line.get(i).toString().split(",")));
            room_list.add(set_all_properties(data));
            data.clear();
        }
        return room_list;
    }

    @Override
    public void export_to_file(ArrayList<Services> services_list, String url)
    {
        services_list.addAll(import_from_file(url));
        String data_to_file = SERVICE_LABEL + ROOM_LABEL + ACPNY_SERVICE_LABEL;

        for (Services service : services_list)
        {
            Room room = (Room) service;
            data_to_file += "\n" + room.getId() + "," + room.getServiceName() + "," + room.getAreaUsing()
                    + "," + room.getRentFee() + "," + room.getMaximumPeople() + "," + room.getRentType()
                    + "," + room.getFreeService()
                    + "," + room.acpnyService.getServiceName() + "," + room.acpnyService.getCost()
                    + "," + room.acpnyService.getCurrency();
        }
        FuncWriteFileCSV.writeFile(data_to_file, url);
    }

    @Override
    public Services set_all_properties(ArrayList<Object> data)
    {
        Room room = new Room();

        Iterator iterator = data.iterator();
        room.setId(iterator.next().toString());
        room.setServiceName(iterator.next().toString());
        room.setAreaUsing((double) iterator.next());
        room.setRentFee((long) iterator.next());
        room.setMaximumPeople((short) iterator.next());
        room.setRentType(iterator.toString()); //^ common

        room.setFreeService(iterator.next().toString());//^ room only

        room.acpnyService.setServiceName(iterator.next().toString());
        room.acpnyService.setCost((long) iterator.next());
        room.acpnyService.setCurrency(iterator.next().toString()); //^ accompany service

        return room;
    }
}
