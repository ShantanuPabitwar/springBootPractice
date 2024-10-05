package com.eazybytes.eazyschool.annotation;

import com.eazybytes.eazyschool.validation.PasswordStrengthValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = PasswordStrengthValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RUNTIME)
public @interface PasswordValidator {
    String message() default "Enter strong password";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
