package codeforces.pupil.rating1300;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

// https://codeforces.com/problemset/problem/1555/C
public class P1555C {
    private static final DataInputStream IN = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
    private static final StringBuilder OUT = new StringBuilder();
    private static final PrintWriter PW = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static int nextInt() throws IOException {
        int c, x = 0;
        do {c = IN.read();} while(c < ' ');
        boolean neg = c == '-';
        if(neg) c = IN.read();
        do {x = x * 10 + (c - '0');} while((c = IN.read()) >= '0');
        return neg ? -x : x;
    }

    public static long nextLong() throws IOException {
        int c;
        long x = 0l;
        do{c = IN.read();} while(c < ' ');
        boolean neg = c == '-';
        if(neg) c = IN.read();
        do {
            x = x * 10 + (c - '0');
        } while ((c = IN.read()) >= '0');
        return neg ? -x : x;
    }

    public static String next() throws IOException {
        int c;
        do {c = IN.read();} while(c < ' ');
        StringBuilder sb = new StringBuilder();
        do {
            sb.append((char)c);
        } while((c = IN.read()) > ' ');
        return sb.toString();
    }

    public static void print(Object o) {OUT.append(o);}
    public static void println(Object o) {OUT.append(o).append('\n');}
    public static void flush() {PW.print(OUT); PW.flush();}

    public static void main(String args[]) throws IOException {
        int t = nextInt();
        while(t-- > 0) {
            int n = nextInt();
            int nums[][] = new int[2][n];
            for(int i = 0; i < n; i++)
                nums[0][i] = nextInt();
            for(int i = 0; i < n; i++)
                nums[1][i] = nextInt();
            println(solve(n, nums));
        }
        flush();
    }

    public static long solve(int n, int nums[][]) {
        // nums[0] = top row (row1), nums[1] = bottom row (row2)
        long[] pref2 = new long[n + 1];           // pref2[i] = sum of row2[0 .. i-1]
        for (int i = 0; i < n; i++)
            pref2[i + 1] = pref2[i] + nums[1][i];
        long[] suff1 = new long[n + 2];           // suff1[i] = sum of row1[i-1 .. n-1]
        for (int i = n; i >= 1; i--)
            suff1[i] = suff1[i + 1] + nums[0][i - 1];
        long ans = Long.MAX_VALUE;
        for (int k = 1; k <= n; k++) {
            long bob = Math.max(pref2[k - 1], suff1[k + 1]);
            ans = Math.min(ans, bob);
        }
        return ans;
    }
}
