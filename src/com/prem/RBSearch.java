package com.prem;

public class RBSearch {

	//static int[] nums ={1,2,3,4,5,6,7,8,9,10};
	static int[] rnums ={5,6,7,8,9,10,1,2,3,4};
	
	
	public static void main(String[] args) {
//		System.out.println(RBSearch.bSearch(nums, 0, nums.length, 1));
		for(int i=1;i<15;i++)
		System.out.println(RBSearch.bRSearch(rnums, 0,rnums.length-1,i));
	}
	
	
	public static int bRSearch(int rnums[],int low, int high, int val){
	
		int mid=(low+high)/2;
		
		if(val==rnums[mid])return mid;
		if(mid==low){
			
			if(val==rnums[low])return low;
			if(rnums[high]==val)return high;
			return -1;
		}
		
		if(rnums[low]<rnums[mid]){
			if(val>=rnums[low] && val<rnums[mid]){
				high=mid-1;
				return bRSearch(rnums,low,high,val);
			}
			else{
				low=mid+1;
				return bRSearch(rnums,low,high,val);
			}
		}
		else{
			if(val>rnums[mid] && val<=rnums[high]){
				low=mid+1;
				return bRSearch(rnums,low,high,val);
			}
			else{
				high=mid-1;
				return bRSearch(rnums,low,high,val);
			}
		}
	}
	// 11,12,5,6,7,8,9,10
	public static int rotatedSortedArraySearch(int num[],int low, int high, int val){
		if(num[low]<num[high]){
			int mid=(low+high)/2;
			if(num[mid]==val)return mid;
			if(num[mid]<num[mid+1] && num[mid]<num[mid-1]){
				rotatedSortedArraySearch(num,low,mid-1,val);
				rotatedSortedArraySearch(num,mid+1,high,val);
			}
		}

		if(low<=high){
			int mid=(low+high)/2;
			if(num[mid]==val)return mid;
			if(num[mid]<num[mid+1] && num[mid]<num[mid-1]){
				rotatedSortedArraySearch(num,low,mid-1,val);
				rotatedSortedArraySearch(num,mid+1,high,val);
			}

		}



return 0;
	}


	public static int bSearch(int nums[],int low, int high,int val){
		int mid= (low+high)/2;
		if(val==nums[mid]){
			return mid;
		}
		else if(val<nums[mid] && val> nums[low]){
			high=mid-1;
			return bSearch(nums,low,high,val);
		}
		else{
			low = mid+1;
			return bSearch(nums,low,high,val);
		}
	}	
}
