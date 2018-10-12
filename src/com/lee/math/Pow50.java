package com.lee.math;

import java.util.HashMap;
import java.util.Map;

public class Pow50 {

	public static void main(String[] args) {
		Pow50 obj = new Pow50();
		double t = obj.myPow(2, 3);
		System.out.println(t);
	}

	Map<Long, Double> map = new HashMap<Long, Double>();
	public double myPow(double x, int n) {
		return myPowLong(x, new Long(n));
	}

	public double myPowLong(double x, long n) {
		if (x == 0) {
			return 0;
		}
		if (x == 1) {
			return 1;
		}
		if (x == -1) {
			long w = Math.abs(n);
			if (w % 2 == 0) {
				return 1;
			} else {
				return -1;
			}
		}
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return x;
		}



		if (map.containsKey(n)) {
			return map.get(n);
		}

		if (n > 0) {
			double temp = x;
			if (n % 2 == 0) {
				temp = myPowLong(x, n / 2) * myPowLong(x, n / 2);
			} else {
				temp = myPowLong(x, n / 2) * myPowLong(x, n / 2) * x;
			}
			map.put(n, temp);
			return temp;
		} else {
			double temp = x;
			long w = -n;
			temp = myPowLong(x, w);
			return 1 / temp;
		}
	}

}
