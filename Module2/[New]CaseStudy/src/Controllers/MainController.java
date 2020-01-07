package Controllers;

import Models.House;
import Models.Room;
import Models.Services;
import Models.Villa;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class MainController
{
    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Object> object_data =
            new ArrayList<>();

    public static void main(String[] args)
    {

    }

    public static void addNewService()
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

    public static Villa addNewVilla()
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
        villa.set_all_properties(object_data);
        ArrayList<Services> services = new ArrayList<>();
        services.add(villa);
        villa.export_to_file(services, villa.SERVICE_URL + villa.VILLA_URL);


        object_data.clear();
        return villa;
    }

    public static House addNewHouse()
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
        house.set_all_properties(object_data);
        ArrayList<Services> services = new ArrayList<>();
        services.add(house);
        house.export_to_file(services, house.SERVICE_URL + house.HOUSE_URL);

        object_data.clear();
        return house;
    }

    public static Room addNewRoom()
    {
        System.out.printf("Free service: ");
        object_data.add(input.nextLine());
        addNewAcpnyService();
        Room room = new Room();
        room.set_all_properties(object_data);
        ArrayList<Services> services = new ArrayList<>();
        services.add(room);
        room.export_to_file(services, room.SERVICE_URL + room.ROOM_URL);

        object_data.clear();
        return room;
    }

    public static void addNewAcpnyService()
    {
        System.out.println("------Accompany service------");

        System.out.printf("Accompany service name: ");//--->
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

        System.out.printf("Accompany service currency: ");//--->
        object_data.add(input.nextLine());

    }
}
