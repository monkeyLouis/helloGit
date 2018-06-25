package zk.springboot.server.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zk.springboot.server.domain.Shop;
import zk.springboot.server.repository.ShopRepository;
import zk.springboot.server.service.ShopService;

@Service("shopSrvc")
public class ShopServiceImpl implements ShopService{
	
	@Autowired
	private ShopRepository shopRepository;

	@Override
	@Transactional(readOnly=true)
	public List<Shop> findAll() {
		return shopRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Shop findById(String shopId) {
		Optional<Shop> shopOpt = shopRepository.findById(shopId);
		
		if(shopOpt.isPresent()){
			System.out.println(shopOpt.get().getFoodList().size());
			return shopOpt.get();
		}
		
		return null;
	}

	@Override
	public Shop save(Shop shop) {
		return shopRepository.save(shop);
	}
	
	
	
}
