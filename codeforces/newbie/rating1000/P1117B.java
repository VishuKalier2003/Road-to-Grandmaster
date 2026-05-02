package codeforces.newbie.rating1000;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://codeforces.com/problemset/problem/1117/B
public class P1117B {
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
        int n = nextInt(), m = nextInt(), k = nextInt();
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i < n; i++)
            max.add(nextInt());
        println(solve(n, m, k, max));
        flush();
    }

    public static long solve(int n, int m, int k, PriorityQueue<Integer> max) {
        long m1 = max.poll();
        long m2 = max.poll();
        long fullBlocks = m / (k + 1);
        // m % (k+1) will only contain m1, so we can just add it to the result as there is only one m2 block
        long remaining = m % (k + 1);
        return fullBlocks * (k * m1 + m2) + remaining * m1;
    }
}
