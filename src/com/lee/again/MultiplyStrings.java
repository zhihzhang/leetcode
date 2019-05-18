package com.lee.again;

import java.util.ArrayList;
import java.util.List;

public class MultiplyStrings {

	public static void main(String[] args) {
		MultiplyStrings obj = new MultiplyStrings();
//		System.out.println(obj.multiply("123456789", "987654321"));
		List<Integer> nums1 = new ArrayList<>();
		nums1.add(9);
		nums1.add(8);
		nums1.add(1);
		nums1.add(1);
		nums1.add(1);
		List<Integer> nums2 = new ArrayList<>();
		nums2.add(9);
		nums2.add(9);
		nums2.add(9);
		nums2.add(9);
		nums2.add(2);
		obj.add(nums1,nums2);
		System.out.println(nums1.toString());
	}

	// "234" num1
	// "567" num2
	public String multiply(String num1, String num2) {
		List<Integer> sum = new ArrayList<>();
		for (int i = 0; i < num1.length(); i++) {
			List<Integer> number = new ArrayList<>();
			for (int j = 0; j < num2.length(); j++) {
				int a = num1.charAt(i) - '0';
				int b = num2.charAt(j) - '0';
				int t = a * b;
				List<Integer> temp = new ArrayList<>();
				if (t < 10) {
					temp.add(t);
				} else {
					int y = t % 10;
					int x = t / 10;
					temp.add(x);
					temp.add(y);
				}
				System.out.println("   T....." + number.toString() + "..." + temp.toString());
				add(number, temp);
				System.out.println("   B....." + number.toString());
			}
			System.out.println("A....." + sum.toString() + "..." + number.toString());
			add(sum, number);
			System.out.println("B....." + sum.toString());
		}
		if(sum.size()==0){
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		for (int n : sum) {
			if(sb.length()>0 || n!=0){
				sb.append(n);
			}
		}
        if(sb.length()==0){
            return "0";
        }
		return sb.toString();
	}

	public void add(List<Integer> a, List<Integer> b) {
		if (a.isEmpty()) {
			a.addAll(b);
			return;
		}
		a.add(0);
		int taila = a.size() - 1;
		int tailb = b.size() - 1;
		int t = 0;
		while (taila >= 0) {
			int i = a.get(taila);
			int j = 0;
			if (tailb >= 0) {
				j = b.get(tailb);
			}
			int num = i + j + t;
			if (num < 10) {
				a.set(taila, num);
				t = 0;
			} else {
				num = num % 10;
				a.set(taila, num);
				t = 1;
			}
			taila--;
			tailb--;
			if (tailb < 0 && t == 0) {
				break;
			}
		}
		if(t==1){
			a.add(0, 1);
		}
	}

}
