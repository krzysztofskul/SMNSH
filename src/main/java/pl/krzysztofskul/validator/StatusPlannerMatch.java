package pl.krzysztofskul.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = StatusPlannerMatchValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface StatusPlannerMatch {

    String message() default "Błędne dopasowanie Status-Projektant / Wrong match Status-Designer!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String status();
    String planner();

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List{
        StatusPlannerMatch[] value();
    }

}