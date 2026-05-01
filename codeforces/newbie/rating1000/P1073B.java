package codeforces.newbie.rating1000;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

// https://codeforces.com/problemset/problem/1073/B
public class P1073B {
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
        int n = nextInt();
        int n1[] = new int[n], n2[] = new int[n];
        for(int j = 0; j < n; j++)
            n1[j] = nextInt();
        for(int j = 0; j < n; j++)
            n2[j] = nextInt();
        println(solve(n, n1, n2));
        flush();
    }

    public static String solve(int n, int nums1[], int nums2[]) {
        int j = 0, x;
        StringBuilder sb = new StringBuilder();
        Set<Integer> b = new HashSet<>();
        for(int i = 0; i < n; i++) {
            int book = nums2[i];
            x = 0;
            while(j < n && !b.contains(book)) {
                b.add(nums1[j]);
                j++;
                x++;
            }
            sb.append(x).append(' ');
        }
        return sb.toString();
    }
}
