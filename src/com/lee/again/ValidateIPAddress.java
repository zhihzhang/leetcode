package com.lee.again;

public class ValidateIPAddress {

	public static void main(String[] args) {
		System.out.println('A' + 0);
		System.out.println('F' + 0);
		System.out.println('a' + 0);
		System.out.println('f' + 0);
		System.out.println('0' + 0);
		System.out.println('9' + 0);

		ValidateIPAddress obj = new ValidateIPAddress();
		System.out.println(obj.validIPAddress("172.16.254.1"));
		System.out.println(obj.validIPAddress("256.256.256.256"));
		System.out.println(obj.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
		System.out.println(obj.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:99"));
	}

	private static String NON = "Neither";

	public String validIPAddress(String IP) {

		if(IP.startsWith(".") || IP.endsWith(".")){
			return NON;
		}
		if (IP.contains(".")) {
			String[] array = IP.split("\\.");
			if (array.length != 4) {
				return NON;
			}

			for (int i=0;i<array.length;i++) {
				String s = array[0];
				if (s.startsWith(" ") || s.length()==0 || s.length()>4) {
					return NON;
				}
				int v = 0;
				for (char c : s.toCharArray()) {
					int t = c + 0;
					if (!(t >= 48 && t <= 57)) {
						return NON;
					}
					v = v * 10 + (t - 48);
				}
				if (v < 0 || v > 255) {
					return NON;
				}
				if (v != 0 && s.startsWith("0")) {
					return NON;
				}
				if(v==0 && i==0){
					return NON;
				}
			}
			return "IPv4";
		}

		if(IP.startsWith(":") || IP.endsWith(":")){
			return NON;
		}
		String[] array = IP.split("\\:");
		if (array.length == 8) {
			for (String s : array) {
				if (s.startsWith(" ") || s.length()==0) {
					return NON;
				}
				for (char c : s.toCharArray()) {
					int t = c + 0;
					if (!((t >= 65 && t <= 70) || (t >= 97 && t <= 102) || (t >= 48 && t <= 57))) {
						return NON;
					}
				}
			}
			return "IPv6";
		}

		return NON;
	}

}
