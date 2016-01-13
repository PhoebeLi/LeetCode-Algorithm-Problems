package java_exercise;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTree {
	
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}

	/*
	 * Unique Binary Search Trees
	 * 
	 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
	 * 
	 * original problem: https://leetcode.com/problems/unique-binary-search-trees/
	 * reference: http://www.programcreek.com/2014/05/leetcode-unique-binary-search-trees-java/
	 */
	
	//DP solution
	//counts[i] stands for the unique number of BST's for i. The number of trees 
	//determined by the number of subtrees which have different root node.
	//For example, 
	//counts[3] = counts[0]*counts[2] 1 as the root
	//			+ counts[1]*counts[1] 2 as the root
	//			+ counts[2]*counts[0] 3 as the root
	
	public int numTrees(int n) {
		int [] counts = new int[n+1];
		for (int i = 0; i < counts.length; i++) {
			counts[i] = 0;
		}
		
        counts[0] = 1; //empty tree
        counts[1] = 1; //one node tree
        for (int i = 2; i < n+1; i++) {
            for (int j = 0; j < i; j++) {
                counts[i] += counts[j]*counts[i-1-j];
            }
        }
        return counts[n];
    }
	
	

	/*
	 * Unique Binary Search Trees II
	 * 
	 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

	 * original problem: https://leetcode.com/problems/unique-binary-search-trees-ii/
	 */
	
	public List<TreeNode> genTreesHelper(int start, int end) {
		 ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		 if (start > end) {
			 list.add(null);
			 return list;
		 }
		 
		 for (int i = start; i <= end; i++) {
			 List<TreeNode> lefts = genTreesHelper(start, i-1);
			 List<TreeNode> rights = genTreesHelper(i+1, end);
			 
			 for (TreeNode left : lefts) {
				for (TreeNode right : rights) {
				    TreeNode head = new TreeNode(i);
					head.left = left;
					head.right = right;
					list.add(head);
				}
			}
		}
		 
		 return list;
	 }
	 
	 public List<TreeNode> generateTrees(int n) {
		 return genTreesHelper(1, n);
	 }

}
