package sheets.Preliminary.GreedyAndExchange;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;


// https://cses.fi/problemset/task/1091/
public class P2 {
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
        int n = nextInt(), m = nextInt();
        // sorting and storing frequency while taking input
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        for(int i = 0; i < n; i++) {
            int num = nextInt();
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
        int a[] = new int[m];
        for(int i = 0; i < m; i++)
            a[i] = nextInt();
        print(solveFast(n, m, mp, a));
        flush();
    }

    private static String solve(int n, int m, TreeMap<Integer, Integer> mp, int nums[]) {
        StringBuilder sb = new StringBuilder();
        for(int num : nums) {
            // finding values that cannot be mapped (edge cases)
            Integer key = mp.floorKey(num);
            if(key == null) {
                sb.append("-1").append("\n");
            }
            else {
                sb.append(key).append("\n");
                if(mp.get(key) == 1)    // dynamic removal of keys from the map to avoid TLE
                    mp.remove(key);
                else
                    mp.put(key, mp.get(key) - 1);
            }
        }
        return sb.toString();
    }

    private static String solveFast(int n, int m, TreeMap<Integer, Integer> mp, int nums[]) {
        StringBuilder sb = new StringBuilder();
        for(int num : nums) {
            Map.Entry<Integer, Integer> entry = mp.floorEntry(num);
            if(entry == null) {
                sb.append("-1").append("\n");
            }
            else {
                int p = entry.getKey();
                sb.append(p).append("\n");
                int cnt = entry.getValue()-1;
                if(cnt == 0)
                    mp.remove(p);
                else
                    mp.put(p, cnt);
            }
        }
        return sb.toString();
    }
}
