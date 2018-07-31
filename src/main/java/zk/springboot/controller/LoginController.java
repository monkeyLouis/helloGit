package zk.springboot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import zk.springboot.server.domain.Member;
import zk.springboot.server.domain.dto.LoginVo;
import zk.springboot.server.service.MemberService;
import zk.springboot.validator.LoginValidator;

@Controller
public class LoginController {
	
	private static final Logger LOG = LoggerFactory.getLogger(LoginController.class); 
	
	@Autowired
	private MemberService memberSrvc;
	
	@Autowired
	private LoginValidator loginValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(loginValidator);
	}
	
	/**
	 * For show All Member List
	 * (Test datasource connect normally)
	 * @param req
	 * @return String
	 */
//	@Test
//	@RequestMapping(value="/")
//	public String show(HttpServletRequest req){
//		//	Test for get in Method
////		System.out.println("In show()");
//		List<Member> list = memberSrvc.findAll();
//		//	Use ModelAndView
////		ModelAndView view = new ModelAndView("show");
////		view.addObject("list",list);
//		req.setAttribute("list", list);
//		
//		return "member/show";
//	}
	
	/**
	 * Test for JSR-303
	 * And direct to .jsp
	 * @param req
	 * @param mem
	 * @param result
	 * @return String
	 */
	@Test
	@RequestMapping(value="/jspTest")
	public String jspTest(HttpServletRequest req, @ModelAttribute("vm") @Validated Member mem, BindingResult result){
		
		req.setAttribute("vm", mem);
		if(result.hasErrors()){
			return "jsp/test";
		}
		
		List<Member> list = memberSrvc.findAll();
		req.setAttribute("list", list);
		return "member/content";
	}
	
	/**
	 * To Login Page
	 * 
	 * @param req
	 * @return String
	 */
	@RequestMapping(value="/")
	public String index (HttpServletRequest req) {
		req.setAttribute("mem", new LoginVo());
		return "jsp/login";
	}
	
	/**
	 * For Login Form
	 * 
	 * @param model
	 * @param mem
	 * @param result
	 * @return
	 */
	@RequestMapping(value="/", params={"method=login", "ident=mem"})
	public String login (Model model, @ModelAttribute("mem") @Validated LoginVo mem, BindingResult result) {
		if(result.hasErrors()){
			return "jsp/login";
		}
		LOG.info("##### Get In login #####");
		model.addAttribute("list", memberSrvc.findAll());
		return "redirect:/member/showAll";
	}
	
	@RequestMapping(value="/", params={"method=login", "ident=admin"})
	public String loginForAdmin (Model model, @ModelAttribute("mem") @Validated LoginVo mem, BindingResult result) {
		System.out.println("In loginForAdmin.");
		
		if(result.hasErrors()){
			return "jsp/login";
		}
		
		return "redirect:/admin";
	}
	
}
