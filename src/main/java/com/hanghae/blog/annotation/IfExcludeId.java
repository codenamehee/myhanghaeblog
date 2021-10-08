package com.hanghae.blog.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PWValidator.class)
@Documented
public @interface IfExcludeId {
    // 어노테이션에 들어올 값
//    String value() default "username";
    // 오류시에 나올 메시지
    String message() default "";
    // 어떤 유효성 검증 범위에 소속되게 할 지 정의하는 것
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
