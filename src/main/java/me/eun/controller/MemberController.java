package me.eun.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import me.eun.model.Member;
import me.eun.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController { 
	
	@Autowired
	MemberService service; 
	
	@GetMapping("/success")
	public String success() {
		return "member/success";
	}
	
	@GetMapping("/register")
	public String registerForm(Member member) {
		return "member/register";
		
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Member> list = service.getList();
		model.addAttribute("memberlist", list);
		return "member/list";
	}
	
	@PostMapping("/register")
	public String register(@Valid Member member ,Errors errors) {
//		new MemberValidator().validate(member, errors);
		if(errors.hasErrors()) {
			return "member/register";
		}
		return "redirect:success";
	}
}
