package Models;

import Libs.FuncWriteFileCSV;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Villa extends Services implements ServiceSetting, VillaSetting
{

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
        return "----------Villa Information----------" + "\n" +
                "Id: " + this.getId() + "\n" +
                "Service name: " + this.getServiceName() + "\n" +
                "Area using: " + this.getAreaUsing() + "\n" +
                "Rent fee: " + this.getRentFee() + "\n" +
                "Maximum people: " + this.getMaximumPeople() + "\n" +
                "Rent type: " + this.getRentType() + "\n" +
                "Room standard: " + this.getRoomStandard() + "\n" +
                "Other convenient description: " + this.getConvenientDescription() + "\n" +
                "Pool area: " + this.getPoolArea() + "\n" +
                "Floor amount: " + this.getFloorAmount() + "\n" +
                "--------------Accompany Service--------------" + "\n" +
                "Service name: " + this.acpnyService.getServiceName() + "\n" +
                "Service cost: " + this.acpnyService.getCost() + "\n" +
                "Service currency: " + this.acpnyService.getCurrency();
    }

    @Override
    public ArrayList<Services> import_from_file(String url)
    {
        ArrayList<Services> villa_list = new ArrayList<>();
        ArrayList<Object> formatted_data_by_line = FuncWriteFileCSV.readFile(url);
        ArrayList<Object> data = new ArrayList<>();

        for (int i = 1; i < formatted_data_by_line.size(); i++)
        {
            data.addAll(Arrays.asList(formatted_data_by_line.get(i).toString().split(",")));
            villa_list.add(set_all_properties(data));
            data.clear();
        }
        return villa_list;
    }

    @Override
    public void export_to_file(ArrayList<Services> services_list, String url)
    {
        services_list.addAll(import_from_file(url));
        String data_to_file = SERVICE_LABEL + VILLA_LABEL + ACPNY_SERVICE_LABEL;

        for (Services service : services_list)
        {
            Villa villa = (Villa) service;
            data_to_file += "\n" + villa.getId() + "," + villa.getServiceName() + "," + villa.getAreaUsing()
                    + "," + villa.getRentFee() + "," + villa.getMaximumPeople() + "," + villa.getRentType()
                    + "," + villa.getRoomStandard() + "," + villa.getConvenientDescription()
                    + "," + villa.getPoolArea() + "," + villa.getFloorAmount()
                    + "," + villa.acpnyService.getServiceName() + "," + villa.acpnyService.getCost()
                    + "," + villa.acpnyService.getCurrency() + "\n";
        }
        FuncWriteFileCSV.writeFile(data_to_file, url);
    }

    @Override
    public Villa set_all_properties(ArrayList<Object> data)
    {
        Villa villa = new Villa();

        Iterator iterator = data.iterator();
        villa.setId(iterator.next().toString());
        villa.setServiceName(iterator.next().toString());
        villa.setAreaUsing((double) iterator.next());
        villa.setRentFee((long) iterator.next());
        villa.setMaximumPeople((short) iterator.next());
        villa.setRentType(iterator.next().toString()); //^ common

        villa.setRoomStandard(iterator.next().toString());
        villa.setCvntDescription(iterator.next().toString());
        villa.setPoolArea((double) iterator.next());
        villa.setFloorAmount((short) iterator.next());//^ villa only

        villa.acpnyService.setServiceName(iterator.next().toString());
        villa.acpnyService.setCost((long) iterator.next());
        villa.acpnyService.setCurrency(iterator.next().toString()); //^ accompany service

        return villa;
    }

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
    public void setCvntDescription(String cvntDescription)
    {
        this.cvntDescription = cvntDescription;
    }

    @Override
    public String getConvenientDescription()
    {
        return this.cvntDescription;
    }

    @Override
    public double getPoolArea()
    {
        return this.poolArea;
    }

    @Override
    public void setPoolArea(double poolArea)
    {
        this.poolArea = poolArea;
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
}
