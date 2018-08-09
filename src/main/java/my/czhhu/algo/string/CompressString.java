package my.czhhu.algo.string;

/*
 * 
 * input "aabccccee", output "a2b1c4e2"
 * if length of alternative is more than original ,return original
 *  
 * */

public class CompressString
{

    static String compressAlter(String s)
    {
        if (s == null)
            return null;

        int size = countCompress(s);
        if (size >= s.length())
            return s;

        char[] comp = new char[size];
        char c = s.charAt(0);
        int count = 1;
        int ci = 0;
        for (int i = 1; i < s.length(); i++)
        {
            if (c == s.charAt(i))
            {
                count++;
            }
            else
            {
                ci = setChar(comp, ci, c, count);
                c = s.charAt(i);
                count = 1;

            }

        }

        setChar(comp, ci, c, count);
        return new String(comp);

    }

    private static int setChar(char[] comp, int ci, char c, int count)
    {
        comp[ci++] = c;
        for (char ct : String.valueOf(count).toCharArray())
        {
            comp[ci++] = ct;
        }
        return ci;

    }

    static int countCompress(String s)
    {
        char c = s.charAt(0);
        int count = 1;
        int size = 0;
        for (int i = 1; i < s.length(); i++)
        {
            if (c == s.charAt(i))
            {
                count++;
            }
            else
            {

                size += 1 + String.valueOf(count).length();
                count = 1;
                c = s.charAt(i);
            }
        }
        return size += 1 + String.valueOf(count).length();

    }

    public static void main(String[] args)
    {
        // String s = "aabccccee";
        String s = "aa";
        System.out.println(countCompress(s));
        System.out.println(compressAlter(s));
    }

}
