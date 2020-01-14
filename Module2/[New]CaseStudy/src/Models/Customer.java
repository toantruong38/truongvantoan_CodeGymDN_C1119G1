package Models;

import Libs.FuncWriteFileCSV;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Customer extends Person implements ShowInformation
{
    public final static String CUSTOMER_LABEL = ",gender,customerType,address";

    public final static String CUSTOMER_URL = "Customer.csv";

    public final static String BOOKING_URL = "Booking.csv";

    public final static String BOOKING_ORDER = "C:\\Users\\Admin\\Downloads\\Documents\\CodeGym\\" +
            "truongvantoan_CodeGymDN_C1119G1\\Module2\\[New]CaseStudy\\src\\Data\\BookingOrder.txt";

    public ArrayList<Services> services = new ArrayList<>();

    private String gender;

    private String customerType;

    private String address;

    public ArrayList<Contract> contracts = new ArrayList<>();
    //---^ Customer only

    //----^ From Person abstract class

    public ArrayList<Services> getServices()
    {
        return this.services;
    }

    public void setService(Services service)
    {
        if (service instanceof Villa)
        {
            this.services.add(service);
            System.out.println("----------Villa Contract---------");
            this.contracts.add(Contract.setContractInformation());
        } else if (service instanceof House)
        {
            this.services.add(service);
            System.out.println("----------House Contract---------");
            this.contracts.add(Contract.setContractInformation());
        } else if (service instanceof Room)
        {
            this.services.add(service);
        } else System.out.println("Failed to add Customer service!");
    }

    public ArrayList<Contract> getContracts()
    {
        return this.contracts;
    }

    public void setContract(Contract contract)
    {
        this.contracts.add(contract);
    }


    public String getGender()
    {
        return this.gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getCustomerType()
    {
        return this.customerType;
    }

    public void setCustomerType(String customerType)
    {
        this.customerType = customerType;
    }

    public String getAddress()
    {
        return this.address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }
    //---^ Customer only


    //----^ From Person abstract class

    public String showInformation()
    {
        String output_information = "";

        //basic customer information
        output_information += "----------Customer Information----------"
                + "\n" + "Full name: " + this.getFullName()
                + "\n" + "Birth: " + this.getBirth()
                + "\n" + "Gender: " + this.getGender()
                + "\n" + "Cmnd id: " + this.getCmnd()
                + "\n" + "Phone number: " + this.getPhoneNumber()
                + "\n" + "Email: " + this.getEmail()
                + "\n" + "Customer type: " + this.getCustomerType()
                + "\n" + "Address: " + this.getAddress();

        try
        {
            Iterator services = this.getServices().iterator();
            Iterator contracts = this.getContracts().iterator();


            while (services.hasNext())
            {
                Object unknown_service = services.next();
                if (unknown_service instanceof Villa)
                {
                    output_information += "\n" + ((Villa) unknown_service).showInfor()
                            + "\n" + ((Contract) contracts.next()).showInformation();
                } else if (unknown_service instanceof House)
                {
                    output_information += "\n" + ((House) unknown_service).showInfor()
                            + "\n" + ((Contract) contracts.next()).showInformation();
                } else if (unknown_service instanceof Room)
                {
                    output_information += "\n" + ((Room) unknown_service).showInfor();
                }
            }
        } catch (NullPointerException e)
        {
            System.out.println();
        }


        return output_information;
    }

    public void export_to_file(ArrayList<Customer> customers, String url)
    {
        String label = "";

        String booking_order = "";

        String data = "";

        String customer_data = PERSON_LABEL + CUSTOMER_LABEL + "\n";

        for (int cusI = 0; cusI < customers.size(); cusI++)
        {
            label = PERSON_LABEL + CUSTOMER_LABEL + "\n"; //Customer label

            Customer currentCus = customers.get(cusI);

            String currentCusData = currentCus.getFullName() + "," + currentCus.getBirth()
                    + "," + currentCus.getCmnd() + "," + currentCus.getPhoneNumber()
                    + "," + currentCus.getEmail() + "," + currentCus.getGender()
                    + "," + currentCus.getCustomerType() + "," + currentCus.getAddress();//customer data

            customer_data += currentCusData + "\n"; //for Customer.csv
            data += label + currentCusData + "\n"; //for Booking.csv


            booking_order += "User\n";

            ArrayList<Services> services = currentCus.getServices();
            ArrayList<Contract> contracts = currentCus.getContracts();

            try
            {
                int contract_index = 0;
                for (int serI = 0; serI < services.size(); serI++)
                {
                    Services unknown_service = services.get(serI);

                    if (unknown_service instanceof Villa)
                    {
                        Villa villa = (Villa) unknown_service;

                        label = Villa.SERVICE_LABEL + Villa.VILLA_LABEL + "\n";
                        //Customer + villa label

                        data += label + villa.getId() + "," + villa.getServiceName() + "," + villa.getAreaUsing()
                                + "," + villa.getRentFee() + "," + villa.getMaximumPeople() + "," + villa.getRentType()
                                + "," + villa.getRoomStandard() + "," + villa.getConvenientDescription()
                                + "," + villa.getPoolArea() + "," + villa.getFloorAmount()
                                + "," + villa.acpnyService.getServiceName() + "," + villa.acpnyService.getCost()
                                + "," + villa.acpnyService.getCurrency();//villa data


                        Contract contract = contracts.get(contract_index++);

                        label = "\n" + Contract.CONTRACT_LABEL + "\n"; //cus+vil+contr label

                        data += label + contract.getContractNumber() + "," + contract.getStartDay()
                                + "," + contract.getEndDay() + "," + contract.getDeposit()
                                + "," + contract.getDeposit() + "\n"; //contract data


                        booking_order += "Villa\n" + "VillaData\n" + "Contract\n" + "ContractData\n";
                    } else if (unknown_service instanceof House)
                    {
                        House house = (House) unknown_service;


                        label = House.SERVICE_LABEL + House.HOUSE_LABEL + "\n";//Cus+hou label

                        data += label + house.getId() + "," + house.getServiceName() + "," + house.getAreaUsing()
                                + "," + house.getRentFee() + "," + house.getMaximumPeople() + "," + house.getRentType()
                                + "," + house.getRoomStandard() + "," + house.getCvntDescription() + "," + house.getFloorAmount()
                                + "," + house.acpnyService.getServiceName() + "," + house.acpnyService.getCost()
                                + "," + house.acpnyService.getCurrency(); //house data


                        Contract contract = contracts.get(contract_index++);

                        label = "\n" + Contract.CONTRACT_LABEL + "\n"; //cus+hou+con label

                        data += label + contract.getContractNumber() + "," + contract.getStartDay()
                                + "," + contract.getEndDay() + "," + contract.getDeposit()
                                + "," + contract.getDeposit() + "\n"; //contract data


                        booking_order += "House\nHouseData\n" + "Contract\nContractData\n";
                    } else if (unknown_service instanceof Room)
                    {

                        Room room = (Room) unknown_service;

                        label = Room.SERVICE_LABEL + Room.ROOM_LABEL + "\n";
                        //Customer + room label

                        data += label + room.getId() + "," + room.getServiceName() + "," + room.getAreaUsing()
                                + "," + room.getRentFee() + "," + room.getMaximumPeople() + "," + room.getRentType()
                                + "," + room.getFreeService()
                                + "," + room.acpnyService.getServiceName() + "," + room.acpnyService.getCost()
                                + "," + room.acpnyService.getCurrency() + "\n";//room data


                        booking_order += "Room\nRoomData\n";
                    }
                }
            } catch (NullPointerException e) {}

            booking_order += "push\n";
        }
        FuncWriteFileCSV.writeFile(data, url); //write to Booking.csv

        FuncWriteFileCSV.writeFile(customer_data, PERSON_URL + CUSTOMER_URL); //write to Customer.csv

        FuncWriteFileCSV.writeFile(booking_order, BOOKING_ORDER);
    }

    public ArrayList<Customer> import_from_file(String url)
    {
        /*  BookingOrder.txt : format rules
            User
            UserData
            Villa
            VillaData
            House
            HouseData
            Room
            RoomData
            Contract
            ContractData

            And push command as a signal
        * */


        ArrayList<Customer> customers = new ArrayList<>();
        Customer customer = new Customer();
        ArrayList<Object> formatted_data_by_line = FuncWriteFileCSV.readFile(url);
        ArrayList<Object> booking_order_by_line = FuncWriteFileCSV.readFile(BOOKING_ORDER);

        for (int order = 0; order < booking_order_by_line.size(); order++)
        {
            String orderCommand = booking_order_by_line.get(order).toString();
            if (orderCommand.equals("User"))
            {
                ArrayList<Object> customer_data = new ArrayList<>();

                customer_data.addAll(Arrays.asList(formatted_data_by_line.get(order + 1).toString().split(",")));

                customer = this.set_all_customer_properties(customer_data);
            } else if (orderCommand.equals("Villa"))
            {
                Villa villa = new Villa();

                ArrayList<Object> villa_data = new ArrayList<>();
                villa_data.addAll(Arrays.asList(formatted_data_by_line.get(order + 2).toString().split(",")));

                villa = villa.set_all_properties(villa_data);

                customer.services.add(villa);
            } else if (orderCommand.equals("House"))
            {
                House house = new House();

                ArrayList<Object> house_data = new ArrayList<>();
                house_data.addAll(Arrays.asList(formatted_data_by_line.get(order + 2).toString().split(",")));

                house = house.set_all_properties(house_data);

                customer.services.add(house);
            } else if (orderCommand.equals("Room"))
            {
                Room room = new Room();

                ArrayList<Object> room_data = new ArrayList<>();
                room_data.addAll(Arrays.asList(formatted_data_by_line.get(order + 2).toString().split(",")));

                room = room.set_all_properties(room_data);

                customer.services.add(room);
            } else if (orderCommand.equals("Contract"))
            {
                ArrayList<Object> contract_data = new ArrayList<>();
                contract_data.addAll(Arrays.asList(formatted_data_by_line.get(order + 2).toString().split(",")));

                Contract contract = Contract.setContractInformation(contract_data);

                customer.contracts.add(contract);

            } else if (orderCommand.equals("push"))
            {
                customers.add(customer);
            }
        }

        return customers;
    }

    public Customer set_all_customer_properties(ArrayList<Object> customer_data)
    {
        Customer customer = new Customer();
        Iterator iterator = customer_data.iterator();

        customer.setFullName(iterator.next().toString());
        customer.setBirth(iterator.next().toString());
        customer.setCmnd(iterator.next().toString());
        customer.setPhoneNumber(iterator.next().toString());
        customer.setEmail(iterator.next().toString());

        customer.setGender(iterator.next().toString());
        customer.setCustomerType(iterator.next().toString());
        customer.setAddress(iterator.next().toString());

        return customer;
    }



}
