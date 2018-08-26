package com.lee.bitwise;

public class SingleNumberIII260 {

	public static void main(String[] args) {
		char k = 'a';
		System.out.println(1 << k - 'a');
		int a = 5;
		System.out.println(Integer.toBinaryString(a));
		
		System.out.println(Integer.toBinaryString(-a));
		a &= -a;
		System.out.println(a);
		
		int[] nums = {1,2,1,7,2,8};
		singleNumber(nums);
	}
	

	    public static int[] singleNumber(int[] nums) {
	        // Pass 1 : 
	        // Get the XOR of the two numbers we need to find
	        int diff = 0;
	        for (int num : nums) {
	            diff ^= num;
	        }
	        
	        System.out.println("..diff is " + Integer.toBinaryString(diff));
	        // Get its last set bit
	        diff &= -diff;
	        System.out.println("..diff is " + diff);
	        
	        // Pass 2 :
	        int[] rets = {0, 0}; // this array stores the two numbers we will return
	        for (int num : nums)
	        {
	            if ((num & diff) == 0) // the bit is not set
	            {
	                rets[0] ^= num;
	            }
	            else // the bit is set
	            {
	                rets[1] ^= num;
	            }
	        }
	        return rets;
	    }

}
