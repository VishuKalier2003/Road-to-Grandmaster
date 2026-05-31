package codeforces.specialist.rating1400;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class P797B {
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
        int n = nextInt();
        int nums[] = new int[n];
        for(int i = 0; i < n; i++)
            nums[i] = nextInt();
        println(solve(nums));
        flush();
    }

    public static long solve(int nums[]) {
        long sum = 0L;
        int minPositiveOdd = Integer.MAX_VALUE;
        int maxNegativeOdd = Integer.MIN_VALUE;
        for(int a : nums) {
            if(a > 0)
                sum += a;
            if(Math.abs(a) % 2 == 1) {
                if(a > 0)
                    minPositiveOdd = Math.min(minPositiveOdd, a);
                else
                    maxNegativeOdd = Math.max(maxNegativeOdd, a);
            }
        }
        // already odd
        if((sum & 1L) == 1L)
            return sum;
        long removePositive = Long.MAX_VALUE;
        long addNegative = Long.MAX_VALUE;
        if(minPositiveOdd != Integer.MAX_VALUE)
            removePositive = minPositiveOdd;
        if(maxNegativeOdd != Integer.MIN_VALUE)
            addNegative = -1L * maxNegativeOdd;
        return sum - Math.min(removePositive, addNegative);
    }
}
