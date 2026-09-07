package sheets.Preliminary.Invariants;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

// https://cses.fi/problemset/task/1092/
public class P1 {
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
        print(solve(nextInt()));
        flush();
    }

    private static String solve(int n) {
        if(n % 4 == 2 || n % 4 == 1)
            return "NO\n";
        Set<Integer> s1 = new HashSet<>(), s2 = new HashSet<>();
        if(n % 4 == 3) {
            s1.add(1);
            s1.add(2);
            s2.add(3);
        }
        for(int i = n % 4 == 3 ? 4 : 1; i <= n; i += 4) {
            s1.add(i);
            s1.add(i + 3);
            s2.add(i + 1);
            s2.add(i + 2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("YES\n").append(s1.size()).append("\n");
        for(int a : s1)
            sb.append(a).append(" ");
        sb.append("\n").append(s2.size()).append("\n");
        for(int a : s2)
            sb.append(a).append(" ");
        return sb.toString();
    }
}