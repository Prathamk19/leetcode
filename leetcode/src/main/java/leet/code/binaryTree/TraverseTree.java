package leet.code.binaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TraverseTree
{

    class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int i)
        {
            val = i;
        }
    }
    
    
    public static void main(String[] args)
    {
        TraverseTree t = new TraverseTree();
        t.init();
    }

    // Top down approach 
    // 1st check given element, validate condition -> go ahead  recurse down.
    boolean isValidBinaryTree(TreeNode n)
    {
        if (n == null)
            return true;
        if ((n.left != null && n.left.val > n.val) || (n.right != null && n.right.val < n.val))
            return false;
        return isValidBinaryTree(n.left) && isValidBinaryTree(n.right);
    }
    
    // bottom up approach. traverse all the way down till the leaf node, meanwhile
    // the depth is increased on each recursive call, till reaches break condition. 
    int depthOfTree(TreeNode n, int depth)
    {
        if (n == null)
            return depth;
        return Math.max(depthOfTree(n.left, depth + 1), depthOfTree(n.right, depth + 1));
    }

    private void init()
    {
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(6);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(8);
        TreeNode n5 = new TreeNode(16);
        TreeNode n6 = new TreeNode(12);
        TreeNode n7 = new TreeNode(18);
        TreeNode n8 = new TreeNode(17);
        TreeNode n9 = new TreeNode(19);
        
        
        n1.left = n2;
        n1.right = n5;
        n2.left = n3;
        n2.right = n4;
        n5.left = n6;
        n5.right = n7;
        n7.left = n8;
        n7.right = n9;
        
        System.out.println(isValidBinaryTree(n1));
        System.out.println(depthOfTree(n1, 0));
        
        List<List<Integer>> l = levelOr(n1);
        for (List<Integer> l1 : l)
        {
            System.out.println(Arrays.toString(l1.toArray()));
        }
        
//        preOrderTraverse(n1);
//        inOrderTraverse(n1);
//        postOrderTraverse(n1);
        levelOrderTraverse(n1);
    }

    private void levelOrderTraverse(TreeNode n1)
    {
        TreeNode leftNode = n1.left;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<List<Integer>> res = new ArrayList<List<Integer>>(); 
        q.offer(leftNode);
        
        Queue<TreeNode> temp = new LinkedList<TreeNode>();
        List<Integer> l = new ArrayList<Integer>();
        while(!q.isEmpty())
        {
            TreeNode n = q.remove();
            if (n == null) continue;
            
            l.add(n.val);
            
            if (n.left != null)
            {
                temp.add(n.left);
            }
            if (n.right != null)
            {
                temp.add(n.right);
            }
            
            if (q.isEmpty())
            {
                res.add(l);
                for (TreeNode tempN : temp)
                {
                    q.add(tempN);
                }
                temp = new LinkedList<TreeNode>();
                l = new ArrayList<Integer>();
            }
        }
    }

    
    private List<List<Integer>> levelOr(TreeNode n)
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(n);
        
        List<Integer> l = new ArrayList<Integer>();
        Queue<TreeNode> tempQ = new LinkedList<TreeNode>();
        int level = 0;
        while (!q.isEmpty())
        {
            TreeNode temp = q.remove();
            if (level % 2 == 0)
            {
                l.add(temp.val);
            }
            else
            {
                l.add(0, temp.val);
            }
            if (temp.left != null)
                tempQ.add(temp.left);
            if (temp.right != null)
                tempQ.add(temp.right);
            if (q.isEmpty())
            {
                res.add(l);
                l = new ArrayList<Integer>();
                q.addAll(tempQ);
                tempQ.clear();
                level++;
            }
        }
        
        return res;
    }

    private void postOrderTraverse(TreeNode n1)
    {
        if (n1 == null) return;
        postOrderTraverse(n1.left);
        postOrderTraverse(n1.right);
        System.out.println(n1.val);
    }


    private void inOrderTraverse(TreeNode n1)
    {
        if (n1 == null) return;
        inOrderTraverse(n1.left);
        System.out.println(n1.val);
        inOrderTraverse(n1.right);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = preorderTraversal(root, new ArrayList<Integer>());
        return result;
    }

    private List<Integer> preorderTraversal(TreeNode root, ArrayList<Integer> arrayList)
    {
//        if (root == null) return arrayList;
//        arrayList.add(root.val);
//        preorderTraversal(root.left, arrayList);
//        preorderTraversal(root.right, arrayList);
        return arrayList;
    }


    private void preOrderTraverse(TreeNode n1)
    {
        if (n1 == null) return;
        System.out.println(n1.val);
        preOrderTraverse(n1.left);
        preOrderTraverse(n1.right);
    }

}
