package com.toantr.webapp.converter;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//@Component
public class StringToDateConverter implements Converter<String, Date>
{
    @Override
    public Date convert(String s)
    {
        DateFormat formatter=new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        try
        {
            Date date=(Date)formatter.parse(s);
            return date;
        } catch (ParseException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public JavaType getInputType(TypeFactory typeFactory)
    {
        return null;
    }

    @Override
    public JavaType getOutputType(TypeFactory typeFactory)
    {
        return null;
    }
}
