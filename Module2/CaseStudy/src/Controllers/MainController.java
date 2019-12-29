package Controllers;

import Models.House;
import Models.Room;
import Models.Villa;

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
                "3.Exit";
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
                break;
            default:
                System.out.println("Fail");
                break;
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
        System.out.print("Rent type(day,hour,month...): ");
        input = new Scanner(System.in);
        villa.setRentType(input.nextLine());

        System.out.print("Villa standard: ");
        villa.setRoomStandard(input.nextLine());
        System.out.print("Other convenient description: ");
        villa.setConvenientDescr(input.nextLine());
        System.out.print("Pool area: ");
        villa.setPoolArea(input.nextInt());
        System.out.print("Number of floor: ");
        villa.setFloorAmount(input.nextShort());

        FuncWriteFileCSV.main(villa, "villa");
    }

    public static void addNewHouse()
    {
        House house = new House();
        house.setId(UUID.randomUUID().toString().replace("-", ""));
        Scanner input = new Scanner(System.in);
        System.out.print("Service name: ");
        house.setServiceName(input.nextLine());
        System.out.print("Area using: ");
        house.setArea(input.nextInt());
        System.out.print("Rent fee: ");
        house.setRentFee(input.nextInt());
        System.out.print("Maximum people: ");
        house.setMaxPerson(input.nextInt());
        System.out.print("Rent type(day,hour,month...): ");
        house.setRentType(input.nextLine());

        System.out.print("House standard: ");
        house.setRoomStandard(input.nextLine());
        System.out.print("Other convenient description: ");
        house.setConvenientDescr(input.nextLine());
        System.out.print("Number of floor: ");
        house.setFloorAmount(input.nextShort());

        FuncWriteFileCSV.main(house, "house");
    }

    public static void addNewRoom()
    {
        Room room = new Room();
        room.setId(UUID.randomUUID().toString().replace("-", ""));
        Scanner input = new Scanner(System.in);
        System.out.print("Service name: ");
        room.setServiceName(input.nextLine());
        System.out.print("Area using: ");
        room.setArea(input.nextInt());
        System.out.print("Rent fee: ");
        room.setRentFee(input.nextInt());
        System.out.print("Maximum people: ");
        room.setMaxPerson(input.nextInt());
        System.out.print("Rent type(day,hour,month...): ");
        room.setRentType(input.nextLine());

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
