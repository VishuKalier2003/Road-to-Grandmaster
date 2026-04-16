package cses.mathematics.primefactors;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Q2A1Radical {
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

    // Time Complexity - O(sqrt(N))
    public static void main(String args[]) throws IOException {
        println(radical(nextInt()));
        flush();
    }

    // Time Complexity - O(sqrt(N))
    public static long radical(int n) {
        long radical = 1L;
        for(int i = 2; i * i <= n; i++) {       // factorization when factors are not known - O(sqrt(N))
            if(n % i == 0)
                radical *= i;
            while(n % i == 0)
                n /= i;
        }
        if(n > 1)           // If block - O(1)
            radical *= n;
        return radical;
    }
}
