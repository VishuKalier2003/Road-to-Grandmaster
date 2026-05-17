package codeforces.pupil.rating1300;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class P1766C {
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
        int t = nextInt();
        while(t-- > 0) {
            int n = nextInt();
            String board[] = new String[2];
            board[0] = next();
            board[1] = next();
            println(solve(n, board) ? "YES" : "NO");
        }
        flush();
    }

    public static boolean solve(int n, String board[]) {
        if(board[0].charAt(0) == 'B' && board[1].charAt(0) == 'B')
            return state(n, board, 0) || state(n, board, 1);
        else
            return state(n, board, board[0].charAt(0) == 'B' ? 0 : 1);
    }

    public static boolean state(int n, String board[], int b) {
        for(int i = 0; i < n; i++) {
            if(board[b].charAt(i) != 'B')
                return false;
            if(board[b ^ 1].charAt(i) == 'B')
                b ^= 1;
        }
        return true;
    }
}
