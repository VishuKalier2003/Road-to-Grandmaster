package sheets.Preliminary.Invariants;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Set;
import java.util.TreeSet;

// https://cses.fi/problemset/task/1730/
public class P4 {
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
        int n = nextInt(), k = nextInt();
        TreeSet<Integer> nums = new TreeSet<>();
        for(int i = 0; i < k; i++)
            nums.add(nextInt());
        print(solve(n, nums));
        flush();
    }

    public static String solve(int n, Set<Integer> nums) {
        StringBuilder sb = new StringBuilder();
        boolean dp[] = new boolean[n+1];
        for(int i = 1; i <= n; i++) {
            for(int num : nums) {
                if(num > i)
                    continue;
                if(!dp[i - num]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        for(int i = 1; i <= n; i++)
            sb.append(dp[i] ? 'W' : 'L');
        return sb.toString();
    }
}
