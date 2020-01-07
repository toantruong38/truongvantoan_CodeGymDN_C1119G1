package Controllers;

import Models.Customer;
import Models.House;
import Models.Room;
import Models.Villa;

import java.io.IOException;
import java.util.Scanner;
import java.util.UUID;

public class MainController
{
    public static void main(String[] args)
    {
        displayMainMenu();
    }

    public static void displayMainMenu()
    {
        Scanner input = new Scanner(System.in);
        String showOptions = "1.Add new services\n" +
                "2.Show services\n" +
                "3.Add new customer\n" +
                "4.Show information customer\n" +
                "5.Add new booking resort\n" +
                "6.Exit";
        short option;
        System.out.println(showOptions);
        option = input.nextShort();
        switch (option)
        {
            case 1:
                addNewServices();
                break;
            case 2:
                showServices();
                break;
            case 3:
                addNewCustomer();
                displayMainMenu();
                break;
            case 4:
                showInformationCustomer();
                displayMainMenu();
                break;
            case 5:
                addNewBookingResort();
                displayMainMenu();
                break;
            default:
                System.out.println("Fail");
                break;
        }
    }

    public static void addNewBookingResort()
    {
        //String options="1.Booking"
    }

    public static void addNewCustomer()
    {
        Scanner input = new Scanner(System.in);

        Customer customer = new Customer();
        customer.setId(UUID.randomUUID().toString().replace("-", ""));

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
        customer.setAddr(input.nextLine());
        System.out.print("Customer type: ");
        customer.setCustomerType(input.nextLine());
        System.out.print("Phone number: ");
        customer.setPhoneNum(input.nextLine());

        FuncWriteFileCSV.main(customer, "customer");
    }

