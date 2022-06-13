package me.eun.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import me.eun.model.Board;

public class BoardValidator  implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Board.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Board board = (Board) target;
		if(board.getTitle()==null || board.getTitle().trim().isEmpty()) {
			errors.rejectValue("title", "required");
			return;
			
		}
		if(board.getTitle().length()<3 || board.getTitle().length()>=100) {
			errors.rejectValue("title", "length");
		}
	}

}
