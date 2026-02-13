package com.pzp.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

public class ThreadPoolTest {

	private ThreadPoolExecutor pool = null;
	static Integer num = 0;
	static Integer rejectNum = 0;
	
	private final static int CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors();
	private final static int MAX_POOL_SIZE = Runtime.getRuntime().availableProcessors();
	private final static int QUEUE_SIZE = 20;
	
	ThreadFactory springThreadFactory = new CustomizableThreadFactory("springthread-pool-");
	
	//ExecutorService executorService = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, 10L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(QUEUE_SIZE), springThreadFactory, null);
	
	/**
	 * 根据IO密集型获取线程池
	 * @return
	 */
	public ThreadPoolExecutor getIOInstance() {
		return getNewInstance(CORE_POOL_SIZE, MAX_POOL_SIZE * 2 + 1, "testThread-pool-", QUEUE_SIZE);
	}
	
	/**
	 * 根据CPU密集型获取线程池
	 * @return
	 */
	public ThreadPoolExecutor getCPUInstance() {
		return getNewInstance(CORE_POOL_SIZE, MAX_POOL_SIZE + 1, "testThread-pool-", QUEUE_SIZE);
	}
	
	/**
	 * 获取线程池实例
	 * @return
	 */
	public ThreadPoolExecutor getNewInstance(int corePoolSize, int maxPoolSize, String poolName,
			int queueSzie) {
		pool = createExecutor(corePoolSize, maxPoolSize, poolName, queueSzie);
		if (pool == null) {
			throw new NullPointerException();
		} else {
			return pool;
		}
	}
	
	public ThreadPoolExecutor createExecutor(int corePoolSize, int maxPoolSize, String poolName,
			int queueSzie) {
		return new ThreadPoolExecutor(corePoolSize, maxPoolSize, 10L, TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(queueSzie), 
				new CustomThreadFactory(poolName),
				new RejectExecutionHandlerImpl());
	}
	
	/**
	 * 线程池工厂
	 * @author panzhanpeng
	 *
	 */
	class CustomThreadFactory implements ThreadFactory {

		private String threadPoolName;
		
		public CustomThreadFactory(String threadPoolName) {
			this.threadPoolName = threadPoolName;
		}
		
		private AtomicInteger count = new AtomicInteger(0);
		
		@Override
		public Thread newThread(Runnable r) {
			Thread t = new Thread(r);
			String nowThreadName = "";
			nowThreadName = threadPoolName + count.addAndGet(1);
			t.setName(nowThreadName);
			return t;
		}
		
	}
	
	/**
	 * 自定义拒绝策略
	 * @author panzhanpeng
	 *
	 */
	class RejectExecutionHandlerImpl implements RejectedExecutionHandler {

		@Override
		public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
			//记录日志，不做处理
			System.out.println("超过线程池队列长度，丢弃任务" + (rejectNum++));
		}
		
	}
	
	public static void main(String[] args) {
		ThreadPoolExecutor executor = new ThreadPoolTest().getNewInstance(3, 8, "test", 5);
		for (int i = 0; i < 20; i++) {
			System.out.println("提交第" + i + "个任务");
			executor.submit(()->{
				try {
					System.out.println(Thread.currentThread().getName());
					Thread.sleep(5000);
					synchronized (num) {
						System.out.println("数字为：" + num++);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
			System.out.println("提交第" + i + "个任务成功");
		}
		System.out.println("结束");
	}
	
}
