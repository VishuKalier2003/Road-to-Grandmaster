package codeforces.pupil.rating1200;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

// https://codeforces.com/contest/961/problem/B
public class P961B {
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
        int n = nextInt(), k = nextInt();
        int lec[] = new int[n], s[] = new int[n];
        for(int i = 0; i < n; i++)
            lec[i] = nextInt();
        for(int i = 0; i < n; i++)
            s[i] = nextInt();
        println(solve(n, k, lec, s));
        flush();
    }

    public static long solve(int n, int k, int lec[], int s[]) {
        long a = s[0] == 1 ? lec[0] : 0;
        long dp[] = new long[n];
        dp[0] = s[0] == 1 ? 0 : lec[0];
        for(int i = 1; i < n; i++) {
            dp[i] = s[i] == 0 ? dp[i-1] + lec[i] : dp[i-1];
            a += s[i] == 1 ? lec[i] : 0;
        }
        long max = dp[k-1];
        for(int i = k; i < n; i++)
            max = Math.max(max, dp[i] - dp[i-k]);
        return a + max;
    }
}
