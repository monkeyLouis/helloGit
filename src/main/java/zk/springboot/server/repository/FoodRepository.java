package zk.springboot.server.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import zk.springboot.server.domain.Food;


@Transactional
public interface FoodRepository extends CrudRepository<Food, String> {

	List<Food> findAll();
	
	@Query("SELECT f.f_name from Food f")
	List<String> findAllName();
	
}
