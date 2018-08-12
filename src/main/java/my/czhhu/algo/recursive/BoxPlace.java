package my.czhhu.algo.recursive;

import java.util.Arrays;

public class BoxPlace
{

    static class Box implements Comparable<Box>
    {

        int height;
        int width;
        int length;

        public boolean canBeBottomAt(Box o)
        {
            if (o == null)
                return true;
            return height > o.height && width > o.width && length > o.length;
        }

        public boolean canBeAbove(Box b)
        {
            if (b == null)
                return true;

            return height < b.height && width < b.width && length > b.length;
        }

        @Override
        public int compareTo(Box b)
        {
            return b.height - height;

        }

    }

    static int boxPlace(Box[] boxs)
    {
        if (boxs == null || boxs.length == 0)
            return 0;

        Arrays.sort(boxs);
        int maxHeight = 0;
        for (int i = 0; i < boxs.length; i++)
        {
            int h = boxPlace(boxs, i);
            maxHeight = Math.max(h, maxHeight);
        }

        return maxHeight;
    }

    private static int boxPlace(Box[] boxs, int bi)
    {

        int max = 0;
        for (int i = bi + 1; i < boxs.length; i++)
        {
            if (boxs[bi].canBeBottomAt(boxs[i]))
            {
                int subh = boxPlace(boxs, i);
                max = Math.max(max, subh);
            }

        }

        return max + boxs[bi].height;
    }

    static int boxPlace1(Box[] boxs)
    {
        if (boxs == null || boxs.length == 0)
            return 0;

        Arrays.sort(boxs);

        return boxPlace1(boxs, null, 0);
    }

    private static int boxPlace1(Box[] boxs, Box lastBottom, int i)
    {
        if (i == boxs.length)
        {
            return 0;
        }

        int withPlaceBottom = 0, withNotPlacaBottom = 0;
        if (boxs[i].canBeAbove(lastBottom))
        {
            withPlaceBottom = boxPlace1(boxs, boxs[i], i + 1) + boxs[i].height;
        }
        else
        {
            withNotPlacaBottom = boxPlace1(boxs, lastBottom, i + 1);
        }
        return Math.max(withPlaceBottom, withNotPlacaBottom);
    }

    public static void main(String[] args)
    {
        // TODO Implement main
        throw new UnsupportedOperationException("main Not Implemented");

    }

}
