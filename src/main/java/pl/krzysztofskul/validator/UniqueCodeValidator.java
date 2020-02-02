package pl.krzysztofskul.validator;

import org.springframework.beans.factory.annotation.Autowired;
import pl.krzysztofskul.device.category.DeviceCategoryService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueCodeValidator implements ConstraintValidator<UniqueCode, String> {

    @Autowired
    private DeviceCategoryService deviceCategoryService;

    @Override
    public void initialize(UniqueCode constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value == null) return false;

        if (deviceCategoryService == null) return true;

        return !deviceCategoryService.isExistent(value);
    }
}
