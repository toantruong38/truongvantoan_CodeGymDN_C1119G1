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

    private ArrayList<Services> services;

    private String gender;

    private String customerType;

    private String address;

    private ArrayList<Contract> contracts;
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


        return output_information;
    }

    public void export_to_file(ArrayList<Customer> customers, String url)
    {
        String data_to_file = "";
        //Update old customer from file
        customers.addAll(this.import_from_file(url));


        Iterator iter_customers = customers.iterator();
        while (iter_customers.hasNext())
        {
            data_to_file += PERSON_LABEL + CUSTOMER_LABEL;

            Customer customer = (Customer) iter_customers.next();
            data_to_file += "\n" + customer.getFullName() + "," + customer.getBirth() + "," + customer.getCmnd()
                    + "," + customer.getPhoneNumber() + "," + customer.getEmail()
                    + "," + customer.getGender() + "," + customer.getCustomerType() + "," + customer.getAddress() + "\n";

            FuncWriteFileCSV.writeFile(data_to_file, url);
            FuncWriteFileCSV.writeFile("User", BOOKING_ORDER);

            Iterator iter_services = customer.getServices().iterator();
            Iterator iter_contracts = customer.getContracts().iterator();

            while (iter_services.hasNext())
            {
                Object unknown_service = iter_services.next();
                if (unknown_service instanceof Villa)
                {
                    Villa villa = (Villa) unknown_service;
                    ArrayList<Services> services_list = new ArrayList<>();
                    services_list.add(villa);
                    villa.export_to_file(services_list, url);

                    Contract contract = (Contract) iter_contracts.next();
                    data_to_file = Contract.CONTRACT_LABEL;
                    data_to_file += "\n" + contract.getContractNumber() + "," + contract.getStartDay()
                            + "," + contract.getEndDay() + "," + contract.getDeposit() + "," + contract.getDeposit() + "\n";

                    FuncWriteFileCSV.writeFile(data_to_file, url);
                    FuncWriteFileCSV.writeFile("Villa", BOOKING_ORDER);
                } else if (unknown_service instanceof House)
                {
                    House house = (House) unknown_service;
                    ArrayList<Services> services_list = new ArrayList<>();
                    services_list.add(house);
                    house.export_to_file(services_list, url);

                    Contract contract = (Contract) iter_contracts.next();
                    data_to_file = Contract.CONTRACT_LABEL;
                    data_to_file += "\n" + contract.getContractNumber() + "," + contract.getStartDay()
                            + "," + contract.getEndDay() + "," + contract.getDeposit() + "," + contract.getDeposit() + "\n";

                    FuncWriteFileCSV.writeFile(data_to_file, url);
                    FuncWriteFileCSV.writeFile("House", BOOKING_ORDER);
                } else if (unknown_service instanceof Room)
                {
                    Room room = (Room) unknown_service;
                    ArrayList<Services> services_list = new ArrayList<>();
                    services_list.add(room);
                    room.export_to_file(services_list, url);

                    FuncWriteFileCSV.writeFile("Room", BOOKING_ORDER);
                }
            }
            FuncWriteFileCSV.writeFile("push", BOOKING_ORDER);
        }
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

        Iterator iterator_order = booking_order_by_line.iterator();
        Iterator iterator_data = formatted_data_by_line.iterator();

        while (iterator_order.hasNext())
        {
            if (iterator_order.next().equals("User"))
            {
                iterator_data.next(); //Skip the customer label line

                ArrayList<Object> customer_data = new ArrayList<>();
                customer_data.addAll(Arrays.asList(iterator_data.next().toString().split(",")));

                customer = this.set_all_customer_properties(customer_data);

            } else if (iterator_order.next().equals("Villa"))
            {
                iterator_data.next(); //Skip the villa label line

                Villa villa = new Villa();
                ArrayList<Object> villa_data = new ArrayList<>();
                villa_data.addAll(Arrays.asList(iterator_data.next().toString().split(",")));

                villa = villa.set_all_properties(villa_data);
                customer.setService(villa);


            } else if (iterator_order.next().equals("House"))
            {
                iterator_data.next(); //Skip the house label line


                House house = new House();
                ArrayList<Object> house_data = new ArrayList<>();
                house_data.addAll(Arrays.asList(iterator_data.next().toString().split(",")));

                house = house.set_all_properties(house_data);
                customer.setService(house);


            } else if (iterator_order.next().equals("Room"))
            {
                iterator_data.next(); //Skip the room label line

                Room room = new Room();
                ArrayList<Object> room_data = new ArrayList<>();
                room_data.addAll(Arrays.asList(iterator_data.next().toString().split(",")));

                room = room.set_all_properties(room_data);
                customer.setService(room);
            } else if (iterator_order.next().equals("Contract"))
            {
                //The next line must be contract
                Contract contract = new Contract();
                iterator_data.next(); //Skip the Contract label line

                ArrayList<Object> contract_data = new ArrayList<>();
                contract_data.addAll(Arrays.asList(iterator_data.next().toString().split(",")));

                contract = customer.set_all_contract_properties(contract_data);

                customer.setContract(contract);
            } else if (iterator_order.next().equals("push"))
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

    public Contract set_all_contract_properties(ArrayList<Object> contract_data)
    {
        Contract contract = new Contract();
        Iterator iterator = contract_data.iterator();

        contract.setContractNumber(iterator.next().toString());
        contract.setStartDay(iterator.next().toString());
        contract.setEndDay(iterator.next().toString());
        contract.setDeposit((long) iterator.next());
        contract.setTotalPay((long) iterator.next());

        return contract;
    }
}
