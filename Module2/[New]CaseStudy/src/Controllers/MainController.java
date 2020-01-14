package Controllers;

import Libs.ProfileDeck;
import Models.*;

import java.util.*;

public class MainController
{
    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Object> object_data =
            new ArrayList<>();

    public static void main(String[] args)
    {
        MainController mC = new MainController();

        mC.displayMainMenu();
    }

    public void displayMainMenu()
    {
        String options = "1.Add new services"
                + "\n" + "2.Show services"
                + "\n" + "3.Add new customer"
                + "\n" + "4.Show information customer"
                + "\n" + "5.Add new booking resort"
                + "\n" + "6.Show information employee"
                + "\n" + "7.Dat ve xem film"
                + "\n" + "8.Search employee"
                + "\n" + "9.Exit";
        String mainMenuOption = "";
        System.out.println(options);

        mainMenuOption = input.nextLine();
        switch (mainMenuOption)
        {
            case "1":
                serviceSelection();

                displayMainMenu();
                return;
            case "2":
                showServices();
                displayMainMenu();

                return;
            case "3":
                addNewCustomer();
                displayMainMenu();
                return;
            case "4":
                System.out.println(showCustomersInformation());
                displayMainMenu();
                return;
            case "5":
                bookingResort();

                //System.out.printf("");
                mainMenuOption = input.nextLine();

                displayMainMenu();
                return;
            case "6":
                System.out.println(showInformationEmployee());
                displayMainMenu();
                return;
            case "7":
                cinema();

                mainMenuOption = input.nextLine();
                displayMainMenu();
                return;
            case "8":
                System.out.printf("Employee name:");
                String empName = input.nextLine();
                searchEmployee(empName);

                mainMenuOption = input.nextLine();
                displayMainMenu();

            case "9":
                System.exit(0);
                return;
            default:
                System.out.println("Here");
                System.out.println("Failed");
        }
    }

    public void searchEmployee(String empName)
    {
        Employee emp = ProfileDeck.search(empName);

        if (emp == null)
        {
            System.out.println("Not found");
        } else
        {
            System.out.println(emp.showInformation());
        }
    }

    public void cinema()
    {
        String customersInformation = "";

        int soLuongVe = 5;

        Queue<Customer> cinema_cus = new LinkedList<>();

        Customer cus = new Customer();

        ArrayList<Customer> customers = cus.import_from_file(Person.PERSON_URL + Customer.BOOKING_URL);

        System.out.println("Ban co muon dat ve xem film?");
        System.out.printf("(Y)es/(N)o: ");
        String option = input.nextLine().toLowerCase();

        if (option.equals("y"))
        {

            while (soLuongVe > 0)
            {
                for (int i = 0; i < customers.size(); i++)
                {
                    System.out.println((i + 1) + customers.get(i).showInformation());

                }
                System.out.println("Con " + soLuongVe + " ve trong");
                System.out.printf("Chon customer: ");

                int cus_index = input.nextInt();

                if (cus_index < 0 || cus_index >= customers.size())
                {
                    System.out.println("Failed");
                    //soLuongVe++;
                    continue;
                } else
                {
                    cinema_cus.add(customers.get(cus_index));
                    soLuongVe--;
                }

            }
        } else
        {
            displayMainMenu();
            return;
        }

        System.out.println("Danh sach xem film gom: ");

        Iterator iterator = cinema_cus.iterator();

        while (iterator.hasNext())
        {
            System.out.println(((Customer) iterator.next()).showInformation());
        }
        //displayMainMenu();
    }

