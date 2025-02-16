package com.luv2code.claimedit.validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Annotation;

public class StartWithCodeValidator implements ConstraintValidator<StartWithCode,String> {

    private String prefix;
    @Override
    public void initialize(StartWithCode constraintAnnotation) {
        this.prefix = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(prefix.startsWith(value))
        {
            return true;
        }
        return false;
    }


}
