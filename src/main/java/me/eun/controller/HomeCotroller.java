package me.eun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeCotroller {
		
		@GetMapping("/")
		public String home() {
			return "home";
		}
		
		@GetMapping("/admin/list")
		public String test() {
			System.out.println("컨트롤러 실행 : Admin");
			return "admin";
		}
	}

