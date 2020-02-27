package com.toantr.webapp.validator;

import com.toantr.webapp.persistence.model.contract.Contract;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ContractValidator implements Validator
{
    @Override
    public boolean supports(Class<?> clazz)
    {
        return Contract.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors)
    {
        Contract contract=(Contract)target;
        if(contract.getDeposit()<0){
            errors.rejectValue("deposit","deposit.negative");
        }
        if(contract.getTotalPay()<0){
            errors.rejectValue("totalPay","totalPay.negative");
        }
    }
}
