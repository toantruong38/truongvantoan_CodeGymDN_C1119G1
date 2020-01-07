package Models;

public interface ServiceSetting
{
    String SERVICE_URL = "C:\\Users\\Admin\\Downloads\\Documents\\CodeGym\\truongvantoan_CodeGymDN_C1119G1" +
            "\\Module2\\[New]CaseStudy\\src\\Data\\";

    String SERVICE_LABEL = "id,serviceName,areaUsing,rentFee,maximumPeople,rentType";

    String ACPNY_SERVICE_LABEL = ",acpnyServiceName,acpnyServiceCost,acpnyServiceCurrency";

    String getServiceName();

    void setServiceName(String serviceName);

    String getId();

    void setId(String id);

    double getAreaUsing();

    void setAreaUsing(double areaUsing);

    long getRentFee();

    void setRentFee(long rentFee);

    short getMaximumPeople();

    void setMaximumPeople(short maximumPeople);

    String getRentType();

    void setRentType(String rentType);

    AccompanyService getAcpnyService();

    void setAcpnyService(AccompanyService accompanyService);
}
