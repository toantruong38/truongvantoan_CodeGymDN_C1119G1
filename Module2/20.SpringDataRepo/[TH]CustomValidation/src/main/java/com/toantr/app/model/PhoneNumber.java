package com.toantr.app.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class PhoneNumber implements Validator
{
    private String number;

    public String getNumber(){
        return this.number;
    }
    public void setNumber(String number){
        this.number=number;
    }
    @Override
    public boolean supports(Class<?> clazz)
    {
        return PhoneNumber.class.isAssignableFrom(clazz);
    }
    @Override
    public void validate(Object target, Errors errors){
        PhoneNumber phoneNumber=(PhoneNumber)target;
        String number=phoneNumber.getNumber();
        ValidationUtils.rejectIfEmpty(errors,"number","numberError.empty");
        if(number.length()!=10){
            errors.rejectValue("number","numberError.length");
        }
        if(!number.startsWith("0")){
            errors.rejectValue("number","numberError.startsWith");
        }
        if(!number.matches("^[\\d]{10}$")){
            errors.rejectValue("number","numberError.matches");
        }
    }
}
