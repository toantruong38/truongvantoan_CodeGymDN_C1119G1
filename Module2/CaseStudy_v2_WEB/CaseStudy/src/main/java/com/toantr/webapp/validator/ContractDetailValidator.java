package com.toantr.webapp.validator;

import com.toantr.webapp.persistence.model.contractdetail.ContractDetail;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ContractDetailValidator implements Validator
{
    @Override
    public boolean supports(Class<?> clazz)
    {
        return ContractDetail.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors)
    {
        ContractDetail contractDetail=(ContractDetail)target;
        if(contractDetail.getQuantity()<0){
            errors.rejectValue("quantity","quantity.negative");
        }
    }
}
