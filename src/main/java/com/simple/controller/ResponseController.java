package com.simple.controller;




import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.ReqVO;


@Controller
@RequestMapping("/response")
public class ResponseController {

	@RequestMapping("/res_ex01")
	public void ex01() {

	}
	
	//model전달자
	@RequestMapping("/ex02")
	public String ex02(Model model) {
		
		model.addAttribute("name","홍길동");
		model.addAttribute("date", new Date());
		
		return "response/ex02";
		
	}
	
	//ModelAndView - 데이터와 화면 정보를 동시에 저장하는 객체
	@RequestMapping("/ex03")
	public ModelAndView ex03(ModelAndView mv) {
	
		//ModelAndView mv = new ModelAndView();
		mv.addObject("serverTime", new Date());//데이터
		mv.setViewName("response/ex03");//화면정보
		
		return mv;
	}
	
	//@ModelAttribute(화면에서 넘어오는 키값)
	@RequestMapping("/ex04")
	public String ex04(@ModelAttribute("id") String id) {
		 
		System.out.println("넘어온 값:" + id);
		
		return "response/ex04";
	}
	
	//ModelAttribute객체타입 vo받아서 xxx이름으로 변경해서 화면으로 전달.
	@RequestMapping("/ex05")
	public String ex05(@ModelAttribute("xxx") ReqVO vo) {
		
		System.out.println(vo.toString());
		
		return "response/ex05";
	}
	
	/////////////////////////////////////////////
	////////리디렉션과 리다렉션어트리뷰트
	
	//화면처리
	@RequestMapping("/join")
	public String join() {
		return "response/join";
	}

	//폼요청
	@RequestMapping(value = "/joinForm", method=RequestMethod.POST)
	public String joinForm(ReqVO vo, RedirectAttributes ra) {
			
			//가입처리~~~~했습니다~~~~~
		
			//리다이렉트시에 사용하며, 1회성 데이터를 화면에 전달해줄 수 있습니다.
		    //리다이렉트시에 model은 사용할 수 없습니다.
			ra.addFlashAttribute("msg", "정상 처리되었습니다");

			return "redirect:/"; //redirect:/절대경로
			//다시컨트롤러를 태워보낸다.
	}
	
	//실습
	
	//화면요청
	@RequestMapping("/res_quiz01")
	public String res_quiz01() {
		return "response/res_quiz01";
	}

	@RequestMapping(value ="/res_login", method= RequestMethod.POST)
	public String res_login(@RequestParam("id")String id,
							@RequestParam("pw")String pw,
							Model model,
							RedirectAttributes ra) {
	if(id.equals("kim12")&&pw.equals("1234")) { //로그인성공 가정
		model.addAttribute("id", id);		//forward 모델 사용 
		return "response/res_quiz02";
	}else {
		ra.addFlashAttribute("msg", "alert('로그인 실패')");
		//ra.addFlashAttribute("msg", "아이디 비밀번호를 확인하세요");
		return "redirect:/response/res_quiz01";	
	}
			
	}
	
}


