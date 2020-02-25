package com.toantr.webapp.validator;

import com.toantr.webapp.persistence.model.customer.Customer;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

//@Component
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
    }
}
