package codeforces.pupil.rating1200;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

// https://codeforces.com/problemset/problem/1354/B
public class P1364B {
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
        while(t-- > 0)
            println(solve(next()));
        flush();
    }

    public static int solve(String s) {
        int n = s.length(), min = Integer.MAX_VALUE;
        int f[] = new int[4];
        int l = 0;
        for(int r = 0; r < n; r++) {
            int c = s.charAt(r) - '0';
            f[c]++;     // increase frequency
            while(f[1] > 0 && f[2] > 0 && f[3] > 0) {
                int len = r - l + 1;
                min = Math.min(len, min);
                int lc = s.charAt(l) - '0';
                f[lc]--;        // decrease frequency
                l++;
            }
        }
        if(min == Integer.MAX_VALUE)
            return 0;
        return min;
    }
}