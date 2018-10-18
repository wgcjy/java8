package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author:zhouxuan
 * @Description: 自定义注解
 * @Date:2018/1/15 0015 23:19
 */
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String[] value() default {};

    String[] params() default {};

    boolean required() default true;

}
