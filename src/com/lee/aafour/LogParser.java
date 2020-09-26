package com.lee.aafour;

import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import com.sun.org.apache.bcel.internal.generic.POP;

public class LogParser {

	public static void main(String[] args) {
		parse();
	}

	final static String fileStr = "/Users/zhihzhang/projects/log.txt";
	final static String queryHead = "/cms/repositories/cmsdb/branches/main/query";
	
	Map<String, Map<String, Integer>> map = new HashMap<>();

	public static void parse() {
		try {
			File file = new File(fileStr);
			LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(file));
			String lineStr = lineNumberReader.readLine();
			while (lineStr != null) {
				String[] arr = lineStr.split(" ");
				// System.out.println(Arrays.toString(arr));
				String raw = arr[7].trim();
				if (raw.startsWith(queryHead)) {
					String query = raw.substring(queryHead.length() + 1);
					int idx = query.indexOf('?');
					if (idx > 0) {
						query = query.substring(0, idx);
					}
					// System.out.println(query);
					query = decode(query);
					System.out.println(query);
				}
				lineStr = lineNumberReader.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	public static void pop(String query, String user){
//		LinkedList<Character> queue = new LinkedList<>();
//		for(char c:query.toCharArray()){
//			if(!queue.isEmpty() && queue.peekLast()=='{'){
//				if(c=='}'){
//					queue.pollLast();
//				}
//			} else if
//		}
//		
//		r
//	}

	public static String decode(String url) {
		try {
			String prevURL = "";
			String decodeURL = url;
			while (!prevURL.equals(decodeURL)) {
				prevURL = decodeURL;
				decodeURL = URLDecoder.decode(decodeURL, "UTF-8");
			}
			return decodeURL;
		} catch (UnsupportedEncodingException e) {
			return "Issue while decoding" + e.getMessage();
		}
	}

}
