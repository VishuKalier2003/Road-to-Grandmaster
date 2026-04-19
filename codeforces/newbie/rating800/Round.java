package codeforces.newbie.rating800;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

// https://codeforces.com/problemset/problem/1352/A
public class Round {
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
    public static void main(String[] args) throws IOException {
        int t = nextInt();
        while(t-->0) {
            println(solve(nextInt()));
        }
        flush();
    }

    public static String solve(int n) {
        StringBuilder sb = new StringBuilder();
        int c = 0, p = 1;
        while(n != 0) {
            int digit = n % 10;
            int num = p * digit;
            if(digit != 0) {
                sb.append(num).append(" "); c++;
            }
            p *= 10;
            n/=10;
        }
        return c + "\n" + sb.toString();
    }
}
