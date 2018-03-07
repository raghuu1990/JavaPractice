package com.company.ola;

public class RetryConfiguration {

	// method to get retry count for each response type : can use some other data type, or can have configurable
	public static int getRetryCount(int resCode) {
		if(resCode ==301){
			return 1;
		}else if (resCode == 302){
			return 2;
		}else if (resCode == 400){
			return 3;
		}else if (resCode == 401){
			return 4;
		}else if (resCode == 422){
			return 5;
		}else if (resCode == 404){
			return 6;
		}else if (resCode == 404){
			return 7;
		}else if (resCode == 500){
			return 8;
		}else if (resCode == 502){
			return 9;
		}else if (resCode == 503){
			return 10;
		}
		return 0;
	}
}
