package com.lee.binarysearch;

public class SearchInsertPosition35 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//记住用法
	public static int searchInsert(int[] A, int target) {
        int low = 0, high = A.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(A[mid] == target) return mid;
            else if(A[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return low;
    }

}
