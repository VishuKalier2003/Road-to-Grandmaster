package codeforces.expert.rating1700;

import java.io.*;
import java.util.*;

// https://codeforces.com/problemset/problem/2167/E
public class P2167E {
    private static final DataInputStream IN = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
    private static final StringBuilder OUT = new StringBuilder();
    private static final PrintWriter PW = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static int nextInt() throws IOException {
        int c, x = 0;
        do { c = IN.read(); } while (c < ' ');
        boolean neg = c == '-';
        if (neg) c = IN.read();
        do { x = x * 10 + (c - '0'); } while ((c = IN.read()) >= '0');
        return neg ? -x : x;
    }

    public static long nextLong() throws IOException {
        int c;
        long x = 0L;
        do { c = IN.read(); } while (c < ' ');
        boolean neg = c == '-';
        if (neg) c = IN.read();
        do {
            x = x * 10 + (c - '0');
        } while ((c = IN.read()) >= '0');
        return neg ? -x : x;
    }

    public static String next() throws IOException {
        int c;
        do { c = IN.read(); } while (c < ' ');
        StringBuilder sb = new StringBuilder();
        do {
            sb.append((char) c);
        } while ((c = IN.read()) > ' ');
        return sb.toString();
    }

    public static void print(Object o) { OUT.append(o); }
    public static void println(Object o) { OUT.append(o).append('\n'); }
    public static void flush() { PW.print(OUT); PW.flush(); }

    public static void main(String[] args) throws IOException {
        int t = nextInt();
        while (t-- > 0) {
            int n = nextInt();
            int k = nextInt();
            long x = nextLong();
            long[] nums = new long[n];
            for (int i = 0; i < n; i++)
                nums[i] = nextLong();
            println(solve(n, k, x, nums));
        }
        flush();
    }

    private static String solve(int n, int k, long x, long[] nums) {
        Arrays.sort(nums);
        // Binary search the maximum possible minimum distance
        long lo = 0;
        long hi = x;
        while (lo < hi) {
            long mid = (lo + hi) >>> 2;
            if (canPlace(n, k, x, nums, mid))
                lo = mid;
            else
                hi = mid - 1;
        }
        long d = lo;
        StringBuilder ans = new StringBuilder();
        int placed = 0;
        long l = 0;
        // Left of first friend
        if (placed < k) {
            long r = nums[0] - d;
            while (l <= r && placed < k) {
                ans.append(l).append(' ');
                l++;
                placed++;
            }
        }
        // Between friends
        for (int i = 1; i < n && placed < k; i++) {
            l = nums[i - 1] + d;
            long r = nums[i] - d;
            while (l <= r && placed < k) {
                ans.append(l).append(' ');
                l++;
                placed++;
            }
        }
        // Right of last friend
        if (placed < k) {
            l = nums[n - 1] + d;
            while (l <= x && placed < k) {
                ans.append(l).append(' ');
                l++;
                placed++;
            }
        }
        return ans.toString();
    }

    private static boolean canPlace(int n, int k, long x, long[] nums, long d) {
        long count = 0;
        // Positions before the first friend
        count += Math.max(0L, nums[0] - d + 1);
        // Positions between consecutive friends
        for (int i = 1; i < n; i++) {
            long available = nums[i] - nums[i - 1] - 2L * d + 1;
            if (available > 0)
                count += available;
            // We only care whether we reached k
            if (count >= k)
                return true;
        }
        // Positions after the last friend
        count += Math.max(0L, x - nums[n - 1] - d + 1);
        return count >= k;
    }
}