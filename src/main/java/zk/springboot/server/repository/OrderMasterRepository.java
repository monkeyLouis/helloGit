package zk.springboot.server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import zk.springboot.server.domain.OrderMaster;

@Transactional
public interface OrderMasterRepository extends CrudRepository<OrderMaster, String> {
	
	List<OrderMaster> findAll();
	
	@Query("SELECT om.member.memName from OrderMaster om")
	List<String> findAllOmName();
	
}
