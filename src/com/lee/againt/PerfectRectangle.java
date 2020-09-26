package com.lee.againt;

import java.util.HashSet;
import java.util.Set;

public class PerfectRectangle {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		PerfectRectangle obj = new PerfectRectangle();
		int[][] r = new int[][]{
			{0,0,2,2},{1,1,3,3},{2,0,3,1},{0,3,3,4}
			// 00 04 30 34
//			{0,0,4,1},{7,0,8,2},{6,2,8,3},{5,1,6,3},{4,0,5,1},{6,0,7,2},{4,2,5,3},{2,1,4,3},{0,1,2,2},{0,2,2,3},{4,1,5,2},{5,0,6,1}
			//4         1           2        1          1
		};
		System.out.println(obj.isRectangleCover(r));
	}
	//[[0,0,4,1],[7,0,8,2],[6,2,8,3],[5,1,6,3],[4,0,5,1],[6,0,7,2],[4,2,5,3],[2,1,4,3],[0,1,2,2],[0,2,2,3],[4,1,5,2],[5,0,6,1]]
	
	//calculate sum of area
	//check if it's a perfect square
	// find four points
	//[[0,0,2,2],[1,1,3,3],[2,0,3,1],[0,3,3,4]]
	public boolean isRectangleCover(int[][] rectangles) {
		int xl = Integer.MAX_VALUE;
		int yb = Integer.MAX_VALUE;
		int xr = -1;
		int yt = -1;
		Set<String> points = new HashSet<>();

		int sum = 0;
		for (int[] r : rectangles) {
			// 1 calc
			int area = (r[3] - r[1]) * (r[2] - r[0]);
			String[] sa = new String[4];
			sa[0]=r[0] + ":" + r[1];
			sa[1]=r[0] + ":" + r[3];
			sa[2]=r[2] + ":" + r[1];
			sa[3]=r[2] + ":" + r[3];
			
			for(int i=0;i<4;i++){
				if(points.contains(sa[i])){
					points.remove(sa[i]);
				}else{
					points.add(sa[i]);
				}
			}
			sum += area;

			// 2 replace
			xl = Math.min(xl, r[0]);
			yb = Math.min(yb, r[1]);
			xr = Math.max(xr, r[2]);
			yt = Math.max(yt, r[3]);
		}
		if(!points.contains(xl + ":" + yb) || !points.contains(xr + ":" + yt) 
				|| !points.contains(xl + ":" + yt) || !points.contains(xr + ":" + yb) || points.size()!=4){
			return false;
		}
		int s = (yt - yb) * (xr - xl);
		

		return s == sum;
	}

}
