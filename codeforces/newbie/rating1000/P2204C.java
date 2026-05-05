package codeforces.newbie.rating1000;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

// https://codeforces.com/problemset/problem/2204/C
public class P2204C {
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
            println(solve(nextInt(), nextInt(), nextInt(), nextLong()));
        }
        flush();
    }

    public static String solve(int a, int b, int c, long d) {
        long s1 = inclusionExclusion(a, b, c, d);
        long s2 = inclusionExclusion(b, a, c, d);
        long s3 = inclusionExclusion(c, a, b, d);
        return s1 + " " + s2 + " " + s3;
    }

    public static long inclusionExclusion(long x, long y, long z, long m) {
        long c1 = xNm(x, m);
        long c2 = xNyNm(x, y, m) + xNyNm(x, z, m);
        long c3 = xNyNzNm(x, y, z, m);
        return (c1 - c2 + c3)*6 + (c2 - 2*c3)*3 + 2*c3;
    }

    public static long gcd(long a, long b) {
        if(b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    public static long xNm(long x, long m) {
        return m/x;
    }

    public static long xNyNm(long x, long y, long m) {
        return m/lcm(x, y);
    }

    public static long xNyNzNm(long x, long y, long z, long m) {
        return m/lcm(x, lcm(y, z));
    }
}
