package me.eun.validation;

import java.lang.reflect.InvocationTargetException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

import me.eun.common.FieldMatch;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object>{
	
	
	private String firstFieldName;
	private String secondFieldName;
	private String message; //에러메세지

	//@fieldMatch (first="conformPassword")
	
	@Override
	public void initialize(FieldMatch constraintAnnotation) {
		firstFieldName = constraintAnnotation.first();
		secondFieldName = constraintAnnotation.second();
		message = constraintAnnotation.message();
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		boolean valid = true;
		// 검증 
		try {
			Object firstObj = BeanUtils.getProperty(context, firstFieldName);
			Object secondObj = BeanUtils.getProperty(context, secondFieldName);
			valid = firstObj != null && secondObj != null && firstObj.equals(secondObj);
			if(!valid) {
				context.buildConstraintViolationWithTemplate(message)
				.addPropertyNode(firstFieldName)
				.addConstraintViolation()
				.disableDefaultConstraintViolation();
			}
			
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		} catch (InvocationTargetException e) {
		
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
		
			e.printStackTrace();
		}
		return valid;
	}

	

}
