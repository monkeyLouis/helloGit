package zk.springboot.controller.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zk.springboot.server.domain.Member;
import zk.springboot.server.domain.rest.RestResponse;
import zk.springboot.server.service.MemberService;
import zk.springboot.util.MessageUtil;

@RestController
public class MemberRestController {

	/**
	 * Spring Validation Need
	 */
//	@Autowired
//	private MemberValidator memberValidator;

	@Autowired
	private MemberService memberSrvc;
	
	/**
	 * Spring Validation Need
	 */
//	@InitBinder
//	protected void initBinder(WebDataBinder binder) {
//		binder.addValidators(memberValidator);
//	}
	
	/**
	 * For Ajax update
	 * (Spring Validation)
	 * @param mem
	 * @return Member
	 */
	@PostMapping(value="/member/update")
	public RestResponse save(@RequestBody @Validated Member mem, BindingResult result) {
		if(result.hasErrors()){
			List<FieldError> list = result.getFieldErrors();
			Map<String, String> map = MessageUtil.getErrorMessage(list);
			
			return new RestResponse<Map<String, String>>(1, "data NG", map);
		}
		
		return new RestResponse<Member>(0, "data OK",memberSrvc.update(mem));
	}
	
	/**
	 * For Ajax update
	 * (JSR-303 Validation)
	 * (Deprecated)
	 * @param mem
	 * @return
	 */
//	@PostMapping(value="/member/update303")
//	public RestResponse save303(@RequestBody MemberAnnotation mem) {
//		
//		Map<String, String> map = mem.validateParamWithGroup(Edit.class);
//		if (!map.isEmpty()){
//			return new RestResponse<Map<String, String>>(1, "data NG", map);
//		}	
//		
//		return new RestResponse<Member>(0, "data OK", memberSrvc.update(mem));
//	}
	
	/**
	 * Test for JSR-303 (from jsp/test.jsp)
	 * @param mem
	 * @param result
	 * @return memberId
	 */
	@RequestMapping(value="/valid")
	public String valid(@ModelAttribute("vm") @Validated Member mem, BindingResult result) {
		
		if (result.hasErrors())
			return "member GG";
		
		return mem.getMemId();
	}
	
	
}
