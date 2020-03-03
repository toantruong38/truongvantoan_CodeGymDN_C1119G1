package com.toantr.webapp.validator;

import com.toantr.webapp.persistence.model.customer.Customer;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CustomerValidator implements Validator
{
    @Override
    public boolean supports(Class<?> clazz)
    {
        return Customer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors)
    {
        Customer customer=(Customer)target;
        final String email=customer.getEmail();
        final String phoneNumber=customer.getPhoneNumber();
        final String idNumber=customer.getIdNumber();
        if(!email.matches("^[\\w]{1,3}[[\\d]*\\w]{6,9}@[\\w]{3,5}\\.[\\w]{3,5}$"))
        {
            errors.rejectValue("email","email.invalid");
        }
        if(!phoneNumber.matches("^((091|090)[0-9]{7})|(\\(84\\)\\+(90|91)[0-9]{7})$"))
        {
            errors.rejectValue("phoneNumber","phoneNumber.invalid");
        }
        if(!idNumber.matches("^[\\d]{9}$"))
        {
            errors.rejectValue("idNumber","idNumber.invalid");
        }
        if(customer.getBirth().equals("")){
            errors.rejectValue("birth","birth.invalid");
        }
    }
}
