package com.admin.app.formatter;

import com.admin.app.model.Province;
import com.admin.app.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class ProvinceFormatter implements Formatter<Province>
{
    @Autowired
    private ProvinceService provinceService;
    @Override
    public Province parse(String text, Locale locale) throws ParseException
    {
        return provinceService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Province object, Locale locale)
    {
        return String.format(
                "Province: [id=%d,name=%s]",
                object.getId(),object.getName()
        );
    }
}
