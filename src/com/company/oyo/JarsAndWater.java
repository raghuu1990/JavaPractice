package com.company.oyo;

public class JarsAndWater {
	private static Boolean[][] result;
	private static Boolean[][] visited;

	public static void main(String[] args) {
		// int x = 3; int y = 5; int z = 4;     // true
		// int x = 2; int y = 6; int z = 5;		// false
		int x = 3; int y = 5; int z = 9;
		result = new Boolean[x + 1][y + 1];
		visited = new Boolean[x + 1][y + 1];
		if (isPossible(x, y, 0, 0, z)) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
		
		for (int i = 1; i <= 20; i++) {
			for (int j = 1; j <= 20; j++) {
				for (int k = 1; k <= 40; k++) {
					if (i != j && i + j >= k) {
						result = new Boolean[i + 1][j + 1];
						visited = new Boolean[i + 1][j + 1];
						if (isPossible1(i, j, k) != isPossible(i, j, 0, 0, k)) {
							result = new Boolean[i + 1][j + 1];
							visited = new Boolean[i + 1][j + 1];
							System.out.print(isPossible(i, j, 0, 0, k));
							System.out.print(" ");
							System.out.print(isPossible1(i, j, k));
							System.out.println(" " + i + " " + j + " " + k);
						}
					}
				}
			}
		}
	}

	private static int gcd(int a, int b){
	    while (a != b){
	        if (a > b) a -= b;
	        else b -= a;
	    }
	    return a;
	}

	private static boolean isPossible1(int x, int y, int z) {
		if(x==z||y==z||x+y==z) {
			return true;
		}
		int gcd = gcd(x, y);
		if(gcd != 1 && z%gcd!=0) {
			return false;
		}
		if((x+y)>=z) {
			if(x%2==0 && y%2==0 && z%2!=0) {
				return false;
			}else if ((x%y == 0 || y%x ==0) && (z%x==0 || z%y==0)) {
				return true;
			}else if (x%y == 0 || y%x ==0) {
				return false;
			}else {
				return true;
			}
		}
		return false;
	}

	private static boolean isPossible(int x, int y, int a, int b, int z) {
		if (visited[a][b] == null) {
			visited[a][b] = false;
		} else {
			return visited[a][b];
		}

		if (x == z || y == z || a == z || b == z || z == 0 || (a+b)==z) {
			result[a][b] = true;
			return true;
		}
		if (result[a][b] == null) {
			// case 1
			if (isPossible(x, y, a, y, z)) {
				result[a][b] = true;
				return true;
			}

			// case 2
			if (isPossible(x, y, x, b, z)) {
				result[a][b] = true;
				return true;
			}

			// case 3
			if (isPossible(x, y, x, y, z)) {
				result[a][b] = true;
				return true;
			}

			// case 4
			if (isPossible(x, y, a, 0, z)) {
				result[a][b] = true;
				return true;
			}

			// case 5
			if (isPossible(x, y, 0, b, z)) {
				result[a][b] = true;
				return true;
			}

			// case 6 (a-->b)
			if (y - b >= a) {
				b = b + a;
				a = 0;
			} else {
				int c = y - b;
				a = a - c;
				b = y;
			}
			if (isPossible(x, y, a, b, z)) {
				result[a][b] = true;
				return true;
			}

			// case 7 (b-->a)
			if (x - a >= b) {
				a = a + b;
				b = 0;
			} else {
				int c = x - a;
				b = b - c;
				a = x;
			}
			if (isPossible(x, y, a, b, z)) {
				result[a][b] = true;
				return true;
			}

			result[a][b] = false;
		}
		return result[a][b];
	}
}