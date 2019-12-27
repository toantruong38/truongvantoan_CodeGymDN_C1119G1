public class Vehicle
{
    protected String brand = "Ford";

    public void honk()
    {
        System.out.println("Tuut, tuut!");
    }
}

class Car extends Vehicle
{
    private String modelName = "Mustang";

    public static void main(String[] args)
    {
        Car car = new Car();
        car.honk();
        System.out.println(car.brand + " " + car.modelName);
    }
}
