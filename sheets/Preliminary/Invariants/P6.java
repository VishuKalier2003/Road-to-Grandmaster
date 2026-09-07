package sheets.Preliminary.Invariants;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.PriorityQueue;

public class P6 {
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
        int nums[] = new int[n];
        for(int i = 0; i < n; i++)
            nums[i] = nextInt();
        print(solve(n, nums));
        flush();
    }

    private static String solve(int n, int nums[]) {
    StringBuilder sb = new StringBuilder();
    PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
    for (int i = 0; i < n; i++)
        heap.add(new int[]{nums[i], i});
    long total = 0;
    while (!heap.isEmpty()) {
        // top[0] = remaining degree, top[1] = player ID
        int[] top = heap.poll();
        int degree = top[0];
        if (degree > heap.size())
            return "IMPOSSIBLE";
        int[][] selected = new int[degree][];
        for (int i = 0; i < degree; i++) {
            selected[i] = heap.poll();
            if (selected[i][0] <= 0)
                return "IMPOSSIBLE";
            sb.append(top[1] + 1).append(" ").append(selected[i][1] + 1).append("\n");
            selected[i][0]--;
            total++;
        }
        // ONLY NOW put them back
        for (int i = 0; i < degree; i++)
            if (selected[i][0] > 0)
                heap.add(selected[i]);
        }
        return total + "\n" + sb;
    }
}
