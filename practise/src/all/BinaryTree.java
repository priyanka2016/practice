package all;

import java.io.Serializable;
import java.util.*;
import java.util.Stack;

/**
 * Created by priyanka on 25/8/17.
 */
public class BinaryTree implements Serializable{

    public Node root;

    public static class Node{
        Node left;
        Node right;
        int d;

        public Node(int d) {
            this.d = d;
            left=right=null;
        }
    }

    public BinaryTree(int key) {
        this.root = new Node(key);
    }

    BinaryTree(){
        root = null;
    }
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(100);
        binaryTree.root.left = new Node(50);

        binaryTree.root.left.right = new Node(70);
        binaryTree.root.left.left=new Node(10);
        binaryTree.root.left.right.right = new Node(80);
        binaryTree.root.left.right.right.right = new Node(110);
        System.out.println(isBST(binaryTree.root,Integer.MIN_VALUE,Integer.MAX_VALUE));

    }

    private static int diameter(Node root){
        if(root==null){
            return 0;
        }
        int lh = treeHeight(root.left);
        int rh = treeHeight(root.right);
        int ld = diameter(root.left);
        int rd = diameter(root.right);
        return  Math.max(Math.max(lh+rh+1,ld),rd);
    }

    private static boolean isBST(Node root,int min,int max){
        if(root == null || (root.left==null&&root.right==null)){
            return true;
        }
        if(!((root.left==null ||(root.left.d<root.d && root.left.d>min))
                &&(root.right==null||(root.right.d>root.d &&root.right.d<max)))){
            return false;
        }
        return (isBST(root.left,min,root.d)&&isBST(root.right,root.d,max));
    }
    private static int findLCA(List<Integer> list1, List<Integer> list) {
        int i,j;
        for(i=list.size()-1,j=list1.size()-1;i>=0&&j>=0;i--,j--){
                if(list.get(i)!=list1.get(j)){
                    break;
                }

        }

        return list.get(i+1);

    }
    public static boolean lca(Node n,int n1,int n2){
        if(n==null){
            return false;
        }
        if (n.d==n1||n.d==n2) {
            return true;
        }
        boolean k =lca(n.left,n1,n2);
        boolean j =lca(n.right,n1,n2);
        if(k&&j){
            System.out.println(n.d);
            return true;
        }
        if(!j&&!k){
            return false;
        }
        return true;
    }

    public static boolean path(Node n,int d,List<Integer> p){
        if(null==n){
            return false;
        }
        if (n.d==d){
            p.add(d);
            System.out.println(d);
            return true;
        } if(path(n.left,d,p)||path(n.right,d,p)){
            p.add(n.d);
            System.out.println(n.d);
            return true;
        }
        return false;
    }
    private static boolean checkIfBST(Node root){
        if(root == null){
            return true;
        }
        if((root.left!=null&& root.left.d>root.d)||(root.right!=null && root.right.d<root.d)){
            return false;
        }
        if(checkIfBST(root.left)&&checkIfBST(root.right)){
            return true;
        }
        else{
            return false;
        }
    }

    private static void inorderWithoutRecurssion(Node root) {
        Node temp = root;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(temp!=null){
            while(temp.left!=null){
                stack.push(temp.left);
                temp=temp.left;
            }
            while (stack.size()>0){
                Node k =stack.pop();
                System.out.println(k.d);
                if(k.right!=null){
                    temp = k.right;
                }
                while(temp.left!=null){
                    stack.push(temp.left);
                    temp=temp.left;
                }
            }
            Node k =stack.pop();
            System.out.println(k.d);
            while(k.right==null){
                try {
                    k = stack.pop();
                    System.out.println(k.d);
                }
                catch (EmptyStackException e){
                    break;
                }
            }
            stack.push(k.right);
            temp=k.right;

        }
    }

    private static void levelOrderTraverse(Node root) {
        int height = treeHeight(root);
       for(int i=1;i<=height;i++){
           printGivenLevel(root,i);
           System.out.println();
       }

    }

    private static void levelOrderTraverseUsingQueue(Node root) {
       Node temp = root;
       Queue1 queue1 =new Queue1();

       while(temp!=null){
           System.out.println(temp.d);
           if(temp.left!=null) {
               queue1.enque(temp.left);
           }
           if(temp.right!=null) {
               queue1.enque(temp.right);
           }
           temp = queue1.deque();
       }

    }
    private static void printGivenLevel(Node root, int i) {
        if(root!=null) {
            if (i == 1) {
                System.out.print(root.d + " ");
            } else {
                printGivenLevel(root.left, i - 1);
                printGivenLevel(root.right, i - 1);
            }
        }
    }

    private static void inorder(Node root) {
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.d + " ");
        inorder(root.right);
    }

    private static void preorder(Node root) {
        if(root==null){
            return;
        }
        System.out.print(root.d + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void postorder(Node root) {
        if(root==null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.d + " ");
    }

    private static int treeHeight(Node root){
        if(root == null){
            return 0;
        }
        else{
            int l = treeHeight(root.left);
            int r = treeHeight(root.right);

            if(l>r){
                return l+1;
            }
            else{
                return r+1;
            }
        }

    }

    private static int treeHeight(Node root,int h){
        if(root == null){
            return h;
        }
        else{
            int l = treeHeight(root.left,h+1);
            int r = treeHeight(root.right,h+1);

            if(l>r){
                return l;
            }
            else{
                return r;
            }
        }

    }


}
