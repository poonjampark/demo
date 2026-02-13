//package com.pzp.mq.rocketmq;
//
//import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
//import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
//import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
//
//import com.pzp.util.UserEnum;
//
//import util.panzhanpeng.exception.BussinessException;
//
//@RocketMQTransactionListener
//public class TransactionService implements RocketMQLocalTransactionListener{
//
//	public void commit(String flag) {
//		if ("0".equals(flag)) {
//			throw new BussinessException(new RuntimeException(), UserEnum.USER_TEH_LIST_EXCEPTION);
//		}
//	}
//
//	@Override
//	public RocketMQLocalTransactionState executeLocalTransaction(org.springframework.messaging.Message msg,
//			Object arg) {
//		try {
//			String flag = (String) arg;
//			commit(flag);
//			return RocketMQLocalTransactionState.COMMIT;
//		} catch (BussinessException e) {
//			return RocketMQLocalTransactionState.ROLLBACK;
//		}
//	}
//
//	@Override
//	public RocketMQLocalTransactionState checkLocalTransaction(org.springframework.messaging.Message msg) {
//		System.out.println("再次检查事务状态");
//		return RocketMQLocalTransactionState.COMMIT;
//	}
//
////	@Override
////	public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
////		try {
////			byte[] flag = msg.getBody();
////			commit(flag.toString());
////			return LocalTransactionState.COMMIT_MESSAGE;
////		} catch (Exception e) {
////			return LocalTransactionState.ROLLBACK_MESSAGE;
////		}
////	}
////
////	@Override
////	public LocalTransactionState checkLocalTransaction(MessageExt msg) {
////		return LocalTransactionState.COMMIT_MESSAGE;
////	}
//	
//	
//	
//}
