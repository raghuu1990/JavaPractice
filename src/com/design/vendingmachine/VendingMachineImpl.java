package com.design.vendingmachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VendingMachineImpl implements IVendingMachine {
	private Inventory<Coin> cashInventory = new Inventory<Coin>();
	private Inventory<Item> itemInventory = new Inventory<Item>();
	private long totalSales;
	private Item currentItem;
	private long currentBalance;

	public VendingMachineImpl() {
		initialize();
	}

	private void initialize() {
		// Initialize machine with 5 coins of each value and 5 cans of each Item
		for (Coin c : Coin.values()) {
			cashInventory.put(c, 5);
		}

		for (Item i : Item.values()) {
			itemInventory.put(i, 5);
		}
	}

	@Override
	public long selectItemAndGetPrice(Integer itemId) {
		Item item = Item.getItemById(itemId);
		if (itemInventory.hasItem(item)) {
			currentItem = item;
			return currentItem.getPrice();
		}
		throw new SoldOutException("Sold Out, Please buy another item");
	}

	@Override
	public void insertCoin(Coin coin) {
		currentBalance = currentBalance + coin.getValue();
		cashInventory.add(coin);
	}

	@Override
	public Bucket<Item, List<Coin>> collectItemAndChange() {
		Item item = collectItem();
		totalSales += currentItem.getPrice();

		List<Coin> change = collectChange();
		return new Bucket<Item, List<Coin>>(item, change);
	}

	private Item collectItem() throws NotSufficientChangeException, NotFullPaidException {
		if (isFullPaid()) {
			if (hasSufficientChange()) {
				itemInventory.deduct(currentItem);
				return currentItem;
			}
			// List<Coin> coins= refund();
			throw new NotSufficientChangeException("Not Sufficient change in Inventory, collect your refund : ");
		}
		long remainingBalance = currentItem.getPrice() - currentBalance;
		throw new NotFullPaidException("Price not full paid, remaining : ", remainingBalance);
	}

	private List<Coin> collectChange() {
		long changeAmount = currentBalance - currentItem.getPrice();
		List<Coin> change = getChange(changeAmount);
		deductCashInventory(change);
		currentBalance = 0;
		currentItem = null;
		return change;
	}

	@Override
	public List<Coin> refund() {
		List<Coin> refund = getChange(currentBalance);
		deductCashInventory(refund);
		currentBalance = 0;
		currentItem = null;
		return refund;
	}

	private boolean isFullPaid() {
		if (currentBalance >= currentItem.getPrice()) {
			return true;
		}
		return false;
	}

	private List<Coin> getChange(long amount) throws NotSufficientChangeException {
		List<Coin> changes = Collections.emptyList();
		if (amount > 0) {
			changes = new ArrayList<Coin>();
			long balance = amount;
			while (balance > 0) {
				boolean flag = false;
				for (Coin coin : Coin.values()) {
					if(balance>= coin.getValue() && cashInventory.hasItem(coin)) {
						changes.add(coin);
						balance = balance - coin.getValue();
						flag = true;
						break;
					}
				}
				if(!flag) {
					throw new NotSufficientChangeException("NotSufficientChange, Please try another product");
				}
			}
		}
		return changes;
	}

	private boolean hasSufficientChange() {
		return hasSufficientChangeForAmount(currentBalance - currentItem.getPrice());
	}

	private boolean hasSufficientChangeForAmount(long amount) {
		boolean hasChange = true;
		try {
			getChange(amount);
		} catch (NotSufficientChangeException nsce) {
			return hasChange = false;
		}
		return hasChange;
	}

	private void deductCashInventory(List<Coin> change) {
		for (Coin c : change) {
			cashInventory.deduct(c);
		}
	}

	public long getTotalSales() {
		return totalSales;
	}
	
	public void printStats() {
		System.out.println("Total Sales : " + totalSales);
		System.out.println("Current Item Inventory : " + itemInventory);
		System.out.println("Current Cash Inventory : " + cashInventory);
	}
	
	@Override
	public void reset() {
		totalSales = 0;
		currentBalance = 0;
		currentItem = null;
		cashInventory.clear();
		itemInventory.clear();
	}
}