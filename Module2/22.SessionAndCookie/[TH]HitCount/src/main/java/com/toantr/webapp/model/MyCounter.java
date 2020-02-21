package com.toantr.webapp.model;

public class MyCounter
{
    private int count;

    public MyCounter(int count)
    {
        this.count = count;
    }

    public int getCount()
    {
        return this.count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    public MyCounter()
    {
    }
    public int increment(){
        return this.count++;
    }
}
