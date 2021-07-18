package com.board.home;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.home.dto.SampleDTO;
import com.board.home.dto.SampleDTOList;
import com.board.home.dto.TodoDTO;

import lombok.extern.log4j.Log4j;



@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

	//파라미터의 형태를 Data로 바꾸는 어노테이션
	/*
	 * @InitBinder public void initBinder(WebDataBinder binder) { SimpleDateFormat
	 * dateFormat = new SimpleDateFormat("YYYY-MM-DD");
	 * binder.registerCustomEditor(java.util.Date.class, new
	 * CustomDateEditor(dateFormat, false)); }
	 */
	
	@RequestMapping("")
	public void basic() {
		log.info("basic........");
	}
	
	@RequestMapping(value="/basic", method = {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		log.info("basic get............");
		
	}
	
	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		log.info("basic get onlyget............");
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO samDTO) {
		log.info(""+samDTO);
		return "ex01";
	}
	
	@GetMapping("/ex02")
	//@RequestParam 파라미터로 사용되는 변수리흠과 전달되는 파라미터 이름이 다른경우 사용한다.
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		log.info("name : " + name);
		log.info("age : " + age);
		return "ex02";
	}
	
	
	@GetMapping("/ex02List")
	//@RequestParam 파라미터로 사용되는 변수리흠과 전달되는 파라미터 이름이 다른경우 사용한다.
	public String ex02(@RequestParam("ids")ArrayList<String> ids) {
		log.info("ids : " + ids );
		return "ex02List";
	}
	
	@GetMapping("/ex02Array")
	//@RequestParam 파라미터로 사용되는 변수리흠과 전달되는 파라미터 이름이 다른경우 사용한다.
	public String ex02(@RequestParam("ids") String[] ids) {
		log.info("Array ids : " + Arrays.toString(ids) );
		return "ex02Array";
	}
	
	//여러개의 DTO를 처리하는방법 
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		log.info(" list dtos "+ list);
		
		return "ex02Bean";
	}
	
	//날짜 처리하는 어노테이션 사용방법 @initBinder 이 없으면 에러발생
	//DTO 에서 date 형태를 지정해주는 어노테이션 @DatatimeFormat(pattern ="yyyy-mm-dd") 를 해주면 @initBinder이 필요없다
	@GetMapping("/ex03") 
	public String ex03(TodoDTO todo) { 
		  log.info("todo : " + todo);
	  
		  return "ex03";
	}
	 
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, int page) {
		log.info("dto : " + dto);
		log.info("page : " + page);
		
		return "/ex04/ex04";
	}
	
	
	//@ModelAttribute --> 원래는 DTO에 없는 매개변수는 jsp로 가지 않으나
	// @ModelAttribute 이 붙은 매개변수의 경우는 무조건 model에 담아서 jsp 화면으로 보낸준다.
	@GetMapping("/ex04s")
	public String ex04s(SampleDTO dto, @ModelAttribute("page") int page) {
		log.info("dto : " + dto);
		log.info("page : " + page);
		
		return "/ex04/ex04";
	}
	
	@GetMapping("/ex05")
	public @ResponseBody SampleDTO ex06() {
		log.info("ex05..............");
		
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("홍길동");
		
		return dto;
	}
	
	
	
	
	
}
