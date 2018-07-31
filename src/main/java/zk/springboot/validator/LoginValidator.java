package zk.springboot.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.thymeleaf.util.StringUtils;

import zk.springboot.server.domain.Member;
import zk.springboot.server.domain.dto.LoginVo;
import zk.springboot.server.repository.MemberRepository;

@Component
public class LoginValidator implements Validator {

	@Autowired
	private MemberRepository memberRepository; 
	
	@Override
	public boolean supports(Class<?> clazz) {
		return LoginVo.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "memId", "login.memId.empty");
		ValidationUtils.rejectIfEmpty(errors, "memPwd", "login.memPwd.empty");
		
		LoginVo login = (LoginVo) obj;		
		Optional<Member> loginMem = memberRepository.findById(login.getMemId());
		if(loginMem.isPresent()) {
			if(!StringUtils.equals(login.getMemPwd(), loginMem.get().getMemPwd())) {
				errors.rejectValue("memPwd", "login.memPwd.invalid");
			}
		} else if(!StringUtils.isEmpty(login.getMemId())) {
			errors.rejectValue("memId", "login.memId.isNotPresent");
		}
	}

}
