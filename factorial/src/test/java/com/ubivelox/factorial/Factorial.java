package com.ubivelox.factorial;

import java.math.BigInteger;

import com.ubivelox.exception.UbiveloxException;

public class Factorial {
	
	public static int getZeroCount(int numOrg) throws UbiveloxException{
		
		return getZeroCount0(numOrg);
	}

	//5를 몇 개 곱하느냐에 따라 0의 갯수도 늘어남. 따라서 5배수만 for문에서는 값을 5로 계속 쪼갰을 때의 5 갯수를 count
	public static int getZeroCount0(int numOrg) throws UbiveloxException{
		int count = 0;
		int num = numOrg;
		
		if(numOrg < 0) {
			throw new UbiveloxException("에러 : 음수");
		}
		
		//i가 5의 배수일 때만 검색
		for(int i = 5; i <= numOrg; i+=5) {
			num = i;
			
			//5의 배수 i를  5로 계속 쪼갰을 때의 5 갯수를 count한다.
			do {
				count += 1;
				num /= 5;
			}while(num%5 == 0);
		}
		
		return count;
	}
	  
	//곱하고 10으로 나눴을 때 나머지가 0이라면 곱한 결과 값이 10배수니까 count올리고 /10을 하여 다시 0이 없는 값으로 변경시킨다.
	public static int getZeroCount1(int numOrg) throws UbiveloxException{
		int count = 0;
		double result = 1;
		
		if(numOrg < 0) {
			throw new UbiveloxException("에러 : 음수");
		}
		
		for(int i = 1; i <= numOrg; i++) {
			result *= i;
			while(result%10 == 0) {
				count++;
				result /= 10;
			}
		}
		
		return count;
	}

	//BigInteger를 이용하여 getZeroCount1를 보완
	public static int getZeroCount2(int numOrg) throws UbiveloxException{
		
		BigInteger result = BigInteger.valueOf(1);	
		BigInteger ten = BigInteger.valueOf(10);
		BigInteger zero = BigInteger.valueOf(0);

	
		int count = 0;

		if(numOrg < 0) {
			throw new UbiveloxException("에러 : 음수");
		}
 
        for (int i = 1; i <= numOrg; i++) {
        	result = result.multiply(BigInteger.valueOf(i));

            while(result.mod(ten).equals(zero)){
            	count++;
            	result = result.divide(ten);
            }
        }

		return count;
    }
}
