package codeforces.newbie.rating1000;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

// https://codeforces.com/problemset/problem/1622/B
public class P1622B {
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
            int nums[][] = new int[n][4];
            for(int i = 0; i < n; i++) {
                nums[i][0] = nextInt();
                nums[i][2] = i;
            }
            String s = next();
            for(int i = 0; i < n; i++)
                nums[i][1] = s.charAt(i) - '0';
            println(solve(n, nums));
        }
        flush();
    }

    public static String solve(int n, int nums[][]) {
        int p = 1;
        Arrays.sort(nums, Comparator.comparingInt((int[] a) -> a[1]).thenComparingInt(a -> a[0]));
        for(int i = 0; i < n; i++)
            nums[i][3] = p++;
        int ans[] = new int[n];
        for(int i = 0; i < n; i++)
            ans[nums[i][2]] = nums[i][3];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++)
            sb.append(ans[i]).append(' ');
        return sb.toString();
    }
}