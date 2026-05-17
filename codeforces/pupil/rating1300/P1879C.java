package codeforces.pupil.rating1300;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class P1879C {
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
        long dp[] = factorial(1_000_000);
        while(t-- > 0) {
            String s = next();
            println(solve(s.length(), s, dp));
        }
        flush();
    }

    public static final int MOD = 998244353;

    public static String solve(int n, String s, long dp[]) {
        List<Integer> segs = new ArrayList<>();
        int seg = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) seg++;
            else { segs.add(seg); seg = 1; }
        }
        segs.add(seg);
        long totalDel = 0;
        long prodLen = 1;
        for (int len : segs) {
            totalDel += len - 1;
            prodLen = prodLen * len % MOD;
        }
        long ways = prodLen * dp[(int) totalDel] % MOD;
        return totalDel + " " + ways;
    }

    public static long[] factorial(int max) {
        long dp[] = new long[max+1];
        dp[0] = 1l;
        dp[1] = 1l;
        for(int i = 2; i <= max; i++)
            dp[i] = ((dp[i-1] * i) % MOD);
        return dp;
    }
}
