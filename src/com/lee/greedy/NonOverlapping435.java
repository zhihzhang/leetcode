package com.lee.greedy;

public class NonOverlapping435 {

	public static void main(String[] args) {
		String x = "10.20.116";
		StringBuilder sb = new StringBuilder();
		sb.append("NetworkAddress[@resourceId in (\"10.20.116.104\"");
		for(int i = 105;i<255;i++){
			String k = ",\""+x + "." + i+"\"";
			sb.append(k);
			System.out.println(k);
		}
		sb.append(")]");
		System.out.println(sb.toString());

	}

}
