package me.eun.common;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import me.eun.validation.FieldMatchValidator;

@Documented
@Constraint(validatedBy = {FieldMatchValidator.class})
@Target ({ElementType.TYPE,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldMatch {

	String message () default "이 필드들은 서로 부합되어야 한다";
	Class<?>[] groups ()default{};
	Class<? extends Payload>[] payload() default{};
	String first(); //첫번째 필드 
	String second();//두번째 필드
	
	
	@Target ({ElementType.TYPE,ElementType.ANNOTATION_TYPE})
	@Documented
	@Retention(RetentionPolicy.RUNTIME)
	@interface List {
		FieldMatch[] value ();
	}
}
 