package BaiTap;

import java.util.Date;

public class StopWatch
{
    private Date startTime;
    private Date endTime;

    public StopWatch()
    {
        this.startTime = new Date();
    }

    public Date getStartTime()
    {
        return this.startTime;
    }

    public Date getEndTime()
    {
        return this.endTime;
    }

    public void start()
    {
        this.startTime = new Date();
    }

    public void stop()
    {
        this.endTime = new Date();
    }

    public long getElapsedTime()
    {
        return this.endTime.getTime() - this.startTime.getTime();
    }
}

class TestTime
{
    public static void main(String[] args)
    {
        StopWatch stopWatch = new StopWatch();
        int[] int_arr = new int[100000];
        for (int i = 0; i < int_arr.length; i++)
        {
            int_arr[i] = (int) Math.floor(Math.random() * 100001);
        }
        System.out.println("Array before selection sort");
        for (int i = 0; i < 10; i++)
        {
            System.out.print(int_arr[i] + "\t");
        }
        System.out.println();
        String result = "-->Selection sort takes : ";
        result += sortBySelection(int_arr, stopWatch);
        System.out.println(result += " milliseconds<--");
    }

    public static long sortBySelection(int[] int_arr, StopWatch stopWatch)
    {
        stopWatch.start();
        int min = 0;
        for (int i = 0; i < int_arr.length - 1; i++)
        {
            if (int_arr[i + 1] < int_arr[i])
            {
                min = int_arr[i + 1];
                int_arr[i + 1] = int_arr[i];
                int_arr[i] = min;
            }
        }
        stopWatch.stop();
        System.out.println("Array after selection sort!");
        for (int i = 0; i < 10; i++)
        {
            System.out.print(i + "\t");
        }
        System.out.println();
        return stopWatch.getElapsedTime();
    }
}
