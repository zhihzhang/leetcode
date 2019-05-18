package com.lee.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionLabels763 {

	public static void main(String[] args) {
		PartitionLabels763 obj = new PartitionLabels763();
		List<Integer> list = obj.partitionLabels("ababcbacadefegdehijhklij");
		System.out.println(list.toString());
	}
	
	public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); i++){
            last[S.charAt(i) - 'a'] = i;
        }
        System.out.println(Arrays.toString(last));
        
        int j = 0;
        int anchor = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
        	if(S.charAt(i)=='b'){
        		System.out.println(i);
        	}
            j = Math.max(j, last[S.charAt(i) - 'a']);  // j is the last number of the all chars in currenct patition
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }

}
