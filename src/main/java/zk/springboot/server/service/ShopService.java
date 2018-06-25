package zk.springboot.server.service;

import java.util.List;

import zk.springboot.server.domain.Shop;

public interface ShopService {
	
	Shop save(Shop shop);
	List<Shop> findAll();
	Shop findById(String shopId);
	
}
