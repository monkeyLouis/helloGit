package zk.springboot.server.service;

import java.util.Date;
import java.util.List;

import zk.springboot.server.domain.OrderMaster;
import zk.springboot.server.domain.dto.StatusVo;

public interface OrderMasterService {
	
	OrderMaster save(OrderMaster om);
	List<OrderMaster> findByDate(Date date,  StatusVo status);
	List<OrderMaster> findAll();
		
}
