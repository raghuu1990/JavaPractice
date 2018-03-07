package com.company.housing;

public class Playlists {
	private static int factorial(int n){
		int fact = 1;
		for (int c=1; c<=n; c++){
			fact = fact*c;
		}
		return fact;
	}
	
	private static int ncr(int i, int j) {
		return factorial(i)/(factorial(j)*factorial(i-j));
	}
	
	private static boolean canRepeatSong(int noOfSongs, int threshHold, int wantToListen) {
		if(wantToListen-1 > threshHold && noOfSongs-1 >= threshHold){
			return true;
		}
		return false;
	}
	
	private static boolean isRepeatRequired(int noOfSongs, int wantToListen){
		if(wantToListen > noOfSongs){
			return true;
		}
		return false;
	}
	
	private static int multiplyXtimes(int number, int time){
		int result = 1;
		while(time>0){
			result *= number;
			--time;
		}
		return result;
	}
	
	private static int noOfPlaylists(int noOfSongs, int threshHold, int wantToListen) {
		int permutations = 0;
		if(noOfSongs == 0  || wantToListen == 0)
			return permutations;
		if(isRepeatRequired(noOfSongs, wantToListen) && !canRepeatSong(noOfSongs, threshHold, wantToListen)){
			return permutations;
    	}
		
		if(!isRepeatRequired(noOfSongs, wantToListen) && !canRepeatSong(noOfSongs, threshHold, wantToListen)){
			return factorial(noOfSongs)/factorial(noOfSongs-wantToListen);
    	}
		
		if(canRepeatSong(noOfSongs, threshHold, wantToListen)){
			int repeatRequired = wantToListen - (noOfSongs-(threshHold+1));
			permutations = factorial(noOfSongs)/factorial(threshHold+1);
			permutations *= multiplyXtimes(noOfSongs, repeatRequired);
			return permutations;
    	}
		
		return permutations/1000000007;
    }
	
	public static void main(String args[]){
 		System.out.println(noOfPlaylists(1,0,3));
		System.out.println(noOfPlaylists(1,1,3));
		System.out.println(noOfPlaylists(4,6,0));
		System.out.println(noOfPlaylists(0,6,1));
		System.out.println(noOfPlaylists(4,4,4));
		System.out.println(noOfPlaylists(4,2,4));
		System.out.println(noOfPlaylists(10,12,3));
		System.out.println(noOfPlaylists(2,1,2));
		System.out.println(noOfPlaylists(7,3,10));
	}
}
