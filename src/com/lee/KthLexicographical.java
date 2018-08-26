package com.lee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/discuss/
public class KthLexicographical {
	
	public static void main(String[] args) {
		KthLexicographical k = new KthLexicographical();
		int w = k.findKthNumber(4444, 2555);
		System.out.println("result " + w);

	}
	
	
	public int findKthNumber(int n, int k) {
	    int curr = 1;
	    k = k - 1;
	    while (k > 0) {
	        int steps = calSteps(n, curr, curr + 1);
	        if (steps <= k) {
	            curr += 1;
	            k -= steps;
	        } else {
	            curr *= 10;
	            k -= 1;
	        }
	    }
	    return curr;
	}
	//use long in case of overflow
	public int calSteps(int n, long n1, long n2) {
	    int steps = 0;
	    while (n1 <= n) {
	        steps += Math.min(n + 1, n2) - n1;
	        n1 *= 10;
	        n2 *= 10;
	    }
	    return steps;
	}
	
//	public static void main(String[] args) {
//		KthLexicographical k = new KthLexicographical();
//		int w = k.findKthNumber(25, 20);
//		System.out.println("result " + w);
//
//	}
//	
//	public int findKthNumber(int n, int k) {
//		List<Integer> list = getList(n);
//		
//		System.out.println(list.size() + "items........s      " + list.get(0) + "..." + list.get(1));
//		Long r = getOffset(k, list, 0);
//		return r.intValue();
//	}
//
//	
//	//recurisive
//	public long getOffset(long k, List<Integer> list, long prefix) {
//		if(k==0){
//			return 0;
//		}
//		if(list.size()==1){
//			return k;
//		}
//		int offset = 0;
//		int firstValue = list.get(0);
//		long result = 0;
//		long number = getNumber(list.size());
//		while(true){
//			offset++;
//			
//			if(offset==firstValue) {
//				if(k>=offset*number){
//					prefix = prefix*10;
//					k = k - offset * number;
//					list = list.subList(1, list.size());
//					result = getOffset(k, list, prefix);
//					
//				} else {
//					prefix = prefix*10 + offset;
//					k = k - offset * number;
//					list = list.subList(1, list.size());
//					result = getOffset(k, list, prefix);
//				}
//				break;
//			}
//			if(offset<firstValue){
//				if(k<offset*number){
//					prefix = prefix*10 + offset;
//					list = list.subList(1, list.size());
//					result = getOffset(k, list, prefix);
//					break;
//				}
//				if(k>=offset*number && k<(offset+1)*number){
//					prefix = prefix*10 + offset + 1;
//					k = k - offset * number;
//					list = list.subList(1, list.size());
//					result = getOffset(k, list, prefix);
//				}
//			}
//		}
//			
//		return result;
//	}
//	
//	public long getNumber(int size){
//		long w = 1;
//		for(int i=1;i<size;i++){
//			w = w*10 + w;
//		}
//		return w;
//	}
//	
//	public List<Integer> getList(int n){
//		List<Integer> list = new ArrayList<Integer>();
//        while(n>9){
//            int w = n%10;
//            n=n/10;
//            list.add(w);
//        }
//        list.add(n);
//        Collections.reverse(list);
//        return list;
//	}

}
