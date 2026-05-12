package codeforces.newbie.rating1100;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

// https://codeforces.com/problemset/problem/2111/B
public class P2111B {
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
            int m = nextInt();
            int box[][] = new int[m][3];
            for(int i = 0; i < m; i++) {
                box[i][0] = nextInt();
                box[i][1] = nextInt();
                box[i][2] = nextInt();
            }
            println(solve(n, box, cube(n)));
        }
        flush();
    }

    public static String solve(int n, int box[][], int cube[]) {
        StringBuilder sb = new StringBuilder();
        for(int bx[] : box) {
            int x = bx[0], y = bx[1], z = bx[2], dec = cube[n];
            if(x - dec >= cube[n-1] && y - dec >= 0 && z - dec >= 0)
                sb.append("1");
            else if(y - dec >= cube[n-1] && x - dec >= 0 && z - dec >= 0)
                sb.append("1");
            else if(z - dec >= cube[n-1] && x - dec >= 0 && y - dec >= 0)
                sb.append("1");
            else
                sb.append("0");
        }
        return sb.toString();
    }

    public static int[] cube(int x) {
        int dp[] = new int[11];
        dp[1] = 1; dp[2] = 2;
        for(int i = 3; i <= 10; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp;
    }
}
