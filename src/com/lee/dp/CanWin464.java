package com.lee.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CanWin464 {

	public static void main(String[] args) {
		CanWin464 obj = new CanWin464();
		boolean f = obj.canIWin(10, 40);
		System.out.println(f);

	}

	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
		if (sum < desiredTotal){
			return false;
		}
		if (desiredTotal <= 0){
			return true;
		}

		Map<String, Boolean> map = new HashMap<String, Boolean>();
		boolean[] used = new boolean[maxChoosableInteger + 1];
		return chess(desiredTotal, map, used);
	}

	public boolean chess(int desiredTotal, Map<String, Boolean> map, boolean[] used) {
		if (desiredTotal <= 0){
			return false;
		}
		String key = Arrays.toString(used);
		if (!map.containsKey(key)) {
			// try every unchosen number as next step
			for (int i = 1; i < used.length; i++) {
				if (!used[i]) {
					used[i] = true;
					// check whether there is one way which leads to a win (i.e. the other player
					// lose)
					if (!chess(desiredTotal - i, map, used)) {
						map.put(key, true);
						used[i] = false;
						return true;
					}
					used[i] = false;
				}
			}
			map.put(key, false);
		}
		return map.get(key);
	}

	// transfer boolean[] to an Integer
//	public int format(boolean[] used) {
//		int num = 0;
//		for (boolean b : used) {
//			num <<= 1;
//			if (b)
//				num |= 1;
//		}
//		return num;
//	}
}
