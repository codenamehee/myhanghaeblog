package com.hanghae.blog.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PWValidator.class)
@Documented
public @interface IfExcludeId {
    String value() default "username";

    String message() default "Password is not allow";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
//    Class[] groups() default {};
//    Class[] payload() default {};
}
