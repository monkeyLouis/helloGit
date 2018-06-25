package zk.springboot.server.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import zk.springboot.server.domain.Shop;

@Transactional
public interface ShopRepository extends CrudRepository<Shop, String> {

	List<Shop> findAll();
	
}
