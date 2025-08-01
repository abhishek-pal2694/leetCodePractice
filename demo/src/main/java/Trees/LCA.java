package Trees;

import IBM_prac.TreeNode;

public class LCA {

    public static void main(String[] args) {

//        lowestCommonAncestor(new TreeNode(6))
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < root.val && q.val < root.val){
            lowestCommonAncestor(root.left, p, q);
        } else if(p.val > root.val && q.val > root.val){
            lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
        return null;
    }
}
