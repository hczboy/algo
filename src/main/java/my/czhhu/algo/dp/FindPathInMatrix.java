package my.czhhu.algo.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * find a path from (0, 0) to (r, c)
 * 
 * */
public class FindPathInMatrix
{
    static class Point
    {
        int r;
        int c;

        public Point(int r2, int c2)
        {
            this.r = r2;
            this.c = c2;

        }

        @Override
        public String toString()
        {
            return "Point [r=" + r + ", c=" + c + "]";
        }

        @Override
        public int hashCode()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + c;
            result = prime * result + r;
            return result;
        }

        @Override
        public boolean equals(Object obj)
        {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Point other = (Point) obj;
            if (c != other.c)
                return false;
            if (r != other.r)
                return false;
            return true;
        }

    }

    static List<Point> getPath(boolean[][] maze)
    {
        if (maze == null || maze.length == 0)
            return null;
        List<Point> path = new ArrayList<>();
        boolean isSucc = getPath(maze, maze.length - 1, maze[0].length - 1, path);
        if (isSucc)
        {
            return path;
        }
        return null;
    }

    private static boolean getPath(boolean[][] maze, int r, int c, List<Point> path)
    {
        if (r < 0 || c < 0 || !maze[r][c])
        {
            return false;
        }

        boolean isOrigin = r == 0 && c == 0;
        if (isOrigin || getPath(maze, r - 1, c, path) || getPath(maze, r, c - 1, path))
        {
            path.add(new Point(r, c));
            return true;
        }
        return false;

    }

    static List<Point> getPathDP(boolean[][] maze)
    {
        if (maze == null || maze.length == 0)
            return null;
        List<Point> path = new ArrayList<>();
        Set<Point> failedPoints = new HashSet<>();
        //Boolean cache[][] = new Boolean[maze.length][maze[0].length];
        //  initCache(cache, maze);
        boolean isSucc = getPathDP(maze, maze.length - 1, maze[0].length - 1, path, failedPoints);
        if (isSucc)
        {
            return path;
        }
        return null;
    }

    /*
     *add cache to save intermediate result   
    */
    private static boolean getPathDP(boolean[][] maze, int r, int c, List<Point> path, Set<Point> failedPoints)
    {

        if (r < 0 || c < 0 || !maze[r][c])
        {

            return false;
        }

        Point p = new Point(r, c);
        if (failedPoints.contains(p))
        {
            return false;
        }

        boolean isOrigin = r == 0 && c == 0;
        if (isOrigin || getPathDP(maze, r - 1, c, path, failedPoints)
                || getPathDP(maze, r, c - 1, path, failedPoints))
        {
            path.add(new Point(r, c));

            return true;
        }
        failedPoints.add(p);
        return false;

    }

    public static void main(String[] args)
    {
        boolean[][] maze = { { true, true, false, false }, { true, true, true, false },
                { false, false, true, true } };

        List<Point> path = getPathDP(maze);
        System.out.println(path);

    }

}
