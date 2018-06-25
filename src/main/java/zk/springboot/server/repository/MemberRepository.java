package zk.springboot.server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import zk.springboot.server.domain.Member;

@Transactional
public interface MemberRepository extends CrudRepository<Member, String> {
	
	List<Member> findAll();
	
	@Query("SELECT m.memName from Member m")
	List<String> findAllName();
}