    public static void showInformationCustomer()
    {
        try
        {
            FuncReadFileCSV.sortMe();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void addNewServices()
    {
        Scanner input = new Scanner(System.in);
        String showOptions = "1.Add new villa\n" +
                "2.Add new house\n" +
                "3.Add new room\n" +
                "4.Back to menu\n" +
                "5.Exit";
        short addOption;
        System.out.println(showOptions);
        addOption = input.nextShort();
        switch (addOption)
        {
            case 1:
                addNewVilla();
                displayMainMenu();
                break;
            case 2:
                addNewHouse();
                displayMainMenu();
                break;
            case 3:
                addNewRoom();
                displayMainMenu();
                break;
            case 4:
                displayMainMenu();
                break;
            case 5:
                break;
            default:
                System.out.println("Fail");
                break;
        }
    }

    public static void addNewVilla()
    {
        Villa villa = new Villa();
        villa.setId(UUID.randomUUID().toString().replace("-", ""));
        Scanner input = new Scanner(System.in);
        String serviceNameRegexp = "^[A-Z][a-z]*($|([\\s][A-Z][a-z]*)+$)";
        while (true)
        {
            System.out.print("Service name: ");
            String temp = input.nextLine();
            if (temp.matches(serviceNameRegexp))
            {
                villa.setServiceName(temp);
                break;
            } else
            {
                System.out.println("Please type again!");
            }
        }
        while (true)
        {
            System.out.println("Area using: ");
            double temp = input.nextDouble();
            if (temp > 30)
            {
                villa.setArea(temp);
                break;
            } else
            {
                System.out.println("Please type again!");
            }
        }
        while (true)
        {
            System.out.println("Rent fee: ");
            long temp = input.nextLong();
            if (temp >= 0)
            {
                villa.setRentFee(temp);
                break;
            } else
            {
                System.out.println("Please type again!");
            }
        }
        while (true)
        {
            System.out.println("Max person: ");
            int temp = input.nextInt();
            if (temp > 0 && temp < 20)
            {
                villa.setMaxPerson(temp);
                break;
            } else
            {
                System.out.println("Please type again!");
            }
        }
        while (true)
        {
            System.out.print("Rent type: ");
            String temp = input.nextLine();
            if (temp.matches(serviceNameRegexp))
            {
                villa.setRentType(temp);
                break;
            } else
            {
                System.out.println("Please type again!");
            }
        }
        while (true)
        {
            System.out.print("Room standard: ");
            String temp = input.nextLine();
            if (temp.matches(serviceNameRegexp))
            {
                villa.setRoomStandard(temp);
                break;
            } else
            {
                System.out.println("Please type again!");
            }
        }
        System.out.print("Other convenient description: ");
        villa.setConvenientDescr(input.nextLine());
        System.out.print("Pool area: ");
        villa.setPoolArea(input.nextInt());
        while (true)
        {
            System.out.println("Floor amount: ");
            short floorAmount = input.nextShort();
            if (floorAmount > 0)
            {
                villa.setFloorAmount(floorAmount);
                break;
            } else
            {
                System.out.println("Please type again!");
            }
        }
        while (true)
        {
            System.out.println("Accompany service: ");
            String temp = input.nextLine();
            if (temp == "massage" || temp == "karaoke" || temp == "food" || temp == "drink" || temp == "car")
            {
                villa.setAccompanyService(temp);
                break;
            } else
            {
                System.out.println("Please type again!");
            }
        }
        FuncWriteFileCSV.main(villa, "villa");
    }

    public static void addNewHouse()
    {
        House house = new House();
        house.setId(UUID.randomUUID().toString().replace("-", ""));
        Scanner input = new Scanner(System.in);
        String serviceNameRegexp = "^[A-Z][a-z]*($|([\\s][A-Z][a-z]*)+$)";
        while (true)
        {
            System.out.print("Service name: ");
            String temp = input.nextLine();
            if (temp.matches(serviceNameRegexp))
            {
                house.setServiceName(temp);
                break;
            } else
            {
                System.out.println("Please type again!");
            }
        }
        while (true)
        {
            System.out.println("Area using: ");
            double temp = input.nextDouble();
            if (temp > 30)
            {
                house.setArea(temp);
                break;
            } else
            {
                System.out.println("Please type again!");
            }
        }
        while (true)
        {
            System.out.println("Rent fee: ");
            long temp = input.nextLong();
            if (temp >= 0)
            {
                house.setRentFee(temp);
                break;
            } else
            {
                System.out.println("Please type again!");
            }
        }
        while (true)
        {
            System.out.println("Max person: ");
            int temp = input.nextInt();
            if (temp > 0 && temp < 20)
            {
                house.setMaxPerson(temp);
                break;
            } else
            {
                System.out.println("Please type again!");
            }
        }
        while (true)
        {
            System.out.print("Rent type: ");
            String temp = input.nextLine();
            if (temp.matches(serviceNameRegexp))
            {
                house.setRentType(temp);
                break;
            } else
            {
                System.out.println("Please type again!");
            }
        }
        while (true)
        {
            System.out.print("Room standard: ");
            String temp = input.nextLine();
            if (temp.matches(serviceNameRegexp))
            {
                house.setRoomStandard(temp);
                break;
            } else
            {
                System.out.println("Please type again!");
            }
        }
        System.out.print("Other convenient description: ");
        house.setConvenientDescr(input.nextLine());

        while (true)
        {
            System.out.println("Floor amount: ");
            short floorAmount = input.nextShort();
            if (floorAmount > 0)
            {
                house.setFloorAmount(floorAmount);
                break;
            } else
            {
                System.out.println("Please type again!");
            }
        }
        while (true)
        {
            System.out.println("Accompany service: ");
            String temp = input.nextLine();
            if (temp == "massage" || temp == "karaoke" || temp == "food" || temp == "drink" || temp == "car")
            {
                house.setAccompanyService(temp);
                break;
            } else
            {
                System.out.println("Please type again!");
            }
        }
        FuncWriteFileCSV.main(house, "house");
    }


    public static void addNewRoom()
    {
        Room room = new Room();
        room.setId(UUID.randomUUID().toString().replace("-", ""));
        Scanner input = new Scanner(System.in);
        String serviceNameRegexp = "^[A-Z][a-z]*($|([\\s][A-Z][a-z]*)+$)";
        while (true)
        {
            System.out.print("Service name: ");
            String temp = input.nextLine();
            if (temp.matches(serviceNameRegexp))
            {
                room.setServiceName(temp);
                break;
            } else
            {
                System.out.println("Please type again!");
            }
        }
        while (true)
        {
            System.out.println("Area using: ");
            double temp = input.nextDouble();
            if (temp > 30)
            {
                room.setArea(temp);
                break;
            } else
            {
                System.out.println("Please type again!");
            }
        }
        while (true)
        {
            System.out.println("Rent fee: ");
            long temp = input.nextLong();
            if (temp >= 0)
            {
                room.setRentFee(temp);
                break;
            } else
            {
                System.out.println("Please type again!");
            }
        }
        while (true)
        {
            System.out.println("Max person: ");
            int temp = input.nextInt();
            if (temp > 0 && temp < 20)
            {
                room.setMaxPerson(temp);
                break;
            } else
            {
                System.out.println("Please type again!");
            }
        }
        while (true)
        {
            System.out.print("Rent type: ");
            String temp = input.nextLine();
            if (temp.matches(serviceNameRegexp))
            {
                room.setRentType(temp);
                break;
            } else
            {
                System.out.println("Please type again!");
            }
        }

        while (true)
        {
            System.out.println("Accompany service: ");
            String temp = input.nextLine();
            if (temp == "massage" || temp == "karaoke" || temp == "food" || temp == "drink" || temp == "car")
            {
                room.setAccompanyService(temp);
                break;
            } else
            {
                System.out.println("Please type again!");
            }
        }

        System.out.print("Free accompany service: ");
        room.setAccompanyService(input.nextLine());

        FuncWriteFileCSV.main(room, "room");
    }

    public static void showServices()
    {
        String optionDisplay = "1.Show all villa\n" +
                "2.Show all house\n" +
                "3.Show all room\n" +
                "4.Back to menu\n" +
                "5.Exit";
        Scanner input = new Scanner(System.in);
        System.out.println(optionDisplay);
        String selection = input.nextLine();
        switch (selection)
        {
            case "1":
                String url = "C:\\Users\\Admin\\Downloads\\Documents\\CodeGym\\truongvantoan_CodeGymDN_C1119G1\\Module2\\CaseStudy\\src\\Data\\Villa.csv";
                FuncReadFileCSV.main(url);
                displayMainMenu();
                break;
            case "2":
                url = "C:\\Users\\Admin\\Downloads\\Documents\\CodeGym\\truongvantoan_CodeGymDN_C1119G1\\Module2\\CaseStudy\\src\\Data\\House.csv";
                FuncReadFileCSV.main(url);
                displayMainMenu();
                break;
            case "3":
                url = "C:\\Users\\Admin\\Downloads\\Documents\\CodeGym\\truongvantoan_CodeGymDN_C1119G1\\Module2\\CaseStudy\\src\\Data\\Room.csv";
                FuncReadFileCSV.main(url);
                displayMainMenu();
                break;
            case "4":
                displayMainMenu();
                break;
            case "5":
                break;
            default:
                System.out.println("Fail");
                break;
        }
    }
}
