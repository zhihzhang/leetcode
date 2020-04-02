package com.lee.againt;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AssignCookies {

	public static void main(String[] args) {
		AssignCookies obj = new AssignCookies();
		int[] g = new int[]{1,2,3};
		int[] s = new int[]{1,2,2,3};
		int count = obj.findContentChildren(g, s);
		System.out.println(count);
	}

	public int findContentChildren(int[] g, int[] s) {
		if(s==null || s.length==0){
			return 0;
		}
		if(g==null || g.length==0){
			return 0;
		}
		Arrays.sort(g);
		Arrays.sort(s);
		int count = 0;
		int i = 0;
		for(int cookie:s){
			if (i < g.length) {
				if (cookie >= g[i]) {
					count++;
					i++;
				}
			} else {
				break;
			}
		}
		return count;
	}

}
