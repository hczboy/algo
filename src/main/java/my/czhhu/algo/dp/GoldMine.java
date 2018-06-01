package my.czhhu.algo.dp;

/*
 * there are 100 workers and 5 gold mines
 * http://www.cnblogs.com/sdjl/articles/1274312.html
 * */

public class GoldMine
{
    private static final int NbOfMines = 5;

    private static final int TotalWorkers = 100;
    private static final int[] workers = { 77, 22, 29, 50, 99 };// the workers for each gold mine;
    private static final int[] golds = { 92, 22, 87, 46, 90 }; //the gold can be exploited for each gold mine;

    /*
     * int[][] dd for record all sub-problem result
     * Notice: 
     * No. of Mines starts from 1;
     * */
    private static int[][] dd = new int[NbOfMines + 1][TotalWorkers + 1];

    /*
     * x[i] == true. it means the No.i mine is exploited. which false is NOT.
     * */
    private static boolean[] x = new boolean[NbOfMines + 1];

    public static int calc(int nbOfMine, int nbOfWorker)
    {
        int t = 0;
        for (int i = 1; i <= nbOfMine; i++)
        {
            for (int j = 0; j <= nbOfWorker; j++)
            {
                dd[i][j] = dd[i - 1][j];
                if (j >= workers[i - 1])
                {
                    t = dd[i - 1][j - workers[i - 1]] + golds[i - 1];
                    dd[i][j] = t > dd[i][j] ? t : dd[i][j];
                }
            }
        }
        printSelectedMineNb(nbOfMine, nbOfWorker);
        return dd[nbOfMine][nbOfWorker];

    }

    /*
     * 
     * Note that d[i][j] = max{d[i-1][j], d[i-1][j-workers[i-1] +golds[i-1]]}
     * that means it can reduce 1-dimension to d[workers] and d[workers] can be re-used between mines
     * */

    public static int calc1(int nbOfMine, int nbOfWorker)
    {
        int d[] = new int[nbOfWorker + 1];
        for (int i = 1; i <= nbOfMine; i++)
        {
            for (int j = nbOfWorker; j >= 0; j--)
            {
                if (j >= workers[i - 1])
                {
                    if (d[j - workers[i - 1]] + golds[i - 1] > d[j])
                        d[j] = d[j - workers[i - 1]] + golds[i - 1];
                }
            }
        }
        return d[nbOfWorker];
    }

    private static void printSelectedMineNb(int nbOfMine, int nbOfWorker)
    {
        int j = nbOfWorker;
        for (int i = nbOfMine; i > 0; i--)
        {
            if (dd[i][j] > dd[i - 1][j])
            {
                x[i] = true;
                j = j - workers[i - 1];
            }
        }
        for (int i = 1; i <= nbOfMine; i++)
        {
            if (x[i] == true)
            {
                System.out.println("mine No: " + i);
            }
        }
    }

    public static void main(String[] args)
    {

        System.out.println(calc1(5, 100));

    }

}
