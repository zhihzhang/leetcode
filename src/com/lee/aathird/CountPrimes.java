package com.lee.aathird;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountPrimes {

	public static void main(String[] args) {
		CountPrimes obj = new CountPrimes();
		System.out.println(obj.countPrimes(10));

	}

	public int countPrimes(int n) {
		if (n <= 1){
			return 0;
		}

		boolean[] prime = new boolean[n];
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;

		int count = 0;
		for (int i = 2; i < Math.sqrt(n); i++) {
			if (prime[i]) {
				for (int j = 2; j * i < n; j++) {
					prime[i * j] = false;
				}
				count++;
			}
		}
		
		return count;
	}

}
