package com.lee;

public class ReverseInteger {

	public static void main(String[] args) {
		int a = -2147483648;
		//int a = -12;
		int b = reverse(a);
		System.out.println(b);
	}
	
	
	public static int reverse(int x) {
		System.out.println(x);
		System.out.println(Math.abs(x));
        long result = 0;
        long y = x;
        if(Math.abs(y)<10){
            return x;
        }
        while(Math.abs(y)>9){
            long w = y%10;
            System.out.println(w);
            result = result*10 + w;
            y=y/10;
        }
        result = result * 10 + y;
        int r = 0;
        try{r = Math.toIntExact(result);}catch(Exception e){
            System.out.println(e.getMessage());
        }
        return r;
    }

}
