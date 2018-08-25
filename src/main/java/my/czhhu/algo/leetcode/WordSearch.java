package my.czhhu.algo.leetcode;

public class WordSearch
{

    static boolean search(char[][] grid, String w)
    {
        if (grid == null || grid.length == 0 || w == null || w.length() == 0)
            return false;
        if (grid[0].length == 0)
        {
            return false;
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int r = 0; r < grid.length; r++)
        {
            for (int c = 0; c < grid[0].length; c++)
            {
                if (dfs(grid, w, r, c, 0, visited))
                {
                    return true;
                }

            }

        }
        return false;

    }

    private static boolean dfs(char[][] grid, String w, int r, int c, int start, boolean[][] visited)
    {
        if (start == w.length())
        {
            return true;
        }
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || visited[r][c]
                || grid[r][c] != w.charAt(start))
        {
            return false;
        }

        visited[r][c] = true;
        boolean isSucc = dfs(grid, w, r, c - 1, start + 1, visited) || dfs(grid, w, r - 1, c, start + 1, visited)
                || dfs(grid, w, r, c + 1, start + 1, visited) || dfs(grid, w, r + 1, c, start + 1, visited);
        visited[r][c] = false;
        return isSucc;

    }

    public static void main(String[] args)
    {
        char[][] g = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };

        System.out.println(search(g, "ABCCED"));
        System.out.println(search(g, "SEE"));
        System.out.println(search(g, "ABCB"));

    }

}
