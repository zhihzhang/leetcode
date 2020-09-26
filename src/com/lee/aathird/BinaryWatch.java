package com.lee.aathird;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> readBinaryWatch(int num) {
		List<String> times = new ArrayList<>();
		for (int h = 0; h < 12; h++) {
			for (int m = 0; m < 60; m++) {
				if (Integer.bitCount(h) + Integer.bitCount(m) == num) {
					if (m < 10) {
						times.add(h + ":0" + m);
					} else {
						times.add(h + ":" + m);
					}
				}
			}
		}
		return times;
	}

}
