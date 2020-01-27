package pl.krzysztofskul.validator;

import org.springframework.beans.BeanWrapperImpl;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StatusPlannerMatchValidator implements ConstraintValidator<StatusPlannerMatch, Object> {
    
    private String status;
    private String planner;

    @Override
    public void initialize(StatusPlannerMatch constraintAnnotation) {
        this.status = constraintAnnotation.status();
        this.planner = constraintAnnotation.planner();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        Object statusValue = new BeanWrapperImpl(object).getPropertyValue(status).toString();
        Object plannerValue = new BeanWrapperImpl(object).getPropertyValue(planner);

        if (plannerValue == null || "User{id=null}".equals(plannerValue) || plannerValue.equals("") || "User{id=0}".equals(plannerValue) || plannerValue.toString().equals("User{id=0}")) {
             if ("OCZEKUJE / WAITING".equals(statusValue) || "ZAKOŃCZONY / FINISHED".equals(statusValue)) {
                 return true;
             }
        }
        if ("W TOKU / IN PROGRESS".equals(statusValue)) {
            if (plannerValue != null && !"User{id=null}".equals(plannerValue) && !plannerValue.equals("") && !plannerValue.toString().equals("User{id=0}")) {
                return true;
            }
        }
        return false;

    }

}
