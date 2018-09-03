package com.lee.hashmap;

import java.util.HashMap;
import java.util.Map;

public class Codec535 {

	public static void main(String[] args) {
		Codec535 obj = new Codec535();

	}
	
    Map<Integer, String> map = new HashMap();
    String host = "http://tinyurl.com/";

    public String encode(String longUrl) {
      int key = longUrl.hashCode();
      int count = 1;
      while(map.containsKey(key)){
    	  key = key + (count++);
      }
      map.put(key, longUrl);
      return host+key;
    }

    public String decode(String shortUrl) {
      int key = Integer.parseInt(shortUrl.replace(host,""));
      return map.get(key);
    }

}
