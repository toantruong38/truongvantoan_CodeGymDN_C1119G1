package com.toantr.webapp.validator;

import com.toantr.webapp.persistence.model.Service;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ServiceValidator implements Validator
{
    @Override
    public boolean supports(Class<?> clazz)
    {
        return Service.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors)
    {
        Service service=(Service)target;

        if(service.getArea()<0){
            errors.rejectValue("area","area.negative");
        }
        if(service.getFloorAmount()<0){
            errors.rejectValue("floorAmount","floorAmount.negative");
        }
        if(service.getMaximumPeople()<0){
            errors.rejectValue("maximumPeople","maximumPeople.negative");
        }
        if(service.getRentFee()<0){
            errors.rejectValue("rentFee","rentFee.negative");
        }

    }
}
