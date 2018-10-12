package com.lee.backtrace;

import java.util.ArrayList;
import java.util.List;

public class GreyCode86 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    private static List<Integer> mem = new ArrayList<Integer>();
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<Integer>();
        int target = (int) Math.pow(2, n);
        list.add(0);
        boolean flag = getData(0, target, n, list);
        return list;
        //System.out.println(list.toString());
        //for (int i : list) {
            //System.out.println("bit - " + Integer.toBinaryString(i));
        //}
    }
    
    public static boolean getData(int data, int target, int l, List<Integer> list) {
        if (list.size() == target) {
            return true;
        }
        for (int i = 0; i < l; i++) {
            int k = data ^ (1 << i); // 将某一位取反
            if (list.contains(k)) {
                continue;
            }
            list.add(k);
            boolean flag = getData(k, target, l, list);
            if (flag) {
                return true;
            }
            list.remove(k);
        }
        return false;
    }

}
