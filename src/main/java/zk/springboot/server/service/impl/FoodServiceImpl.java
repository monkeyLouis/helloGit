package zk.springboot.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zk.springboot.server.domain.Food;
import zk.springboot.server.repository.FoodRepository;
import zk.springboot.server.service.FoodService;

@Service("foodSrvc")
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodRepository foodRepository;
	
	@Override
	public Food save(Food food) {
		return foodRepository.save(food);
	}

}
