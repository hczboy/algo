package my.czhhu.algo.tree;

import java.util.LinkedList;
import java.util.List;

import my.czhhu.algo.common.Tnode;

public class PathToSum
{

    static List<String> findPathToSum(Tnode root, int sum)
    {
        if (root == null)
            return null;

        LinkedList<Tnode> path = new LinkedList<>();
        List<String> result = new LinkedList<>();
        findPathToSum(root, sum, path, result);
        return result;
    }

    private static void findPathToSum(Tnode root, int sum, LinkedList<Tnode> path, List<String> result)
    {
        if (root == null)
            return;
        path.add(root);
        int s = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = path.size() - 1; i >= 0; i--)
        {
            s += path.get(i).data;
            sb.append(path.get(i).data).append(", ");
            if (s == sum)
            {
                result.add(sb.toString());
            }
        }
        findPathToSum(root.left, sum, path, result);
        findPathToSum(root.right, sum, path, result);
        path.remove(root);
        return;
    }

    public static void main(String[] args)
    {

    }

}
