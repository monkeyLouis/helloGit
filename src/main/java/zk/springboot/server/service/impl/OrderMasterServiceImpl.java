package zk.springboot.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zk.springboot.server.domain.OrderMaster;
import zk.springboot.server.domain.OrderDetail;
import zk.springboot.server.repository.OrderMasterRepository;
import zk.springboot.server.service.OrderMasterService;

import static java.util.stream.Collectors.*;

@Service("orderMasterSrvc")
public class OrderMasterServiceImpl implements OrderMasterService {

	@Autowired
	private OrderMasterRepository orderMasterRepository;
	
	@Override
	public List<OrderMaster> findAll() {
		List<OrderMaster> omList = orderMasterRepository.findAll();
		for(OrderMaster om : omList) {
			List<OrderDetail> odList = om.getOdList();
			Integer omSum = 0;
			for(OrderDetail od : odList) {
				omSum += od.getFoodId().getF_price();
			}
			om.setOmSum(omSum);
		}
		return omList;
	}

	@Override
	public OrderMaster save(OrderMaster om) {
		return orderMasterRepository.save(om);
	}

}
