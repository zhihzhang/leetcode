package com.lee.againt;

import java.util.List;

public class GenerateParentheses {

	public static void main(String[] args) {
		String x = "foo<script>alert(%27xss%27)</script>bar";
		String s01 = x.replaceAll("</script>", "");
		String s02 = s01.replaceAll("<script>", "");
		System.out.println(s02);
	}
	
    public List<String> generateParenthesis(int n) {
        return null;
    }

}
