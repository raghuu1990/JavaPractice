package com.javaconcepts;

public class HashCode {
	
	private final String str1;
	private final String str2;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((str1 == null) ? 0 : str1.hashCode());
		result = prime * result + ((str2 == null) ? 0 : str2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HashCode other = (HashCode) obj;
		if (str1 == null) {
			if (other.str1 != null)
				return false;
		} else if (!str1.equals(other.str1))
			return false;
		if (str2 == null) {
			if (other.str2 != null)
				return false;
		} else if (!str2.equals(other.str2))
			return false;
		return true;
	}

    public HashCode(String str1, String str2) {
		super();
		this.str1 = str1;
		this.str2 = str2;
	}

	
	public static void main(String[] args) {
		//int originalHashCode = System.identityHashCode(emp1);
		
		String s = "s";
		System.out.println("s".equals(s));
		s="t";
		System.out.println("s".equals(s));
		s="ss";
		System.out.println("ss".equals(s));
		
		String obj1 = new String("xyz");
		//String obj2 = new String("xyz");
		String obj2 = obj1;
		
		//obj1="xyz";
		//obj2="xyz"; 
		
		if(obj1 == obj2)
		   System.out.println("obj1==obj2 is TRUE");
		else
		  System.out.println("obj1==obj2 is FALSE");
	}
}
