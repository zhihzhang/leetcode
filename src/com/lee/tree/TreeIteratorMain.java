package com.lee.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import com.lee.common.Node;
import com.lee.common.TreeNode;

//三、二叉树的遍历
//遍历即将树的所有结点访问且仅访问一次。按照根节点位置的不同分为前序遍历，中序遍历，后序遍历。
//前序遍历：根节点->左子树->右子树
//中序遍历：左子树->根节点->右子树
//后序遍历：左子树->右子树->根节点

//https://blog.csdn.net/zlp1992/article/details/51406067
//https://blog.csdn.net/clam_clam/article/details/6845399
//http://robinsoncrusoe.iteye.com/blog/808526

//http://www.cnblogs.com/AnnieKim/archive/2013/06/15/morristraversal.html
//https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
public class TreeIteratorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deque list = new LinkedList<String>();

	}

	public static void visit(Node p) {
		System.out.print(p.getVal() + " ");
	}

	/** 递归实现前序遍历 */
	protected static void preorder(Node p) {
		if (p != null) {
			visit(p);
			preorder(p.getLeft());
			preorder(p.getRight());
		}
	}

	/** 递归实现中序遍历 */
	protected static void inorder(Node p) {
		if (p != null) {
			inorder(p.getLeft());
			visit(p);
			inorder(p.getRight());
		}
	}

	/** 递归实现后序遍历 */
	protected static void postorder(Node p) {
		if (p != null) {
			postorder(p.getLeft());
			postorder(p.getRight());
			visit(p);
		}
	}

	/**
	 * 非递归先序遍历二叉树
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> resultList = new ArrayList<>();
		Stack<TreeNode> treeStack = new Stack<>();
		if (root == null) // 如果为空树则返回
			return resultList;
		treeStack.push(root);
		while (!treeStack.isEmpty()) {
			TreeNode tempNode = treeStack.pop();
			if (tempNode != null) {
				resultList.add(tempNode.val);// 访问根节点
				treeStack.push(tempNode.right); // 入栈右孩子
				treeStack.push(tempNode.left);// 入栈左孩子
			}
		}
		return resultList;
	}

	/**
	 * 非递归中序遍历
	 */
	public List<Integer> inorderTraversalNonCur(TreeNode root) {
		List<Integer> visitedList = new ArrayList<>();
		Map<TreeNode, Integer> visitedNodeMap = new HashMap<>();// 保存已访问的节点
		Stack<TreeNode> toBeVisitedNodes = new Stack<>();// 待访问的节点
		if (root == null)
			return visitedList;
		toBeVisitedNodes.push(root);
		while (!toBeVisitedNodes.isEmpty()) {
			TreeNode tempNode = toBeVisitedNodes.peek(); // 注意这里是peek而不是pop
			while (tempNode.left != null) { // 如果该节点的左节点还未被访问，则需先访问其左节点
				if (visitedNodeMap.get(tempNode.left) != null) // 该节点已经被访问（不存在某个节点已被访问但其左节点还未被访问的情况）
					break;
				toBeVisitedNodes.push(tempNode.left);
				tempNode = tempNode.left;
			}
			tempNode = toBeVisitedNodes.pop();// 访问节点
			visitedList.add(tempNode.val);
			visitedNodeMap.put(tempNode, 1);// 将节点加入已访问map
			if (tempNode.right != null) // 将右结点入栈
				toBeVisitedNodes.push(tempNode.right);
		}
		return visitedList;
	}

	/**
	 * 非递归中序遍历二叉树
	 */
	// Discuss中有人给出更简洁的方法：https://leetcode.com/discuss/19765/iterative-solution-in-java-simple-and-readable
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;

		while (cur != null || !stack.empty()) {
			while (cur != null) {
				stack.add(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			list.add(cur.val);
			cur = cur.right;
		}

		return list;
	}
	
	
	//// 下面是简单版本的
	
    /** 非递归实现中序遍历2 */  
    protected static void iterativeInorder2(Node p) {  
        Stack<Node> stack = new Stack<Node>();  
        Node node = p;  
        while (node != null || stack.size() > 0) {  
            while (node != null) {  
                stack.push(node);  
                node = node.getLeft();  
            }  
            if (stack.size() > 0) {  
                node = stack.pop();  
                visit(node);  
                node = node.getRight();  
            }  
        }  
    }  
	
    /** 非递归实现前序遍历2 */  
    protected static void iterativePreorder2(Node p) {  
        Stack<Node> stack = new Stack<Node>();  
        Node node = p;  
        while (node != null || stack.size() > 0) {  
            while (node != null) {//压入所有的左节点，压入前访问它  
                visit(node);  
                stack.push(node);  
                node = node.getLeft();  
            }  
            if (stack.size() > 0) {//  
                node = stack.pop();  
                node = node.getRight();  
            }  
        }  
    }  
    
    /** 非递归实现后序遍历 */  
    protected static void iterativePostorder(Node p) {  
        Node q = p;  
        Stack<Node> stack = new Stack<Node>();  
        while (p != null) {  
            // 左子树入栈  
            for (; p.getLeft() != null; p = p.getLeft())  
                stack.push(p);  
            // 当前节点无右子或右子已经输出  
            while (p != null && (p.getRight() == null || p.getRight() == q)) {  
                visit(p);  
                q = p;// 记录上一个已输出节点  
                if (stack.empty())  
                    return;  
                p = stack.pop();  
            }  
            // 处理右子  
            stack.push(p);  
            p = p.getRight();  
        }  
    }  

	/**
	 * leetcode地址：https://leetcode.com/problems/binary-tree-postorder-traversal/
	 * Discuss中有人给出了一个”巧“的方法，即先采用类似先序遍历，先遍历根结点再右孩子最后左孩子（先序是先根结点再左孩子最后右孩子），
	 * 最后把遍历的序列逆转即得到了后序遍历
	 * https://leetcode.com/discuss/101547/java-recursive-and-iterative-solutions
	 * 
	 * 试过 有用  根节点 右孩子 然后左孩子
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
		Deque<TreeNode> stack = new LinkedList<>();
		stack.push(root);
		List<Integer> ret = new ArrayList<>();
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (node != null) {
				ret.add(node.val);
				stack.push(node.left);
				stack.push(node.right);
			}
		}
		Collections.reverse(ret);
		return ret;
	}

	/**
	 * 层序遍历也即宽度优先搜索，一层一层搜索，非递归代码如下：
	 * leetcode地址：https://leetcode.com/problems/binary-tree-level-order-traversal/
	 */

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> resultList = new ArrayList<>();
		int levelNum = 0;// 记录某层具有多少个节点
		Queue<TreeNode> treeQueue = new LinkedList<>();
		treeQueue.add(root);
		while (!treeQueue.isEmpty()) {
			levelNum = treeQueue.size();
			List<Integer> levelList = new ArrayList<>();
			while (levelNum > 0) {
				TreeNode tempNode = treeQueue.poll();
				if (tempNode != null) {
					levelList.add(tempNode.val);
					
					treeQueue.add(tempNode.left);
					treeQueue.add(tempNode.right);
				}
				levelNum--;
			}
			if (levelList.size() > 0)
				resultList.add(levelList);
		}
		return resultList;
	}

}
