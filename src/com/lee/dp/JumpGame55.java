package com.lee.dp;

public class JumpGame55 {

	public static void main(String[] args) {
		
//		for(int i=5;i<8;i++){
//			System.out.println(i);
//		}
		JumpGame55 obj = new JumpGame55();
		int[] nums = {2,3,1,1,4};
//		int[] nums = {3,2,1,0,4};
		boolean value = obj.canJump(nums);
		System.out.println(value);

	}
	
    public boolean canJump(int[] nums) {
        if(nums.length==1){
            return true;
        }
    	boolean[] flag = new boolean[nums.length];
    	flag[0]=true;
		for (int i = 0; i < nums.length; i++) {
			if (flag[i] == true) {
				int w = nums[i];
				int k = i + w;
                if(k >= nums.length - 1){
					return true;
				}
                for(int j=i+1;j<=i+w;j++){
				    flag[j] = true;
                }
			}
		}
    	return false;
    }

}
