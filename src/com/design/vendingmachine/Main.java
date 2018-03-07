package com.design.vendingmachine;

public class Main {

	public static void main(String[] args) {
		IVendingMachine vendingMachine = VendingMachineFactory.createVendingMachine();
		vendingMachine.selectItemAndGetPrice(1);
		vendingMachine.insertCoin(Coin.ONE);
		vendingMachine.insertCoin(Coin.TWO);
		vendingMachine.insertCoin(Coin.FIVE);
		vendingMachine.collectItemAndChange().toString();
		vendingMachine.refund();
		
		vendingMachine.reset();
	}
}
