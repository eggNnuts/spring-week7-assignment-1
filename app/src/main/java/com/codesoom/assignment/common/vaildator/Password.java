package com.codesoom.assignment.common.vaildator;

import com.codesoom.assignment.common.vaildator.validatorImpl.PasswordValidatorImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;

@Target({FIELD, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidatorImpl.class)
@Documented
public @interface Password {
    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int min() default 4;

    int max() default 30;

    boolean useSizeCheck() default true;

    boolean nullable() default false;

}
