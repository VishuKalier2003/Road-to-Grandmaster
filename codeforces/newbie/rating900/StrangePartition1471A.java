package codeforces.newbie.rating900;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

// https://codeforces.com/problemset/problem/1471/A
public class StrangePartition1471A {
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

    public static void print(Object o) {OUT.append(o);}
    public static void println(Object o) {OUT.append(o).append('\n');}
    public static void flush() {PW.print(OUT); PW.flush();}

    public static void main(String args[]) throws IOException {
        int t = nextInt();
        while(t-->0) {
            int n = nextInt(), x = nextInt();
            int nums[] = new int[n];
            for(int i = 0; i < n;i++)
                nums[i] = nextInt();
            println(solve(n, x, nums));
        }
        flush();
    }

    public static String solve(int n, int x, int[] nums) {
    long totalSum = 0L;
    for (int a : nums) totalSum += a;
    // Minimum: merge everything into one → ceil(totalSum / x)
    long min = (long) Math.ceil((double) totalSum / x);
    // Maximum: keep each element separate → sum of ceil(a_i / x)
    long max = 0L;
    for (int a : nums)
        max += (long) Math.ceil((double) a / x);
    return min + " " + max;
}
}
