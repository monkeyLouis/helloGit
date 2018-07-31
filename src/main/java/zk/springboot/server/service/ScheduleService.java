package zk.springboot.server.service;

import java.util.Date;
import java.util.List;

import zk.springboot.server.domain.Schedule;

public interface ScheduleService {
	List<Schedule> findAll();
	List<Schedule> findByDate(Date date);
}
