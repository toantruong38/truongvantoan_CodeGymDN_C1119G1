package Libs;

import Models.AccompanyService;
import Models.Villa;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class FuncWriteFileCSV_old
{
    private static FuncWriteFileCSV_old own_properties = new FuncWriteFileCSV_old();
    private FileWriter fileWriter;
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String label_str = "id,serviceName,areaUsing,rentFee,maximumPeople,rentType,";
    private String accompany_service_label = ",acpnyServiceName,acpnyServiceCost,acpnyServiceCurrency";
    private String villa_url = "C:\\Users\\Admin\\Downloads\\Documents\\CodeGym\\truongvantoan_CodeGymDN_C1119G1" +
            "\\Module2\\[New]CaseStudy\\src\\Data\\Villa.csv";

    public static void main(String[] args)
    {
        try
        {
            own_properties.fileReader = new FileReader("C:\\Users\\Admin\\Downloads\\Documents\\CodeGym\\" +
                    "truongvantoan_CodeGymDN_C1119G1\\Module2\\[New]CaseStudy\\src\\Data\\test.txt");
            own_properties.bufferedReader = new BufferedReader(own_properties.fileReader);
        } catch (FileNotFoundException e)
        {
            //e.printStackTrace();
            System.out.println("File not found! --> Creating new file ...");
            File file = new File("C:\\Users\\Admin\\Downloads\\Documents\\CodeGym\\" +
                    "truongvantoan_CodeGymDN_C1119G1\\Module2\\[New]CaseStudy\\src\\Data\\test.txt");
            try
            {
                file.createNewFile();
            } catch (IOException err)
            {
                System.out.println("Fail to create file! " + file.getName());
            }
        }
    }

    public void writeVilla(Villa villa)
    {
        String villa_label = label_str + "roomStandard,convenientDescription,poolArea,floorAmount," +
                accompany_service_label;
        /* ---> villa_label would be:
        id,serviceName,areaUsing,rentFee,maximumPeople,rentType,roomStandard,convenientDescription,poolArea,floorAmount
        ,acpnyServiceName,acpnyServiceCost,acpnyServiceCurrency
        * */

        ArrayList<String> lable = new ArrayList<>();
        lable.addAll(Arrays.asList(villa_label.split(",")));
        /*  ---> split components by \,/ for using later
         * */

        //---> getting data from villa object
        AccompanyService villa_accompanyService = villa.getAcpnyService();
        String villa_data = villa.getId() + "," + villa.getServiceName() + "," + villa.getAreaUsing() + "," + villa.getRentFee()
                + "," + villa.getMaximumPeople() + "," + villa.getRentType() + "," + villa.getRoomStandard()
                + "," + villa.getConvenientDesciption() + "," + villa.getPoolArea() + "," + villa.getFloorAmount()
                + "," + villa_accompanyService.getServiceName() + "," + villa_accompanyService.getCost()
                + "," + villa_accompanyService.getCurrency();

        //---> Backing up old data


        //-------> Start writing to file....

    }

    public ArrayList<Villa> readVilla()
    {

        try
        {
            //-->Connect to file
            own_properties.fileReader = new FileReader(own_properties.villa_url);
            own_properties.bufferedReader = new BufferedReader(own_properties.fileReader);

            //Reading-->
            int ch;
            String data_from_file = "";
            while ((ch = own_properties.fileReader.read()) != -1)
            {
                data_from_file += (char) ch;
            }
            //Done reading. Closing streams
            own_properties.fileReader.close();
            own_properties.bufferedReader.close();

            //Export to villa object
            String[] data_by_line = data_from_file.split("\\n");

            ArrayList<String> into_object = new ArrayList<>();

            for (int i = 1; i < data_by_line.length; i++)
            {
                into_object.addAll(Arrays.asList(data_by_line[i].split(",")));

                Iterator<String> iterator = into_object.iterator();
                Villa villa = new Villa();
                while (iterator.hasNext())
                {
                    villa.setId(iterator.next());
                    villa.setServiceName(iterator.next());
                    villa.setAreaUsing(Double.valueOf(iterator.next()));
                    villa.setRentFee(Long.valueOf(iterator.next()));
                    villa.setMaximumPeople(Short.valueOf(iterator.next()));
                    villa.setRentType(iterator.next());
                    villa.setRoomStandard();
                }

                into_object.clear();
            }

        } catch (IOException e)
        {
            System.out.printf("Exception found at %s", own_properties.getClass().getName());
        }

    }
}
