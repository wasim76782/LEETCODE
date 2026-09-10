/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count = 0;
    public int averageOfSubtree(TreeNode root) {
        

       postOrder(root);
       return count;
    }
    public Pair postOrder(TreeNode root){
        if(root == null){
            return new Pair(0,0);
        }
        Pair left = postOrder(root.left);
        Pair right = postOrder(root.right);
        int sum = left.first + right.first + root.val;
        int nodeCount = left.second+right.second+1;
        if((sum/nodeCount)  == root.val){
            count++;
        }
        return new Pair(sum,nodeCount);
    }
}
class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}