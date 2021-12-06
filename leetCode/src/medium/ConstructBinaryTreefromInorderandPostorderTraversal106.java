package medium;

public class ConstructBinaryTreefromInorderandPostorderTraversal106 {
    //解法:對於postOrder來說,最後的那一位就是root,對於前序inOrder來說,root以左是左子樹,root以右是右子樹
    //    首先在postOrder先找出root,再用那個root去inOrder切出左右子樹
    //    以{9,3,15,20,7}; {9,15,7,20,3}; root是"3"
    //    切出來的inOrder    左子樹:{9},右:{15,20,7}
    //    切出來的postOrder, 左子樹:{9},右:{15,7,20}(要看inOrder被切多長,決定postOrder左子樹的長度)


    public static void main(String[] args) {
//        int[] inOrder = {9,3,15,20,7};
        int[] inOrder = {2,1};
//        int[] postOrder = {9,15,7,20,3};
        int[] postOrder = {2,1};
        TreeNode root = buildTree(inOrder, postOrder);
        inOrder(root);
        System.out.println(root.left.val);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }


    public static TreeNode treeBuilder(int[] inorder,int inS,int inE,int[] postorder,int poS,int poE){
        if(inS>inE || poS > poE||poS<0||poE<0||inS<0||inE<0){
            return null;
        }
        TreeNode root = new TreeNode(postorder[poE]);
        int cutIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i]== root.val){
                cutIndex=i;
                break;
            }
        }

        root.left = treeBuilder(inorder,inS,cutIndex-1,postorder,poS,poS+cutIndex-inS-1);
        root.right= treeBuilder(inorder,cutIndex+1,inE,postorder,poS+cutIndex-inS,poE-1);
        return root;

    }

    public static void inOrder(TreeNode root){
        System.out.println(root.val);
        if(root.left!=null){
            inOrder(root.left);
        }
        if(root.right!=null){
            inOrder(root.right);
        }

    }
    public static TreeNode build(int[] inorder, int inS, int inE, int[] postorder, int posS, int posE){
        if(inS>inE || posS>posE) return  null;

        TreeNode root = new TreeNode(postorder[posE]);

        int rootI=0;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==root.val){
                rootI = i;
                break;
            }
        }

        root.left = build(inorder,inS,rootI-1,postorder,posS,posS+rootI-inS-1);
        root.right = build(inorder,rootI+1,inE,postorder,posS+rootI-inS,posE-1);

        return root;
    }
}
class TreeNode {
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
 }
