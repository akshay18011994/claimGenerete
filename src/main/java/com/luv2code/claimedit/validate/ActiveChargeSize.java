package com.luv2code.claimedit.validate;

import com.luv2code.claimedit.entity.Charge;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

@Constraint(validatedBy = ActiveChargeSizeValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface  ActiveChargeSize {
    String value();
    String message() default "Atleast one active charge required!!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
