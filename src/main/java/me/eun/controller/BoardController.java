package me.eun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import me.eun.model.Board;

@Controller
@RequestMapping("/board/")
public class BoardController {
	
	@GetMapping("/list")
	public String list() {
		return "board/list";
	}

	@GetMapping ("/register")
	public String registerForm() {
		return "board/register";
		
	}
	@PostMapping ("/register")
	public String register(Board board) {
		System.out.println("제목:"+board.getTitle());
		System.out.println("내용:"+board.getTitle());
		System.out.println("작성자"+board.getWriter());
		return "redirect:list";
		
	}
}
