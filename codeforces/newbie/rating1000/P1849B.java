import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

public class P1849B {
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
        while(t-- > 0) {
            int n = nextInt(), k = nextInt();
            int nums[][] = new int[n][2];
            for(int i = 0; i < n; i++) {
                nums[i][0] = i;
                nums[i][1] = nextInt();
            }
            println(solve(n, k, nums));
        }
        flush();
    }

    public static String solve(int n, int k, int nums[][]) {
        for(int i = 0; i < n; i++)
            nums[i][1] = nums[i][1] % k == 0 ? k : nums[i][1] % k;
        // Comparing via lambda
        Arrays.sort(nums, Comparator.comparingInt((int x[]) -> x[1]).reversed().thenComparingInt(x -> x[0]));
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++)
            sb.append(nums[i][0]+1).append(" ");
        return sb.toString();
    }
}
