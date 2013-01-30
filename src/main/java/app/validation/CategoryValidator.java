/*package app.validation;

import javax.xml.validation.Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import app.domain.Category;

public abstract class CategoryValidator extends Validator {
	
	public boolean supports(Class clazz) {
        return Category.class.equals(clazz);
    }
    
    public void validate(Object obj, Errors e) {
        ValidationUtils.rejectIfEmpty(e, "name", "name.empty");
        Category category = (Category) obj;
        //if (category.getAge() < 0) {
        //    e.rejectValue("name", "negativevalue");
        //}
    }
}
*/