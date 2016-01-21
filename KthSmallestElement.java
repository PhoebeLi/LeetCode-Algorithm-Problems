package java_exercise;

import java.util.Stack;

public class KthSmallestElement {
	
	/*
	 * Kth Smallest Element in a BST
	 * 
	 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

	 * Note: 
	 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
	 */
	
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	 }
	
	//iteration solution
	//using inorder traversal to traverse the BST and return the kth node we have visited. Time is O(n)
	public int kthSmallest(TreeNode root, int k) {
		if(root == null) return -1;
		 int cnt = 0;
		 Stack<TreeNode> stack = new Stack<TreeNode>();
		 
		 TreeNode cur = root;
		 while(true){
			if(cur != null) {
				stack.push(cur);
				cur = cur.left;
			}else {
				if(stack.isEmpty()) break;
				TreeNode top = stack.pop();
				cur = top.right;
				
				cnt ++;
				if(cnt == k) return top.val;
			}
		 }
		 return -1;
	 }
}
