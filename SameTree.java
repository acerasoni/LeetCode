/* https://leetcode.com/problems/same-tree/submissions/
Runtime: 0 ms, faster than 100.00% of Java online submissions for Same Tree.
Memory Usage: 34 MB, less than 100.00% of Java online submissions for Same Tree.

Recursive approach: iterate both trees preOrder (order actually doesn't matter, as long as we are being consistent throughout the navigation)
If at any point their values don't match, OR one is null and the other isn't, return false;
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Boolean t = true;
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        preOrder(p, q);
        return t;
    }
    
    public void preOrder(TreeNode p, TreeNode q) {
        if(p == null && q == null) return;
        else if(p == null || q == null) {
            t = false;
            return;
        }

        preOrder(p.left, q.left);  
        if(p.val != q.val) {
            t = false;
            return;
        }
        preOrder(p.right, q.right);
    }
}
