package zk.springboot.server.service;

import java.util.List;

import zk.springboot.server.domain.OrderMaster;

public interface OrderMasterService {
	
	OrderMaster save(OrderMaster om);
	List<OrderMaster> findAll();
		
}