    public void showServices()
    {
        String options = "1.Show all villa"
                + "\n" + "2.Show all house"
                + "\n" + "3.Show all room"
                + "\n" + "4.Show all villa name not duplicate"
                + "\n" + "5.Show all house name not duplicate"
                + "\n" + "6.Show all room name not duplicate"
                + "\n" + "7.Back to menu"
                + "\n" + "8.Exit";
        System.out.println(options);
        switch (input.nextLine())
        {
            case "1":
                System.out.println(showAllServices("Villa"));
                displayMainMenu();
                return;

            case "2":
                System.out.println(showAllServices("House"));
                displayMainMenu();
                return;

            case "3":
                System.out.println(showAllServices("Room"));
                displayMainMenu();
                return;

            case "4":
                System.out.println(showAllServices("Villa", true));
                displayMainMenu();
                return;
            case "5":
                System.out.println(showAllServices("House", true));
                displayMainMenu();
                return;
            case "6":
                System.out.println(showAllServices("Room", true));
                displayMainMenu();
                return;
            case "7":
                displayMainMenu();
                return;
            case "8":
                System.exit(0);
            default:
                System.out.println("Failed!");
        }
    }

    public String showInformationEmployee()
    {


        Employee emp = new Employee();

        emp.setEmployeeData();

        Map<String, Employee> employeeMap = Employee.employeeMap;

        Iterator emp_iter = employeeMap.values().iterator();

        String emps_infor = "";

        while (emp_iter.hasNext())
        {
            emps_infor += ((Employee) emp_iter.next()).showInformation() + "\n";
        }

        return emps_infor;
    }

    public void bookingResort()
    {
        Customer cus = new Customer();
        ArrayList<Customer> customers = cus.import_from_file(Person.PERSON_URL + Customer.BOOKING_URL);
        int cus_count = 1;
        String cusInfo = "";
        int cusIndex = -1;

        for (Customer item : customers)
        {
            cusInfo += cus_count + item.showInformation() + "\n";

            cus_count++;
        }
        System.out.println(cusInfo);


        System.out.printf("Select customer to book:");
        cusIndex = input.nextInt() - 1;

        if (cusIndex < 0 || cusIndex >= customers.size())
        {
            System.out.println("Failed!");
            return; /// make some handle here!!!
        } else
        {
            Customer current_cus = customers.get(cusIndex);

            System.out.printf("1.Booking villa\n" +
                    "2.Booking house\n" +
                    "3.Booking room\n");
            System.out.printf("Select: ");


            input = new Scanner(System.in);
            String booking_option = input.nextLine();

            ArrayList<Services> all_services = new ArrayList<>();
            switch (booking_option)
            {
                case "1":

                    Villa villa = new Villa();
                    all_services.addAll(villa.import_from_file(villa.SERVICE_URL + villa.VILLA_URL));

                    for (int i = 0; i < all_services.size(); i++)
                    {
                        System.out.println((i + 1) + all_services.get(i).showInfor());
                    }

                    System.out.printf("Select: ");
                    int villa_index = input.nextInt() - 1;

                    if (villa_index < 0 || villa_index >= all_services.size())
                    {
                        System.out.println("Failed");
                    } else
                    {
                        current_cus.setService(all_services.get(villa_index));
                    }

//                    addNewService();
//                    current_cus.setService(addNewVilla());


                    break;
                case "2":


                    House house = new House();
                    all_services.addAll(house.import_from_file(house.SERVICE_URL + house.HOUSE_URL));

                    for (int i = 0; i < all_services.size(); i++)
                    {
                        System.out.println((i + 1) + all_services.get(i).showInfor());
                    }

                    System.out.printf("Select: ");
                    int house_index = input.nextInt() - 1;

                    if (house_index < 0 || house_index >= all_services.size())
                    {
                        System.out.println("Failed");
                    } else
                    {
                        current_cus.setService(all_services.get(house_index));
                    }

//                    addNewService();
//                    current_cus.setService(addNewHouse());
                    break;
                case "3":


                    Room room = new Room();
                    all_services.addAll(room.import_from_file(room.SERVICE_URL + room.ROOM_URL));

                    for (int i = 0; i < all_services.size(); i++)
                    {
                        System.out.println((i + 1) + all_services.get(i).showInfor());
                    }

                    System.out.printf("Select: ");
                    int room_index = input.nextInt() - 1;

                    if (room_index < 0 || room_index >= all_services.size())
                    {
                        System.out.println("Failed");
                    } else
                    {
                        current_cus.setService(all_services.get(room_index));
                    }


//                    addNewService();
//                    current_cus.setService(addNewRoom());
                    break;
                default:
                    System.out.println("Failed!");
                    return;
                // add some exception handling here
            }
//            ArrayList<Customer> new_customers=new ArrayList<>();
//            new_customers.add(current_cus);


            current_cus.export_to_file(customers, Person.PERSON_URL + Customer.BOOKING_URL);


        }
    }

