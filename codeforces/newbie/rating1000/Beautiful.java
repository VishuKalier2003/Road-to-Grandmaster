package codeforces.newbie.rating1000;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://codeforces.com/contest/2203/problem/B
public class Beautiful {
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
        while(t-->0) {
            println(solve(next()));
        }
        flush();
    }

    public static int solve(String s) {
        List<Integer> lst = new ArrayList<>();
        int sum = 0, c = 0;
        for(int i = 0; i < s.length(); i++) {
            int d = s.charAt(i) - '0';
            sum+=d;
            if(i == 0)
                d--;
            lst.add(d);
        }
        Collections.sort(lst);
        for(int i = lst.size()-1; i >= 0 && sum > 9; i--, c++)
            sum -= lst.get(i);
        return c;
    }
}
