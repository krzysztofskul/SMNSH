package pl.krzysztofskul.validator;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, Object> {

    private String password;
    private String passwordConfirmation;

    @Override
    public void initialize(PasswordMatch passwordMatch) {
        this.password = passwordMatch.password();
        this.passwordConfirmation = passwordMatch.passwordConfirmation();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Object passwordValue = new BeanWrapperImpl(value).getPropertyValue(password);
        Object passwordConfirmationValue = new BeanWrapperImpl(value).getPropertyValue(passwordConfirmation);

        if (passwordValue != null) {
            return passwordValue.equals(passwordConfirmationValue);
        } else {
            return passwordConfirmationValue == null;
        }
    }
}
