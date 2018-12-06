package com.lee.string;

public class LongestFilePath388 {

	public static void main(String[] args) {
		LongestFilePath388 obj = new LongestFilePath388();
		{
			String s = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
//			System.out.println(s);
			int t = obj.lengthLongestPath(s);
			System.out.println("max length " + t);
		}
	}
	
    public int lengthLongestPath(String input) {
    	
		String[] paths = input.split("\n");
		int[] stack = new int[paths.length + 1];
		int maxLen = 0;
		for (String s : paths) {
			int lev = s.lastIndexOf("\t") + 1;
			
			stack[lev + 1] = stack[lev] + s.length() - lev + 1;
			int curLen = stack[lev + 1];
			System.out.println(s + "..." + s.lastIndexOf("\t") + "..curlen " + curLen);
			if (s.contains(".")){
				maxLen = Math.max(maxLen, curLen - 1);
			}
		}
		return maxLen;
    }

}
