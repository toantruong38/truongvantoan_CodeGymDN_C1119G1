package Controllers;


import Models.Customer;
import Models.House;
import Models.Room;
import Models.Villa;

import java.io.*;
import java.util.ArrayList;

public class FuncWriteFileCSV
{
    public static void main(Object service, String type)
    {
        FileReader fr;
        FileWriter fw;
        BufferedReader br;
        BufferedWriter bw;

        try
        {
            if (type == "villa")
            {
                fr = new FileReader("C:\\Users\\Admin\\Downloads\\Documents\\CodeGym\\" +
                        "truongvantoan_CodeGymDN_C1119G1\\Module2\\CaseStudy\\src\\Data\\Villa.csv");
                br = new BufferedReader(fr);
                String content = "id,serviceName,area,rentFee,maxPerson,rentType," +
                        "roomStandard,convenientDescr,poolArea,floorAmount,accompanyService\n";
                Villa villa = (Villa) service;
                content += villa.getId() + "," + villa.getServiceName() + "," + villa.getArea() + "," + villa.getRentFee() + "," +
                        villa.getMaxPerson() + "," + villa.getRentType() + "," + villa.getRoomStandard() + "," +
                        villa.getConvenientDescr() + "," + villa.getPoolArea() + "," + villa.getFloorAmount() +
                        villa.getAccompanyService() + "\n";
                String backUpContent = "";
                int ch;
                br.readLine();
                while ((ch = br.read()) != -1)
                {
                    backUpContent += (char) ch;
                }
                fw = new FileWriter("C:\\Users\\Admin\\Downloads\\Documents\\CodeGym\\truongvantoan_CodeGymDN_C1119G1\\Module2\\CaseStudy\\src\\Data\\Villa.csv");
                bw = new BufferedWriter(fw);
                bw.write(content + backUpContent);
                bw.flush();
                bw.close();
                br.close();
                fr.close();
                fw.close();
            } else if (type == "house")
            {
                fr = new FileReader("C:\\Users\\Admin\\Downloads\\Documents\\CodeGym\\truongvantoan_CodeGymDN_C1119G1\\Module2\\CaseStudy\\src\\Data\\House.csv");
                br = new BufferedReader(fr);
                String content = "id,serviceName,area,rentFee,maxPerson,rentType," +
                        "roomStandard,convenientDescr,floorAmount,accompanyService\n";
                House house = (House) service;
                content += house.getId() + "," + house.getServiceName() + "," + house.getArea() + "," + house.getRentFee() + "," +
                        house.getMaxPerson() + "," + house.getRentType() + "," + house.getRoomStandard() + "," +
                        house.getConvenientDescr() + "," + house.getFloorAmount() +
                        house.getAccompanyService() + "\n";
                String backUpContent = "";
                int ch;
                br.readLine();
                while ((ch = br.read()) != -1)
                {
                    backUpContent += (char) ch;
                }
                fw = new FileWriter("C:\\Users\\Admin\\Downloads\\Documents\\CodeGym\\truongvantoan_CodeGymDN_C1119G1\\Module2\\CaseStudy\\src\\Data\\House.csv");
                bw = new BufferedWriter(fw);

                bw.write(content + backUpContent);
                bw.flush();
                bw.flush();
                bw.close();
                br.close();
                fr.close();
                fw.close();
            } else if (type == "room")
            {
                fr = new FileReader("C:\\Users\\Admin\\Downloads\\Documents\\CodeGym\\truongvantoan_CodeGymDN_C1119G1\\Module2\\CaseStudy\\src\\Data\\Room.csv");
                br = new BufferedReader(fr);
                String content = "id,serviceName,area,rentFee,maxPerson,rentType," +
                        "freeAccompanyService,accompanyService\n";
                Room room = (Room) service;
                content += room.getId() + "," + room.getServiceName() + "," + room.getArea() + "," + room.getRentFee() + "," +
                        room.getMaxPerson() + "," + room.getRentType() + "," + room.getFreeAccompanyService() +
                        room.getAccompanyService() + "\n";
                String backUpContent = "";
                int ch;
                br.readLine();
                while ((ch = br.read()) != -1)
                {
                    backUpContent += (char) ch;
                }
                fw = new FileWriter("C:\\Users\\Admin\\Downloads\\Documents\\CodeGym\\truongvantoan_CodeGymDN_C1119G1\\Module2\\CaseStudy\\src\\Data\\Room.csv");
                bw = new BufferedWriter(fw);

                bw.write(content + backUpContent);
                bw.flush();
                bw.flush();
                bw.close();
                br.close();
                fr.close();
                fw.close();
            } else if (type == "customer")
            {
                fr = new FileReader("C:\\Users\\Admin\\Downloads\\Documents\\CodeGym\\truongvantoan_CodeGymDN_C1119G1\\Module2\\CaseStudy\\src\\Data\\Customer.csv");
                br = new BufferedReader(fr);
                String content = "id,fullName,birth,gender,cmnd,email,phoneNum," +
                        "customerType,addr\n";
                Customer customer = (Customer) service;
                content += customer.getId() + "," + customer.getFullName() + "," + customer.getBirth() + "," + customer.getGender() + "," +
                        customer.getCmnd() + "," + customer.getEmail() + "," + customer.getPhoneNum() + "," +
                        customer.getCustomerType() + "," + customer.getAddr() + "\n";
                String backUpContent = "";
                int ch;
                br.readLine();
                while ((ch = br.read()) != -1)
                {
                    backUpContent += (char) ch;
                }
                fw = new FileWriter("C:\\Users\\Admin\\Downloads\\Documents\\CodeGym\\truongvantoan_CodeGymDN_C1119G1\\Module2\\CaseStudy\\src\\Data\\Customer.csv");
                bw = new BufferedWriter(fw);

                bw.write(content + backUpContent);
                bw.flush();
                bw.flush();
                bw.close();
                br.close();
                fr.close();
                fw.close();
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void sortData() throws IOException
    {
        FileReader fileReader;
        fileReader = new FileReader("C:\\Users\\Admin\\Downloads\\Documents\\CodeGym\\truongvantoan_CodeGymDN_C1119G1\\Module2\\CaseStudy\\src\\Data\\Customer.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList<String> arrayList = (ArrayList<String>) bufferedReader.lines();
    }
}
