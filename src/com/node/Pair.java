package com.node;

public class Pair<K, V> {
	K key;
	V value;

	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public K getKey() {
		return key;
	}

	public K getFirst() {
		return key;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public V getValue() {
		return value;
	}

	public V getSecond() {
		return value;
	}

	@Override
	public boolean equals(Object obj) {
		if (this.key == ((Pair<K, V>) obj).key && this.value == ((Pair<K, V>) obj).value) {
			return true;
		}
		return false;
	}
}