    public String showCustomersInformation()
    {
        String customersInformation = "";
        Customer cus = new Customer();


        ArrayList<Customer> customers = cus.import_from_file(Person.PERSON_URL + Customer.BOOKING_URL);

        Collections.sort(customers, new CustomerSort());

        for (Customer item : customers)
        {
            customersInformation += item.showInformation() + "\n";
        }

        return customersInformation;
    }

    public String showAllServices(String serviceType, boolean duplicate)
    {
        String servicesInformation = "";

        if (duplicate)
        {
            switch (serviceType)
            {
                case "Villa":
                    Iterator villas = Villa.villaTreeSet.iterator();

                    while (villas.hasNext())
                    {
                        servicesInformation += ((Villa) villas.next()).showInfor() + "\n";
                    }

                    return servicesInformation;

                case "House":
                    Iterator houses = House.houseTreeSet.iterator();

                    while (houses.hasNext())
                    {
                        servicesInformation += ((House) houses.next()).showInfor() + "\n";
                    }

                    return servicesInformation;

                case "Room":

                    Iterator rooms = Room.roomTreeSet.iterator();

                    while (rooms.hasNext())
                    {
                        servicesInformation += ((Room) rooms.next()).showInfor() + "\n";
                    }

                    return servicesInformation;
            }
        }


        return "Error at \"showAllService\" function";
    }

    public String showAllServices(String serviceType)
    {
        String servicesInformation = "";

        switch (serviceType)
        {
            case "Villa":

                Villa villa = new Villa();
                ArrayList<Services> villaArrayList = villa.import_from_file(
                        villa.SERVICE_URL + villa.VILLA_URL
                );


                for (Services item : villaArrayList)
                {
                    servicesInformation += item.showInfor() + "\n";
                }

                return servicesInformation;

            case "House":

                House house = new House();
                ArrayList<Services> houseArrayList = house.import_from_file(
                        house.SERVICE_URL + house.HOUSE_URL
                );


                for (Services item : houseArrayList)
                {
                    servicesInformation += item.showInfor() + "\n";
                }

                return servicesInformation;

            case "Room":

                Room room = new Room();
                ArrayList<Services> roomArrayList = room.import_from_file(
                        room.SERVICE_URL + room.ROOM_URL
                );


                for (Services item : roomArrayList)
                {
                    servicesInformation += item.showInfor() + "\n";
                }

                return servicesInformation;
        }

        return "Error at \"showAllService\" function";
    }

