package my.czhhu.algo.array;

/*
 * rotata matrix 90 degree
 * 
 * */
public class RotateMatrix
{

    private static final int[][] m = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

    static void rotate(int[][] m)
    {
        int first, last;
        int len = m.length;

        //layer: [0, len-1]
        for (int layer = len - 1; layer >= len / 2; layer--)
        {
            first = len - layer - 1;
            last = layer;
            for (int i = 0; i < last - first; i++)
            {
                //store left up
                int tmp = m[first][first + i];
                //left down to left up
                m[first][first + i] = m[last - i][first];
                //right dowm to left down
                m[last - i][first] = m[last][last - i];
                //right up to right down
                m[last][last - i] = m[first + i][last];
                //left up to right up
                m[first + i][last] = tmp;
            }
        }
    }

    public static void main(String[] args)
    {
        rotate(m);
        printMatrix(m);
        int[][] m1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        rotate(m1);
        printMatrix(m1);

    }

    public static void printMatrix(int[][] m)
    {
        for (int i = 0; i < m.length; i++)
        {
            for (int j = 0; j < m.length; j++)
            {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

}
