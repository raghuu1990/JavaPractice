package com.company.swiggy.deliverymanagment.substrategy;

// Factory to get instance of SubStrategy
public class SubStrategyFactory {
	public static ISubStrategy getStrategy(SubStrategy subStrategy) {
		if (SubStrategy.FIRST_MILE == subStrategy) {
			return new FirstMile();
		} else if (SubStrategy.ORDER_DELAY == subStrategy) {
			return new OrderDelay();
		} else if (SubStrategy.WAITING_TIME == subStrategy) {
			return new WaitingTime();
		}
		return null;
	}
}