    public void addNewCustomer()
    {
        Customer customer = new Customer();

        String fullNameRegexp = "^[A-Z][a-z]*($|([\\s][A-Z][a-z]*)+$)";
        while (true)
        {
            System.out.print("Full name: ");
            String temp = input.nextLine();
            if (temp.matches(fullNameRegexp))
            {
                customer.setFullName(temp);
                break;
            } else
            {
                System.out.println("Please type again!");
            }
        }

        String emailRegexp = "^[\\w]+[\\d]*\\@[\\w]+\\.[\\w]+$";
        while (true)
        {
            System.out.print("Email : ");
            String temp = input.nextLine();
            if (temp.matches(emailRegexp))
            {
                customer.setEmail(temp);
                break;
            } else
            {
                System.out.println("Please type again!");
            }
        }

        String idCarRegexp = "^[0-9]{9}$";
        while (true)
        {
            System.out.print("Cmnd : ");
            String temp = input.nextLine();
            if (temp.matches(idCarRegexp))
            {
                customer.setCmnd(temp);
                break;
            } else
            {
                System.out.println("Please type again!");
            }
        }

        String birthRegexp = "^([0][1-9]|[1-2][1-9]|[3][0-1])\\/([0][1-9]|[1][0-2])\\/([1][9][0-9]{2}|[2][0-9]{2}[0-1])$";
        while (true)
        {
            System.out.print("Birth(dd/mm/yyyy) : ");
            String temp = input.nextLine();
            if (temp.matches(birthRegexp))
            {
                customer.setBirth(temp);
                break;
            } else
            {
                System.out.println("Please type again!");
            }
        }

        while (true)
        {
            System.out.print("Gender: ");
            String temp = input.nextLine();
            temp = temp.toLowerCase();
            if (temp.equals("male") || temp.equals("female") || temp.equals("unknown"))
            {
                char c = Character.toUpperCase(temp.charAt(0));
                temp.replaceFirst("\\w", String.valueOf(c));
                customer.setGender(temp);
                break;
            } else
            {
                System.out.println("Please type again!");
            }
        }
        System.out.print("Address: ");
        customer.setAddress(input.nextLine());
        System.out.print("Customer type: ");
        customer.setCustomerType(input.nextLine());
        System.out.print("Phone number: ");
        customer.setPhoneNumber(input.nextLine());

        ArrayList<Customer> cus = new ArrayList<>();
        cus.add(customer);

        //Update with old customers
        cus.addAll(customer.import_from_file(Person.PERSON_URL + Customer.BOOKING_URL));

        customer.export_to_file(cus, Person.PERSON_URL + Customer.BOOKING_URL);
    }

    public void serviceSelection()
    {
        System.out.println("1.Add new villa\n" +
                "2.Add new house\n" +
                "3.Add new room\n" +
                "4.Back to menu");
        String selection = input.nextLine();
        switch (selection)
        {
            case "1":
                addNewService();
                addNewVilla();
                return;
            case "2":
                addNewService();
                addNewHouse();
                return;
            case "3":
                addNewService();
                addNewRoom();
                return;
            case "4":
                //Return menu
                return;
            default:
                System.out.println("Failed!");
        }
    }

    public void addNewService()
    {

        //ID
        object_data.add(UUID.randomUUID().toString().replace("-", ""));

        //ServiceName
        System.out.printf("Service name: ");
        String temp = input.nextLine();
        String regexp = "^[A-Z][a-z]*($|([\\s][A-Z][a-z]*)+$)";
        while (!temp.matches(regexp))
        {
            System.out.printf("Please type again!: ");
            temp = input.nextLine();
        }
        object_data.add(temp);

        //AreaUsing
        System.out.printf("Area using: ");
        double areaUsing = input.nextDouble();
        while (!(areaUsing > 30))
        {
            System.out.printf("Please type again!: ");
            areaUsing = input.nextDouble();
        }
        object_data.add(areaUsing);

        //Rentfee
        System.out.printf("Rent fee: ");
        long rentFee = input.nextLong();

        while (rentFee < 0)
        {
            System.out.printf("Please type again!: ");
            rentFee = input.nextLong();
        }
        object_data.add(rentFee);

        //Max people
        System.out.printf("Maximum people: ");
        short maximumPeople = input.nextShort();

        input = new Scanner(System.in);

        while (maximumPeople < 0 || maximumPeople > 20)
        {
            System.out.printf("Please type again!: ");
            maximumPeople = input.nextShort();
        }
        object_data.add(maximumPeople);

        //Rent type
        System.out.printf("Rent type: ");
        String rentType = input.nextLine();
        while (!rentType.matches(regexp))
        {
            System.out.printf("Please type again!: ");
            rentType = input.nextLine();
        }
        object_data.add(rentType);
    }

