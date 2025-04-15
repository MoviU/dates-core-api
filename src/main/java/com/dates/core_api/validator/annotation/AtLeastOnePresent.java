package com.dates.core_api.validator.annotation;

import com.dates.core_api.validator.AtLeastOnePresentValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AtLeastOnePresentValidator.class)
public @interface AtLeastOnePresent {
    String[] fields();
    String message() default "";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
