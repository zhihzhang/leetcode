package com.lee;

public class ZigZag06 {

	public static void main(String[] args) {
		ZigZag06 obj = new ZigZag06();
		String r = obj.convert("1234567890", 4);
		System.out.print(r);
	}
	
	public String convert(String s, int numRows) {
	    if(numRows<=1)return s;
	    StringBuilder[] sb=new StringBuilder[numRows];
	    for(int i=0;i<sb.length;i++){
	        sb[i]=new StringBuilder("");   //init every sb element **important step!!!!
	    }
	    int incre=1;
	    int index=0;
	    for(int i=0;i<s.length();i++){
	        sb[index].append(s.charAt(i));
	        if(index==0){incre=1;}
	        if(index==numRows-1){incre=-1;}
	        index+=incre;
	    }
	    String re="";
	    for(int i=0;i<sb.length;i++){
	        re+=sb[i];
	    }
	    return re.toString();
	}

}
