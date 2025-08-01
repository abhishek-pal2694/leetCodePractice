package IBM_prac;

public class sumBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(sumOfValue(root));
    }

    public static int sumOfValue(TreeNode root){
        if(root==null) return 0;
        return root.val + sumOfValue(root.left) + sumOfValue(root.right);

    }

}
