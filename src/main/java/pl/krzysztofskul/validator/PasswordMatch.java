package pl.krzysztofskul.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = PasswordMatchValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PasswordMatch {

    String message() default "Potwierdź hasło / Confirm the password!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    String password();
    String passwordConfirmation();

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        PasswordMatch[] value();
    }

}
