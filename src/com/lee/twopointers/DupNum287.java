package com.lee.twopointers;

public class DupNum287 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int r = findDuplicate(new int[]{1,1,3});
		System.out.println(r);
	}
	
    public static int findDuplicate(int[] nums) {
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        return ptr1;
    }

}