    public Villa addNewVilla()
    {
        System.out.printf("Room standard: ");
        String roomStandard = input.nextLine();
        String regexp = "^[A-Z][a-z]*($|([\\s][A-Z][a-z]*)+$)";
        while (!roomStandard.matches(regexp))
        {
            System.out.printf("Please type again!: ");
            roomStandard = input.nextLine();
        }
        object_data.add(roomStandard);

        System.out.printf("Convenient Description: ");
        object_data.add(input.nextLine());

        System.out.printf("Pool area: ");
        double poolArea = input.nextDouble();
        while (poolArea < 30)
        {
            System.out.printf("Please type again!: ");
            poolArea = input.nextDouble();
        }
        object_data.add(poolArea);

        System.out.printf("Floor amount: ");
        short floorAmount = input.nextShort();
        while (floorAmount < 0)
        {
            System.out.printf("Please type again!: ");
            floorAmount = input.nextShort();
        }
        object_data.add(floorAmount);

        addNewAcpnyService();
        Villa villa = new Villa();
        villa = villa.set_all_properties(object_data);
        ArrayList<Services> services = new ArrayList<>();
        services.add(villa);

        services.addAll(villa.import_from_file(villa.SERVICE_URL + villa.VILLA_URL));
        villa.export_to_file(services, villa.SERVICE_URL + villa.VILLA_URL);


        object_data.clear();
        return villa;
    }

    public House addNewHouse()
    {
        System.out.printf("Room standard: ");
        String roomStandard = input.nextLine();
        String regexp = "^[A-Z][a-z]*($|([\\s][A-Z][a-z]*)+$)";
        while (!roomStandard.matches(regexp))
        {
            System.out.printf("Please type again!: ");
            roomStandard = input.nextLine();
        }
        object_data.add(roomStandard);


        System.out.printf("Convenient Description: ");
        object_data.add(input.nextLine());

        System.out.printf("Floor amount: ");
        short floorAmount = input.nextShort();
        while (floorAmount < 0)
        {
            System.out.printf("Please type again!: ");
            floorAmount = input.nextShort();
        }
        object_data.add(floorAmount);
        addNewAcpnyService();
        House house = new House();
        house = house.set_all_properties(object_data);
        ArrayList<Services> services = new ArrayList<>();
        services.add(house);

        services.addAll(house.import_from_file(house.SERVICE_URL + house.HOUSE_URL));
        house.export_to_file(services, house.SERVICE_URL + house.HOUSE_URL);

        object_data.clear();
        return house;
    }

    public Room addNewRoom()
    {
        System.out.printf("Free service: ");
        object_data.add(input.nextLine());
        addNewAcpnyService();
        Room room = new Room();
        room = room.set_all_properties(object_data);
        ArrayList<Services> services = new ArrayList<>();
        services.add(room);

        services.addAll(room.import_from_file(room.SERVICE_URL + room.ROOM_URL));
        room.export_to_file(services, room.SERVICE_URL + room.ROOM_URL);

        object_data.clear();
        return room;
    }

    public void addNewAcpnyService()
    {
        System.out.println("------Accompany service------");

        System.out.printf("Accompany service name: ");//--->

        input = new Scanner(System.in);

        String temp = input.nextLine();

        while (!(temp.equals("massage") || temp.equals("karaoke") || temp.equals("food") || temp.equals("drink") || temp.equals("car")))
        {
            System.out.printf("Please type again!: ");
            temp = input.nextLine();
        }

        object_data.add(temp);

        System.out.printf("Accompany service cost: ");//--->
        long cost = input.nextLong();

        while (cost < 0)
        {
            System.out.printf("Please type again!: ");
            cost = input.nextLong();
        }

        object_data.add(cost);
        input = new Scanner(System.in);

        System.out.printf("Accompany service currency: ");//--->
        object_data.add(input.nextLine());

    }
}
