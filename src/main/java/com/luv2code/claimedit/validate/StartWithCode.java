package com.luv2code.claimedit.validate;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = StartWithCodeValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface StartWithCode {

    String value();
    String message() default "must start with {value}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
