package my.czhhu.algo.dp;
/*
 * the "fish" "fosh", the longestPublicSubSeq = 3
 * state transition :
 * for two char array x[], y[], int[][] d records the intermediate longestPublicSubSeq
 * 
 *                 0;                                       xlen, ylen ==0      
 * d[xlen][ylen] = d[xlen-1][ylen-1]+1;                     x[xlen]==y[ylen]
 *                 Max{d[xlen-1][ylen], d[xlen][ylen-1]};   x[xlen] != y[ylen]      
 * 
 * 
 * */

public class LongestPublicSubSeq
{

    public static int run(char[] x, char[] y)
    {
        int xlen = x.length;
        int ylen = y.length;
        int d[][] = new int[xlen + 1][ylen + 1];
        //d[0][0]=0;
        for (int xi = 1; xi <= xlen; xi++)
        {
            for (int yi = 1; yi <= ylen; yi++)
            {
                if (x[xi - 1] == y[yi - 1])
                {
                    d[xi][yi] = d[xi - 1][yi - 1] + 1;
                }
                else
                {
                    d[xi][yi] = Math.max(d[xi - 1][yi], d[xi][yi - 1]);
                }
            }
        }
        return d[xlen][ylen];
    }

    public static void main(String[] args)
    {
        String xStr = "fish";
        String yStr = "foxsh";
        System.out.println(run(xStr.toCharArray(), yStr.toCharArray()));

    }

}
