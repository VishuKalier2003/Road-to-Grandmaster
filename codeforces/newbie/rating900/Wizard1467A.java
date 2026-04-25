package codeforces.newbie.rating900;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

// https://codeforces.com/problemset/problem/1467/A
public class Wizard1467A {
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
            println(solveEditorial(nextInt()));
        }
        flush();
    }

    // Approach after reading Editorial
    public static String solveEditorial(int n) {
        StringBuilder sb = new StringBuilder();
        if(n == 1)
            return "9";
        if(n == 2)
            return "98";
        if(n == 3)
            return "989";
        sb.append("989");
        for(int i = 3; i < n; i++)
            sb.append((i-3) % 10);
        return sb.toString();
    }

    // My approach
    public static String solve(int n) {
        StringBuilder sb = new StringBuilder();
        if(n < 10) {
            int fIndex = n/2;
            int y = 9;
            for(int i = 0; i < n; i++, y += i <= fIndex ? -1 : 1) {
                sb.append(y);
            }
            return sb.toString();
        }
        boolean flag = false;
        int x = 9;
        for(int i = 0; i < n; i++, x += flag ? 1 : -1) {
            if(x < 0) {
                x = 1;
                flag = true;
            }
            if(x > 9) {
                x = 8;
                flag = false;
            }
            sb.append(x);
        }
        return sb.toString();
    }
}
