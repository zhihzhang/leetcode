package com.lee.againt;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {

	public static void main(String[] args) {
		MajorityElementII obj = new MajorityElementII();
		int[] nums = new int[]{8,8,7,7,7};
		System.out.println(obj.majorityElement(nums).toString());
	}

	public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
		int count1 = 0;
        int count2 = 0;
        int candidate1 = 0;
        int candidate2 = 0;
        for(int n:nums){
            if(count1==0 && (count2==0 || candidate2!=n)){
                candidate1 = n;
                count1++;
            }else if (count2==0 && (count1==0 || candidate1!=n)){
                candidate2 = n;
                count2++;
            }else if (candidate1==n){
                count1++;
            }else if (candidate2==n){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        int threshold = nums.length/3;
        count1=0;
        count2=0;
        for(int n:nums){
            if(candidate1==n){
                count1++;
            }else if(candidate2==n){
                count2++;
            }
        }
        if(count1>threshold){
            list.add(candidate1);
        }
        if(count2>threshold){
            list.add(candidate2);
        }
        return list;
	}
}
