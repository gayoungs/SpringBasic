package com.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.simple.command.ScoreVO;
import com.simple.service.ScoreService;
import com.simple.service.ScoreServiceImpl;

@Controller
@RequestMapping("/service")
public class ScoreController {

	//1st
	//ScoreServiceImpl service = new ScoreServiceImpl();
	
	//2nd - 직접 빈등록 자동주입
//	@Autowired
//	ScoreService service;
		
	
	//3nd
	@Autowired
	ScoreService service;
	
	
	
	
	
	//등록화면
	@RequestMapping("/scoreRegist")
	public String regist() {
		return "service/scoreRegist";

	}

	//목록화면
	@RequestMapping("/scoreList")
	public String scoreRegist() {
		return "service/scoreList";

	}

	//결과화면
	@RequestMapping("/scoreResult")
	public String scoreResult() {
		return "service/scoreResult";

	}
	
	//등록요청
	@RequestMapping(value ="/scoreForm", method = RequestMethod.POST)
	public String scoreform(ScoreVO vo) {
		
		//System.out.println(vo.toString());
		//service.scoreRegist(vo);
	
		
		return "";
	}

}
