package zk.springboot.server.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zk.springboot.server.domain.Member;
import zk.springboot.server.repository.MemberRepository;
import zk.springboot.server.service.MemberService;

@Service("memSrvc")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public Member findByMemId(String memId) {
		
		Optional<Member> memOpt = memberRepository.findById(memId);
		if(memOpt.isPresent()) {
			return memOpt.get();
		} else {
			return new Member();
		}
		
	}

	@Override
	public List<Member> findAll() {
		return memberRepository.findAll();
	}

}
