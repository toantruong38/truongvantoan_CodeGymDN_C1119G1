package Models;

import java.util.ArrayList;

public abstract class Services
{
    protected String id;

    protected String serviceName;

    protected double areaUsing;

    protected long rentFee;

    protected short maximumPeople;

    protected String rentType;

    protected String roomStandard;

    protected String cvntDescription;

    protected double poolArea;

    protected short floorAmount;

    protected String freeService;

    protected AccompanyService acpnyService = new AccompanyService();

    public abstract String showInfor();

    public abstract ArrayList<Services> import_from_file(String url);

    public abstract void export_to_file(ArrayList<Services> services_list, String url);

    public abstract Services set_all_properties(ArrayList<Object> data);
}

