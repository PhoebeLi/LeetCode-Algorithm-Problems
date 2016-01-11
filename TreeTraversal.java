package java_exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import java_exercise.Solution.TreeNode;

public class TreeTraversal {

	public class TreeNode {
		int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	
	}
	
	/*
	 *  Preorder Traversal
	 * 
	 * Given a binary tree, return the preorder traversal of its nodes' values.
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
      
        if (root == null) return result;
      
        TreeNode cur = root;
        while (true) {
          if (cur != null) {
            s.push(cur);
            result.add(cur.val);
            cur= cur.left;
          
          } else {
            if (s.empty()) break;
            cur = s.peek().right;
            s.pop();
          }
        }
        return result;
   }
	
	
	/*
	 * Inorder Traversal
	 * 
	 * Given a binary tree, return the intorder traversal of its nodes' values.
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
			
			List<Integer> result = new ArrayList<Integer>();
			if (root == null) return result;
			Stack<TreeNode> s = new Stack<TreeNode>();
			
			TreeNode cur = root;
			while(true) {
				if (cur != null) {
					s.push(cur);
					cur = cur.left;
				} else {
					if (s.isEmpty()) break;
					TreeNode t = s.pop();
					result.add(t.val);
					cur =t.right;
				}
			}
			return result;	        
		}

	
	/*
	 * Postorder Traversal
	 * 
	 * Given a binary tree, return the postorder traversal of its nodes' values.
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
	      Stack<TreeNode> s = new Stack<TreeNode>();
	      Stack<Integer> tmp = new Stack<Integer>();
	      List<Integer> result = new ArrayList<Integer>();
	      if (root == null) return result;
	      
	      s.push(root);
	      
	      while(!s.empty()) {
	        TreeNode cur = s.peek();
	        s.pop();
	        tmp.push(cur.val);
	        if (cur.left != null) s.push(cur.left);
	        if (cur.right != null)s.push(cur.right);
	      }
	      
	      while(!tmp.empty()) {
	        result.add(tmp.peek());
	        tmp.pop();
	      }
	      return result;
	    }
	
}
