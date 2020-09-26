package com.lee.againt;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

	public static void main(String[] args) {
		HappyNumber obj = new HappyNumber();
		System.out.println(obj.isHappy(19));

	}
	
	Set<Integer> set = new HashSet<>();
	
    public boolean isHappy(int n) {
		if (n == 1) {
			return true;
		}
		if (set.contains(n)) {
			return false;
		}
		set.add(n);
		int sum = 0;
		while (n > 0) {
			int t = n % 10;
			sum += t * t;
			n = n / 10;
		}
        return isHappy(sum);
    }

}
