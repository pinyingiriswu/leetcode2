public class d31_1024_video_stitching {
    /** Time: O(n^2)
     * Space: O(n) */
    public int videoStitching(int[][] clips, int T) {
        //store the largest ending range we can cover for each start
        int[] dp = new int[T + 1];
        for (int[] clip: clips) {
            if (clip[0] > T) continue;
            dp[clip[0]] = Math.max(dp[clip[0]], clip[1]);
        }

        int curEnd = dp[0]; //largest end starting from 0
        int res = 1;
        int i = 1; //start iterate from 1

        // stops looping when curEnd is larger than or equals to T
        while (curEnd < T) {
            int nextMaxEnd = 0;
            // find the largest cover range from 1 ~ curEnd
            for (int j = i; j <= curEnd; j++) {
                nextMaxEnd = Math.max(nextMaxEnd, dp[j]);
            }
            // if nextMaxEnd is smaller than curEnd, that means we can't connect the clips together
            if (nextMaxEnd <= curEnd) {
                return -1;
            }
            // else, if nextMaxEnd is larger than curEnd, we start iterate from curEnd + 1
            i = curEnd + 1;
            // update largest cover range to nextMaxEnd
            curEnd = nextMaxEnd;
            res++;
        }
        return res;
    }
}
