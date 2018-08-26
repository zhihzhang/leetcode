package com.lee;

public class NimGame292 {

	public static void main(String[] args) {
		NimGame292 o = new NimGame292();
		for(int i=1;i<100;i++){
			System.out.println(i + " : " + o.canWinNim(i));
		}

	}
	
    public boolean canWinNim(int n) {
        if(n<4){
            return true;
        }
        if(n==4){
            return false;
        }
        //opponent
        if(!canWinNim(n-1) || !canWinNim(n-2) || !canWinNim(n-3)){
            return true;
        } 
        return false;
    }

}
