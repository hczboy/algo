package my.czhhu.algo.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

public class SimplifyPath71
{
    static String sp(String p)
    {
        if (p == null || p.length() == 0)
            return null;
        if (!p.startsWith("/"))
            return null;

        LinkedList<String> ll = new LinkedList<>();

        int start = 1, end = 1;
        String mp;
        while (end < p.length())
        {
            while (end < p.length() && p.charAt(end) != '/')
            {
                end++;
            }

            if (!(end < p.length()))
            {
                ll.add(p.substring(start, end));
                break;
            }

            if (start < end)
            {
                mp = p.substring(start, end);
                if (mp.equals(".."))
                {
                    ll.removeLast();
                }
                else if (!".".equals(mp))
                {
                    ll.add(mp);
                }
            }

            start = end + 1;
            end = start;

        }

        StringBuilder sb = new StringBuilder();
        while (!ll.isEmpty())
        {
            sb.append("/");
            sb.append(ll.poll());

        }
        return sb.toString();

    }

    public static void main(String[] args)
    {
        String p = "/home/.///plcm/././da/lib/../class";
        //String p = "////home///./plcm";
        System.out.println(Arrays.deepToString(p.split("/")));
        System.out.println(sp(p));

    }

}
