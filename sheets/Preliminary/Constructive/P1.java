package sheets.Preliminary.Constructive;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


// https://cses.fi/problemset/task/1071/
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
        int n = nextInt();
        int nums[][] = new int[n][2];
        for(int i = 0; i < n; i++) {
            nums[i][0] = nextInt();
            nums[i][1] = nextInt();
        }
        print(solveNoDp(nums));
        flush();
    }

    private static String solve(int nums[][], int max) {
        long dp[] = new long[max+1];
        dp[1] = 1;
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= max; i++)
            dp[i] += dp[i-1] + (2 * (i-1));
        for(int q[] : nums) {
            int x = q[0], y = q[1];
            int m = Math.max(x, y);
            if(x == m) {
                int diff = Math.abs(m - y);
                sb.append(dp[m] + ((m % 2 == 0) ? diff : -diff)).append("\n");
            }
            else {
                int diff = Math.abs(m - x);
                sb.append(dp[m] + ((m % 2 == 0) ? -diff : diff)).append("\n");
            }
        }
        return sb.toString();
    }

    private static String solveNoDp(int[][] nums) {
        StringBuilder sb = new StringBuilder();
        for (int[] query : nums) {
            long x = query[0], y = query[1], m = Math.max(x, y), diagonal = m * m - m + 1;
            long answer;
            if (x == m) {
                long diff = m - y;
                answer = diagonal + (m % 2 == 0 ? diff : -diff);
            } else {
                long diff = m - x;
                answer = diagonal + (m % 2 == 0 ? -diff : diff);
            }
            sb.append(answer).append('\n');
        }
        return sb.toString();
    }
}
