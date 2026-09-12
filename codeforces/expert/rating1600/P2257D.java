package codeforces.expert.rating1600;

import java.io.*;
import java.util.*;

// https://codeforces.com/problemset/problem/2257/D
public class P2257D {
    private static final DataInputStream IN = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
    private static final StringBuilder OUT = new StringBuilder();
    private static final PrintWriter PW = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    private static long nextLong() throws IOException {
        int c;
        long x = 0;
        do c = IN.read(); while (c <= ' ');
        while (c >= '0' && c <= '9') {
            x = x * 10 + c - '0';
            c = IN.read();
        }
        return x;
    }

    public static void main(String[] args) throws Exception {
        int t = (int) nextLong();
        while (t-- > 0) {
            long s = nextLong();
            int q = (int) nextLong();
            long[] qx = new long[q];
            long[] qy = new long[q];
            for (int i = 0; i < q; i++) {
                qx[i] = nextLong();
                qy[i] = nextLong();
            }
            solve(s, qx, qy);
        }
        PW.print(OUT);
        PW.flush();
    }

    private static void solve(long s, long[] qx, long[] qy) {
        List<Long> div = new ArrayList<>();
        for (long i = 1; i <= s / i; i++) {     // Divisors of S
            if (s % i == 0) {
                div.add(i);
                if (i * i != s) div.add(s / i);
            }
        }
        Collections.sort(div);      // sorting the divisors for the binary search
        int n = div.size();
        long[] x = new long[n];     // Array to store the changes in height
        long[] h = new long[n];     // Array to store height
        long[] pre = new long[n];
        for (int i = 0; i < n; i++) {
            x[i] = i == 0 ? 0 : div.get(i - 1);
            h[i] = s / div.get(i);
        }
        // Prefix computation
        for (int i = 1; i < n; i++)
            pre[i] = pre[i - 1] + (x[i] - x[i - 1]) * h[i - 1];
        for (int i = 0; i < qx.length; i++)
            OUT.append(query(qx[i], qy[i], x, h, pre, s)).append('\n');
    }

    private static long query(long qx, long qy, long[] x, long[] h, long[] pre, long s) {
        int i = firstHeightAtMost(h, qy);
        if (i == h.length)
            return qx * qy;
        long cut = x[i];
        if (qx <= cut)
            return qx * qy;
        long ans = cut * qy;
        ans += area(qx, x, h, pre);
        if (cut > 0)
            ans -= area(cut, x, h, pre);
        return ans;
    }

    private static long area(long p, long[] x, long[] h, long[] pre) {
        int i = upperBound(x, p) - 1;
        if (i < 0) return 0;
        return pre[i] + (p - x[i]) * h[i];
    }

    private static int firstHeightAtMost(long[] h, long v) {
        int l = 0, r = h.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (h[m] <= v) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private static int upperBound(long[] a, long v) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (a[m] <= v) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}