package com.simple.command;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/quiz")
public class QuizController {

	@RequestMapping("/quiz01")
	public String quiz01() {
		return "quiz/quiz01";
	}

	@RequestMapping("/quiz01_ok")
	public String quiz01(@RequestParam("year") String Year,
			@RequestParam("month") String Month,
			@RequestParam("day") String Day,
			Model model
			) {

		model.addAttribute("year", Year);
		model.addAttribute("month",Month);
		model.addAttribute("day", Day);

		System.out.println(Day);

		return "quiz/quiz01_ok";

	}

	@RequestMapping("/quiz02")
	public String quiz02() {
		return "quiz/quiz02";
	}

	@RequestMapping("/join")
	public String quiz02(@RequestParam("id") String Id,
			@RequestParam("pw") String Pw,
			@RequestParam("name") String Name,
			@RequestParam("email") String Email,
			Model model
			) {

		model.addAttribute("id",Id); // 키, 값
		model.addAttribute("pw",Pw);
		model.addAttribute("name",Name);
		model.addAttribute("email",Email);

		return "quiz/quiz02_ok";

	}

	@RequestMapping("/quiz03")
	public String quiz03(){
		return "quiz/quiz03";
	}
	@RequestMapping("/quiz03_ok")
	public String ok(@ModelAttribute("id") String id){
		return "quiz/quiz03_ok";
	}
	
	@RequestMapping(value="/join2", method=RequestMethod.POST)
	public String join(@RequestParam("id") String id,
		               @RequestParam("pw") String pw,
		               @RequestParam("pw_check") String pw_check,
		               RedirectAttributes ra) {
		
		if(id.equals("")) {
			ra.addFlashAttribute("msg", "아이디를 입력해주세요"); 
			return "redirect:/quiz/quiz03";
		}else if(!pw.equals(pw_check)){
			ra.addFlashAttribute("msg", "비밀번호를 확인해주세요"); 
			return "redirect:/quiz/quiz03";
		}else {
			
			return "redirect:/quiz/quiz03_ok?id="+id;
		}
		
	}
}




