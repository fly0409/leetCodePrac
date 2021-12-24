package easy2;

import commonObject.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {


    public static List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        inOrderTraversal(root, res);
        return res;

    }
    public static void inOrderTraversal(TreeNode root,List<Integer> res){
        if(root.left!=null){
           inOrderTraversal(root.left,res);
        }
        res.add(root.val);
        if(root.right!=null) {
            inOrderTraversal(root.right,res);
        }
    }
    public List<Integer> inorderTraversalIter2(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while(cur!=null || !stack.empty()){
            while(cur!=null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.right = t2;
        t2.left = t3;
        List<Integer> arr = inorderTraversal(null);
        arr.forEach(integer -> {
            System.out.println(integer);
        });
    }
}
