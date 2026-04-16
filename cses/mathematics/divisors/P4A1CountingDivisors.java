package cses.mathematics.divisors;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class P4A1CountingDivisors {
    private static final DataInputStream IN = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
    private static final StringBuilder OUT = new StringBuilder();
    private static final PrintWriter PW = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static int nextInt() throws IOException {
        int c, x = 0;
        do{c = IN.read();} while(c < ' ');
        boolean neg = c == '-';
        if(neg) c = IN.read();
        do {
            x = x * 10 + (c - '0');
        }while((c = IN.read()) >= '0');
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

    public static String nextLine() throws IOException {
        int c;
        do {c = IN.read();} while(c == '\r' || c == '\n');
        StringBuilder sb = new StringBuilder();
        do {
            if(c == '\r') continue;
            sb.append((char)c);
        } while((c = IN.read()) != '\n' && c >= 0);
        return sb.toString();
    }

    public static void print(Object o) {OUT.append(o);}
    public static void println(Object o) {OUT.append(o).append('\n');}
    public static void flush() {PW.print(OUT); PW.flush(); OUT.setLength(0);}
    
    // time complexity - O(N log N + Q)
    public static void main(String args[]) throws IOException {
        sieveOfErasthosthenes();
        int n = nextInt();
        for(int i = 0; i < n; i++) {        // queries - O(Q)
            int x = nextInt();
            println(x == 1 ? 1 : s[x] + 2);     // compute - O(1)
        }
        flush();
    }

    public static final int B = 1_000_001;
    public static final int s[] = new int[B];

    // time complexity - O(N log N)
    public static void sieveOfErasthosthenes() {
        for(int i = 2; i < B; i++)          // linear - O(N)
            for(int j = 2 * i; j < B; j += i)   // harmonic sum - O(log N)
                s[j]++;
    }
}