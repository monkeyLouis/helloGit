package zk.springboot.server.service;

import java.util.List;

import zk.springboot.server.domain.Member;

public interface MemberService {
	
	Member findByMemId(String memId);
	List<Member> findAll();
	
}
