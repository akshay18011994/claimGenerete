package com.luv2code.claimedit.validate;

import com.luv2code.claimedit.entity.Charge;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ActiveChargeSizeValidator implements ConstraintValidator<ActiveChargeSize,List<Charge>> {

    String prefix;
    @Override
    public void initialize(ActiveChargeSize constraintAnnotation) {
        prefix=constraintAnnotation.value();
    }

    @Override
    public boolean isValid(List<Charge> charges, ConstraintValidatorContext constraintValidatorContext) {
        List<Charge> listCharge =charges.stream().filter(c-> null!=c && c.getStatus().equals(prefix)).collect(Collectors.toList());

        if(!listCharge.isEmpty())
        {
            return true;
        }
        return false;
    }
}
