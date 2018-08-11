package my.czhhu.algo.tree;

import my.czhhu.algo.common.Tnode;

public class LatestCommonAncestor
{
    /*
     * this solution has a defect, suppose n1 exists in this tree, but n2 not,
     * the result would be n1. 
     * 
     * 
     * */
    static Tnode lca(Tnode root, Tnode n1, Tnode n2)
    {
        if (root == null || root == n1 || root == n2)
            return root;

        Tnode left = lca(root.left, n1, n2);
        Tnode right = lca(root.right, n1, n2);
        if (left != null && right != null)
        {
            return root;
        }

        if (left != null) // in this step can not tell, if subtree a contains subtree b or subtree a exists
        { //but substree b not 
            return left;
        }
        if (right != null)
        {
            return right;
        }

        return null;
    }

    /*
     * in this impl, if n1 exists but n2 not, return null
     * */
    static Tnode lca1(Tnode root, Tnode n1, Tnode n2)
    {
        if (root == null)
        {
            return null;
        }

        Result r = lcaR(root, n1, n2);
        if (r.isAncestor)
        {
            return r.node;
        }
        return null;

    }

    private static Result lcaR(Tnode root, Tnode n1, Tnode n2)
    {
        if (root == null)
        {
            return new Result(null, false);
        }

        if (root == n1 && root == n2)
        {
            return new Result(root, true);
        }

        Result resL = lcaR(root.left, n1, n2);
        if (resL.isAncestor)
        {
            return resL;
        }
        Result resR = lcaR(root.right, n1, n2);
        if (resR.isAncestor)
        {
            return resR;
        }

        if (resL.node != null && resR.node != null)
        {
            return new Result(root, true);
        }
        else if (root == n1 || root == n2)
        {
            boolean isAncestor = resL.node != null || resR.node != null ? true : false;

            return new Result(root, isAncestor);

        }
        else
        {
            return new Result(resL.node != null ? resL.node : resR.node, false);
        }

    }

    static class Result
    {
        public Result(Tnode n, boolean b)
        {
            // TODO Implement Result constructor.
            this.node = n;
            this.isAncestor = b;

        }

        Tnode node;
        boolean isAncestor;

    }

    public static void main(String[] args)
    {
        Tnode root = new Tnode(4);
        Tnode l1 = new Tnode(3);
        Tnode l1l1 = new Tnode(8);
        Tnode r1 = new Tnode(7);
        Tnode l2 = new Tnode(5);
        Tnode r2 = new Tnode(6);

        root.left = l1;
        l1.right = l1l1;
        root.right = r1;
        r1.left = l2;
        r1.right = r2;

        // System.out.println(lca(root, r1, new Tnode(11)).data);
        System.out.println(lca1(root, r1, l2).data);
        //CommonOp.printTreeByLevel(root);

    }

}
