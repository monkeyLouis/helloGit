package zk.springboot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import zk.springboot.server.domain.Member;
import zk.springboot.server.service.MemberService;
import zk.springboot.validator.SignUpValidator;

@Controller
@RequestMapping(value = "/member")
public class MemberController {

	@Autowired
	private MemberService memberSrvc;
	
	@Autowired
	private SignUpValidator signUpValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(signUpValidator);
	}
	
	/**
	 * Go To showAll page (with thymeleaf)
	 * Default Page
	 * @param req
	 * @return String
	 */
	@RequestMapping(value="/showAll")
	public String content(HttpServletRequest req){
		List<Member> list = memberSrvc.findAll();
		req.setAttribute("list", list);
		
		return "member/content";
	}
	
	/**
	 * Go to sign up page
	 * (GET Method)
	 * @return
	 */
	@RequestMapping(value="/signUp")
	public String signUp(Model model) {
		model.addAttribute("mem", new Member());
		return "member/signUp";
	}
	
	/**
	 * For sign up page form
	 * (POST Method)
	 * @param model
	 * @param mem
	 * @param result
	 * @return
	 */
	@RequestMapping(value="/signUp", method=RequestMethod.POST)
	public String signUp(Model model, @ModelAttribute("mem") @Validated Member member, BindingResult result) {		
		
		if(result.hasErrors()){
			return "member/signUp";
		}
		
		memberSrvc.update(member);
		model.addAttribute("list", memberSrvc.findAll());
		
		return "member/content";
	}
}
