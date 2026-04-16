package codeforces.newbie.rating800;        // remove package declaration

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

// https://codeforces.com/problemset/problem/2217/A
public class Equalizer {
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

    public static void main(String args[]) throws IOException {
        int q = nextInt();
        for(int i = 0; i < q; i++) {
            int n = nextInt(), k = nextInt(), sum = 0;
            for(int j = 0; j < n; j++)
                sum += nextInt();
            boolean shaunak = ((sum & 1) == 1) || (((n * k) & 1) == 0);
            println(shaunak ? "Yes" : "No");
        }
        flush();
    }
}
