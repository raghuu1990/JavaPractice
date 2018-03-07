package com.design.vendingmachine;

public enum Item {
	COKE(1, "Coke", 5), PEPSI(2, "Pepsi", 6), SODA(3, "Soda", 7);

	Integer id;
	private String name;
	private int price;

	private Item(Integer id, String name, int price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public long getPrice() {
		return price;
	}

	public static Item getItemById(Integer itemId) {
		for(Item item : Item.values()) {
			if(item.id==itemId) {
				return item;
			}
		}
		return null;
	}
}