package me.eun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import me.eun.model.Board;
import me.eun.validation.BoardValidator;

@Controller
@RequestMapping("/board/")
public class BoardController {
	
	@GetMapping("/list")
	public String list() {
		return "board/list";
	}

	@GetMapping ("/register")
	public String registerForm(Board board) {
		return "board/register";
		
	}
	@PostMapping ("/register")
	public String register(Board board ,Errors errors) {
		new BoardValidator().validate(board, errors);
		if(errors.hasErrors()) {
			return "board/register";
		}
		
		System.out.println("제목:"+board.getTitle());
		System.out.println("내용:"+board.getContent());
		System.out.println("작성자: "+board.getWriter());
		return "redirect:list";
		
	}
}

//	public String register(Board board ,Errors errors) 여기에 에러 작성해줘야 되는데 board 와 error 사이에 다른 파라미터가 오면 안된다 