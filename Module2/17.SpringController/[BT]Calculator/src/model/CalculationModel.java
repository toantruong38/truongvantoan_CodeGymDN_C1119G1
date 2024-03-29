package model;

public class CalculationModel
{
    private double o1;
    private double o2;

    public CalculationModel(){

    }
    public CalculationModel(double o1,double o2)
    {
        this.o1=o1;
        this.o2=o2;
    }

    public double getO1()
    {
        return this.o1;
    }

    public void setO1(double o1)
    {
        this.o1 = o1;
    }

    public double getO2()
    {
        return this.o2;
    }

    public void setO2(double o2)
    {
        this.o2 = o2;
    }

    public double calculate(String command) throws Exception
    {
        switch (command)
        {
            case "+":
                return o1+o2;
            case "-":
                return o1-o2;
            case "*":
                return o1*o2;
            case "/":
                if(o2==0) throw new Exception("Divided by zero exception");
                return o1/o2;
            default:
                throw new Exception("Unknown command");
        }
    }
}
