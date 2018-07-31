package zk.springboot.server.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import zk.springboot.server.domain.OrderMaster;
import zk.springboot.server.domain.Schedule;

@Transactional
public interface ScheduleRepository extends CrudRepository<Schedule, String>, JpaSpecificationExecutor<Schedule> {
	public List<Schedule> findAllByOrderByEndDateDesc();
}
