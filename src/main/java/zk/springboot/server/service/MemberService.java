package zk.springboot.server.service;

import java.util.List;
import java.util.Optional;

import zk.springboot.server.domain.Member;

public interface MemberService {
	List<Member> findAll();
	Member update(Member mem);
	Optional<Member> findOne(String id);
	
}
