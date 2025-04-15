package com.dates.core_api.validator;

import com.dates.core_api.validator.annotation.AtLeastOnePresent;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class AtLeastOnePresentValidator implements ConstraintValidator<AtLeastOnePresent, Object> {
    private String[] fieldNames;
    private String customMessage;

    @Override
    public void initialize(AtLeastOnePresent constraintAnnotation) {
        this.fieldNames = constraintAnnotation.fields();

        if ((this.customMessage = constraintAnnotation.message()).isEmpty()) {
            final String ERROR_MESSAGE = "At least one of the following fields must be provided: %s";

            this.customMessage = ERROR_MESSAGE.formatted(
                    String.join(", ", this.fieldNames)
            );
        }
    }

    @Override
    public boolean isValid(Object dto, ConstraintValidatorContext constraintValidatorContext) {
        BeanWrapperImpl wrapper = new BeanWrapperImpl(dto);

        for (String fieldName : fieldNames) {
            var fieldValue = wrapper.getPropertyValue(fieldName);

            if (fieldValue instanceof String str && !str.trim().isEmpty()) {
                return true;
            }

            if (!(fieldValue instanceof String)) {
                if (!fieldValue.toString().trim().isEmpty()) return true;
            }
        }

        constraintValidatorContext.disableDefaultConstraintViolation();
        constraintValidatorContext.buildConstraintViolationWithTemplate(customMessage)
                .addConstraintViolation();

        return false;
    }
}
