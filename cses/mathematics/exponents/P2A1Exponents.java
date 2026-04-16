package cses.mathematics.exponents;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class P2A1Exponents {
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

    public static void print(Object o) {OUT.append(o);}
    public static void println(Object o) {OUT.append(o).append('\n');}
    public static void flush() {PW.print(OUT); PW.flush();}

    // Time Complexity - O(Q log b)
    public static void main(String args[]) throws IOException {
        int n = nextInt();
        for(int i = 0; i < n; i++)      // queries - O(Q)
            println(exp(nextInt(), nextInt()));     // compute - O(log b)
        flush();
    }

    public static final int MOD = 1_000_000_007;

    // Time Complexity - O(log b)
    public static long exp(long a, long b) {
        if(a == 0 && b == 0)
            return 1l;
        long r = 1l;
        while(b > 0) {      // Raising power via bits - O(log b)
            if((b & 1) != 0)
                r = (r * a) % MOD;      // one mod per cycle - O(1)
            a = (a * a) % MOD;          // one mod per cycle - O(1)
            b >>= 1;
        }
        return r;
    }
}
