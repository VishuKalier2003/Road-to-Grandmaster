package codeforces.newbie.rating900;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

// https://codeforces.com/problemset/problem/1624/B
public class MakeAP1624B {
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
            int a = nextInt(), b = nextInt(), c = nextInt();
            boolean ok = false;
            long nA = 2*b - c - 0l;
            if(nA > 0 && nA % a == 0)
                ok = true;
            if((a+c) % 2 == 0) {
                long nB = (a + c) / 2;
                if(nB > 0 && nB % b == 0)
                    ok = true;
            }
            long nC = 2*b - a - 0l;
            if(nC > 0 && nC % c == 0)
                ok = true;
            println(ok ? "yes" : "no");
        }
        flush();
    }
}