package com.design.vendingmachine;

import java.util.List;

public interface IVendingMachine {
	long selectItemAndGetPrice(Integer itemId);
	public void insertCoin(Coin coin);
	public List<Coin> refund();
	public Bucket<Item, List<Coin>> collectItemAndChange();
	public void reset();
}