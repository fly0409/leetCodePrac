package medium;

public class DeleteNodeinaBST {
    public static TreeNode deleteNode(TreeNode root, int key) {
        TreeNode treeRoot = root;



        return root;
    }

    public static TreeNode findNode(TreeNode root, int key){
        if(root.val==key){
            return root;
        }else if(key<root.val && root.left!=null){
            return findNode(root.left,key);
        }else if(key>root.val && root.right!=null){
            return findNode(root.right,key);
        }else{
            return null;
        }


    }
    public static void triverseTree(TreeNode root){


        if(root.left!=null){
            triverseTree(root.left);
        }
        System.out.println(root.val);

        if(root.right!=null){
            triverseTree(root.right);
        }


    }



    public static void main(String[] args) {
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n5.left=n3;
        n5.right=n6;
        n3.left=n2;
        n3.right=n4;
        n6.right=n7;

//        triverseTree(n5);
        System.out.println(findNode(n5,3));

    }

 static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
         this.right = right;
      }

     @Override
     public String toString() {
         return "TreeNode{" +
                 "val=" + val +
                 '}';
     }
 }
}
