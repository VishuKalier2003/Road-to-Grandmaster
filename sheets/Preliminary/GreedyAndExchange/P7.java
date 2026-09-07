package sheets.Preliminary.GreedyAndExchange;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.TreeMap;

// https://cses.fi/problemset/task/1632/
public class P7 {
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
        int nums[][] = new int[n][2];
        for(int i = 0; i < n; i++) {
            nums[i][0] = nextInt();
            nums[i][1] = nextInt();
        }
        print(solve(n, nums, k));
        flush();
    }

    private static long solve(int n, int nums[][], int k) {
        Arrays.sort(nums, (a, b) -> Integer.compare(a[1], b[1]));
        long cnt = 0l;
        TreeMap<Integer, Integer> availability = new TreeMap<>();
        availability.put(0, k);
        for(int i = 0; i < n; i++) {
            int s = nums[i][0], e = nums[i][1];
            Integer key = availability.floorKey(s);
            if(key == null) {
                continue;
            }
            int freq = availability.get(key);
            if(freq == 1)
                availability.remove(key);
            else
                availability.put(key, freq - 1);
            availability.put(e, availability.getOrDefault(e, 0) + 1);
            cnt++;
        }
        return cnt;
    }
}
