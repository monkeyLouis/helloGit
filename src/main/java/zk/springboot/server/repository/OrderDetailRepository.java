package zk.springboot.server.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import zk.springboot.server.domain.OrderDetail;
import zk.springboot.server.domain.OrderDetailId;


@Transactional
public interface OrderDetailRepository extends CrudRepository<OrderDetail, OrderDetailId> {
	
	List<OrderDetail> findAll();
	
}
