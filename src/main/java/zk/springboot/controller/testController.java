package zk.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zk.springboot.server.domain.Member;
import zk.springboot.server.repository.MemberRepository;

@RestController
public class testController {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@RequestMapping("/test")
	public List<Member> test(){
		return memberRepository.findAll();
	}
	
}
