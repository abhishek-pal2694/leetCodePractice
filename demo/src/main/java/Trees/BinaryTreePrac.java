package Trees;

import IBM_prac.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreePrac {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        static int index = -1;
        public static Node buildTree(int[] nodes){
            index++;
            if(nodes[index] == -1){
                return null;
            }
            Node node = new Node(nodes[index]);
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);


            return node;
        }
    }

    public static void preorder(Node root){
        if(root == null) return;
        System.out.print(root.data+ " ");
        preorder(root.left);
        preorder(root.right);
    }

    static int sum = 0;
    public static void greaterSumTree(Node root){
        if(root != null){
            greaterSumTree(root.right);
            sum+= root.data;
            root.data = sum;
            greaterSumTree(root.left);
            System.out.print(sum + "|");
        }
    }

    //Inorder traversal: left tree --> root --> right tree
    public static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.println("root data --> "+root.data + " ");
        inorder(root.right);
    }

    //PostOrder traversal: left tree --> right tree --> root
    public static void postOrder(Node root){
        if(root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println("root: "+root.data);
    }

    //Level Order Traversal : BFS( printing nodes level wise )
    // 1
    // 2 3
    // 4 5 6
    public static void levelOrderTraversal(Node root){

        if(root==null) return;
        // first create the queue and initialise with root
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty()){
            Node curr = queue.remove();
            if(curr == null) {
                System.out.println();
                if(queue.isEmpty())
                    break;
                else{
                    queue.add(null);
                }
            }else{
                System.out.println("currentNode --> "+curr.data);
                if(curr.left!= null){
                    queue.add(curr.left);
                }
                if(curr.right!= null){
                    queue.add(curr.right);
                }
            }

        }

    }

    public static int countNodes(Node root){
        if(root==null) return 0;
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left + right + 1;
    }

    public static int sumOfNodes(Node root){
        if(root==null) return 0;
        int leftVal = sumOfNodes(root.left);
        int rightVal = sumOfNodes(root.right);
        return root.data + leftVal + rightVal;
    }

    public static int heightOfTree(Node root){
        if(root==null) return 0;
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);
        int maxHeight = Math.max(leftHeight,rightHeight);
        return maxHeight+1;
    }
    static class TreeInfo{
        int height;
        int diam;

        TreeInfo(int height, int diameter){
            this.height = height;
            this.diam = diameter;
        }
    }
    public static TreeInfo diameterOfTree(Node root){

        if(root==null){
            return new TreeInfo(0,0);
        }
        TreeInfo left = diameterOfTree(root.left);
        TreeInfo right = diameterOfTree(root.right);

        int currNodeHeight = Math.max(left.height, right.height) + 1;

        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.height + right.height + 1; // This is calculated as left height --> root --> right height

        int currNodeDiam = Math.max(diam3, Math.max(diam1,diam2));

        return new TreeInfo(currNodeHeight, currNodeDiam);

    }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node node = BinaryTree.buildTree(nodes);
        //System.out.println(node.data + "---"+ node.left.data+ "---"+ node.right.data);
        preorder(node);
        //greaterSumTree(node);
        //inorder(node);
        //postOrder(node);
        //levelOrderTraversal(node);
        System.out.println();
        System.out.println("count: "+countNodes(node));
        System.out.println("sum of nodes: "+sumOfNodes(node));
        System.out.println("height of tree: "+heightOfTree(node));
        System.out.println("diameter of tree: "+diameterOfTree(node).diam);
    }
}
