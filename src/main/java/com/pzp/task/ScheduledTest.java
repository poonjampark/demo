package com.pzp.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledTest.class);
	
	int Count = 1;
	
	@Scheduled(cron="0/5 * * * * ?")
	public void deleteUser() {
		System.out.println(Thread.currentThread().getName() + "--" + Count);
		LOGGER.debug(Thread.currentThread().getName() + "--" + Count);
		Count++;
	}
	
}
