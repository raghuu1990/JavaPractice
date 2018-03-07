package com.design.vendingmachine;

public class VendingMachineFactory {
	public static IVendingMachine createVendingMachine() {
		return new VendingMachineImpl();
	}
}