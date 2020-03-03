package com.toantr.webapp.validator;

import com.toantr.webapp.persistence.model.contract.Contract;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        Date beginDate=null;
        Date endDate=null;

        if(contract.getEndDate().equals("")){
            errors.rejectValue("endDate","date.invalid");
        }else{
            try
            {
                endDate=new SimpleDateFormat("MM/dd/yyyy").parse(contract.getEndDate());
            } catch (ParseException e)
            {
                System.out.println(e.getMessage());
            }
        }
        if (contract.getBeginDate().equals("")) {
            errors.rejectValue("beginDate","date.invalid");
        }else{
            try
            {
                beginDate=new SimpleDateFormat("MM/dd/yyyy").parse(contract.getBeginDate());
            }catch (ParseException e){
                System.out.println(e.getMessage());
            }
        }
        if(contract.getDeposit()<0){
            errors.rejectValue("deposit","deposit.negative");
        }
        if(contract.getTotalPay()<0){
            errors.rejectValue("totalPay","totalPay.negative");
        }
        if(beginDate!=null&&endDate!=null){
            if(beginDate.after(endDate)){
                errors.rejectValue("beginDate","date.order");
            }
        }
    }
}
