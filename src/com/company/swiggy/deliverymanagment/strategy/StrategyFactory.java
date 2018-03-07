package com.company.swiggy.deliverymanagment.strategy;

// Factory to get instance of Strategy

public class StrategyFactory {
	public static IStrategy getStrategy(Strategy strategy) {
		if(Strategy.EFFICIENCY==strategy) {
			return new Efficiency();
		}else if(Strategy.QUALITY==strategy){
			return new Quality();
		}
		return null;
	}
}
