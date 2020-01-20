package pl.krzysztofskul.validator;

import org.springframework.beans.factory.annotation.Autowired;
import pl.krzysztofskul.user.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    private UserService userService;

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value == null) return false;

        if (userService == null) return true;

        return !userService.isExistent(value);
    }
}
