package com.lee.binarysearch;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import com.lee.common.TreeNode;

public class SecondMinimum671 {

	public static void main(String[] args) {
		SecondMinimum671 obj = new SecondMinimum671();
		
		Map<Integer, String> map = new LinkedHashMap<Integer, String>(100, (float) 0.5, true);
		map.put(1, null);
	    map.put(2, null);
	    map.put(3, null);
	    map.put(4, null);
	    map.put(5, null);
	    Set<Integer> keys = map.keySet();
	    System.out.println(keys.toString());
	  
	    map.put(6, null);
	    System.out.println(keys.toString());
	    
	    map.put(4, null);
	    System.out.println(keys.toString());
	    
	    Queue<Integer> queue = new PriorityQueue<Integer>((a,b)->(b-a));
	    queue.add(5);
	    queue.add(7);
	    System.out.println(queue.poll());
	}
	
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null ) {
            return -1;
        }
        int l = root.left.val;
        int r = root.right.val;
        
        // if value same as root value, need to find the next candidate
        if (root.left.val == root.val) {
            l = findSecondMinimumValue(root.left);
        }
        if (root.right.val == root.val) {
            r = findSecondMinimumValue(root.right);
        }
        
        if (l != -1 && r != -1) {
            return Math.min(l, r);
        } else if (l != -1) {
            return l;
        } else {
            return r;
        }
    }

}
